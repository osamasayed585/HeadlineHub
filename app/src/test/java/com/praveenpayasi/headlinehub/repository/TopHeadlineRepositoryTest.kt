package com.praveenpayasi.headlinehub.repository

import app.cash.turbine.test
import com.praveenpayasi.headlinehub.data.api.NetworkService
import com.praveenpayasi.headlinehub.data.model.topheadlines.ApiSource
import com.praveenpayasi.headlinehub.data.model.topheadlines.ApiTopHeadlines
import com.praveenpayasi.headlinehub.data.model.topheadlines.TopHeadlinesResponse
import com.praveenpayasi.headlinehub.data.repository.TopHeadlineRepository
import com.praveenpayasi.headlinehub.ui.utils.AppConstant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TopHeadlineRepositoryTest {

    @Mock
    private lateinit var networkService: NetworkService

    private lateinit var topHeadlineRepository: TopHeadlineRepository

    @Before
    fun setUp() {
        topHeadlineRepository = TopHeadlineRepository(networkService)
    }

    @Test
    fun getTopHeadlines_whenNetworkServiceResponseSuccess_shouldReturnSuccess() {
        runTest {
            val country = AppConstant.COUNTRY
            val apiSource = ApiSource(id = "SourceId", name = "sourceName")
            val apiArticle = ApiTopHeadlines(
                title = "title",
                description = "description",
                url = "url",
                imageUrl = "urlToImage",
                apiSource = apiSource
            )

            val listOfArticleAPI = mutableListOf<ApiTopHeadlines>()
            listOfArticleAPI.add(apiArticle)

            val topHeadlinesResponse = TopHeadlinesResponse(
                status = "ok", totalResults = 1, apiTopHeadlines = listOfArticleAPI
            )

            doReturn(topHeadlinesResponse)
                .`when`(networkService).getTopHeadlines(country)

            topHeadlineRepository.getTopHeadlines(country).test {
                assertEquals(topHeadlinesResponse.apiTopHeadlines, awaitItem())
                cancelAndIgnoreRemainingEvents()
            }

            verify(networkService, times(1)).getTopHeadlines(country)
        }
    }

    @Test
    fun getTopHeadlines_whenNetworkServiceResponseError_shouldReturnError() {
        runTest {
            val country = AppConstant.COUNTRY
            val errorMessage = "Enter Message For You"

            doThrow(RuntimeException(errorMessage)).`when`(networkService)
                .getTopHeadlines(country)

            topHeadlineRepository.getTopHeadlines(country).test {
                assertEquals(errorMessage, awaitError().message)
                cancelAndIgnoreRemainingEvents()
            }
            verify(networkService, times(1)).getTopHeadlines(country)
        }
    }
}