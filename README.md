## HeadlineHub

**Welcome to HeadlineHub, a news application built with MVVM architecture and Jetpack Compose.**

![Blue Breaking News YouTube Channel Art](https://github.com/praveenpayasi/HeadlineHub/assets/13694253/11667c7c-c848-4b22-89ba-29ce2ba8b397)


  ## Major Highlights

- **Jetpack Compose** for modern UI
- **Offline caching** with a **single source of truth**
- **MVVM architecture** for a clean and scalable codebase
- **Kotlin** and **Kotlin DSL**
- **Dagger Hilt** for efficient dependency injection.
- **Retrofit** for seamless networking
- **Room DB** for local storage of news articles
- **Coroutines** and **Flow** for asynchronous programming
- **StatFlow** for streamlined state management
- **Pagination** to efficiently load and display news articles
- **Unit tests** and **UI tests** for robust code coverage
- **Instant search** for quick access to relevant news
- **Navigation** for smooth transitions between screens
- **WorkManager** for periodic news fetching
- **Notification** for alerting about latest news
- **Coil** for efficient image loading


  ![mvvm-architecture](screenshots/mvvm_archi.jpg)
  

- ## Feature implemented:
- NewsApp
- Instant search using Flow operators
    - Debounce
    - Filter
    - DistinctUntilChanged
    - FlatMapLatest
- Offline news
- Pagination
- Unit Test
    - Mockito
    - Turbine https://github.com/cashapp/turbine
    - Espresso
- TopHeadlines of the news
- Country-wise news
- Multiple Languages selection-wise news
- Multiple sources wise news

## Dependency Use

- Jetpack Compose for UI: Modern UI toolkit for building native Android UIs
- Coil for Image Loading: Efficiently loads and caches images
- Retrofit for Networking: A type-safe HTTP client for smooth network requests
- Dagger Hilt for Dependency Injection: Simplifies dependency injection
- Room for Database: A SQLite object mapping library for local data storage
- Paging Compose for Pagination: Simplifies the implementation of paginated lists
- Mockito, JUnit, Turbine for Testing: Ensures the reliability of the application

##  Dependency Used:

- UI
```
implementation ("androidx.compose.ui:ui")
implementation ("androidx.compose.ui:ui-graphics")
implementation ("androidx.compose.ui:ui-tooling-preview")
implementation ("androidx.compose.foundation:foundation")
implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
implementation ("androidx.activity:activity-compose:1.8.2")
implementation(platform("androidx.compose:compose-bom:2023.08.00"))
```

- Material3
```
implementation ("androidx.compose.material3:material3:1.1.2")
```

- Navigation
```
implementation ("androidx.hilt:hilt-navigation-compose:1.1.0")
implementation ("androidx.navigation:navigation-compose:2.7.6")
```

- Coil for image loading
```
implementation ("io.coil-kt:coil-compose:2.4.0")
```

- Retrofit for networking
```
 implementation("com.squareup.retrofit2:retrofit:2.9.0")
 implementation("com.squareup.retrofit2:converter-gson:2.9.0")
 implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
```
- Paging library
```
implementation 'androidx.paging:paging-runtime-ktx:3.2.1'
implementation 'androidx.paging:paging-compose:3.2.1'
```

- Dagger hilt for dependency injection
```
 implementation("com.google.dagger:hilt-android:2.44")
 kapt("com.google.dagger:hilt-android-compiler:2.44")
```

- For webView browser
```
implementation 'androidx.browser:browser:1.4.0'
```

- Room database
```
implementation ("androidx.room:room-runtime:2.5.0")
kapt ("androidx.room:room-compiler:2.6.1")
// optional - Kotlin Extensions and Coroutines support for Room
implementation ("androidx.room:room-ktx:2.5.0")
```

- WorkManager
```
 implementation("androidx.work:work-runtime-ktx:2.9.0")
 implementation("androidx.hilt:hilt-work:1.1.0")
 kapt("androidx.hilt:hilt-compiler:1.1.0")
```
- Local Unit test
```
testImplementation 'junit:junit:4.13.2'
testImplementation "org.mockito:mockito-core:5.3.1"
testImplementation 'androidx.arch.core:core-testing:2.2.0'
testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3'
testImplementation 'app.cash.turbine:turbine:0.12.1'
```
- UI Test
```
androidTestImplementation 'androidx.test.ext:junit:1.1.5'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
androidTestImplementation platform('androidx.compose:compose-bom:2023.03.00')
androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
androidTestImplementation 'androidx.navigation:navigation-testing:2.6.0'
debugImplementation 'androidx.compose.ui:ui-tooling'
debugImplementation 'androidx.compose.ui:ui-test-manifest'
```

## The Complete Project Folder Structure

```
└── com
    └── praveenpayasi
        └── headlinehub
            ├── HeadlineHubApplication.kt
            ├── data
            │   ├── api
            │   │   ├── ApiKeyInterceptor.kt
            │   │   └── NetworkService.kt
            │   ├── local
            │   │   ├── AppDatabaseService.kt
            │   │   ├── DatabaseService.kt
            │   │   ├── NewsAppDatabase.kt
            │   │   ├── dao
            │   │   │   ├── SourceDao.kt
            │   │   │   └── TopHeadlinesDao.kt
            │   │   └── entity
            │   │       ├── TopHeadlineEntity.kt
            │   │       ├── NewsSources.kt
            │   │       └── Source.kt
            │   ├── model
            │   │   ├── Country.kt
            │   │   ├── Language.kt
            │   │   ├── newssources
            │   │   │   ├── APINewsSource.kt
            │   │   │   └── NewsSourcesResponse.kt
            │   │   └── topheadlines
            │   │       ├── ApiTopHeadlines.kt
            │   │       ├── ApiSource.kt
            │   │       └── TopHeadlinesResponse.kt
            │   └── repository
            │       ├── CountryListRepository.kt
            │       ├── LanguageListRepository.kt
            │       ├── NewsRepository.kt
            │       ├── NewsSourceRepository.kt
            │       ├── OfflineTopHeadlineRepository.kt
            │       ├── TopHeadlinePaginationRepository.kt
            │       ├── SearchRepository.kt
            │       ├── TopHeadlinePagingSource.kt
            │       └── TopHeadlineRepository.kt
            ├── di
            │   ├── module
            │   │   └── ApplicationModule.kt
            │   └── qualifier.kt
            ├── ui
            │   ├── MainActivity.kt
            │   ├── base
            │   │   ├── CommonUI.kt
            │   │   ├── Navigation.kt
            │   │   └── UiState.kt
            │   ├── country
            │   │   ├── CountryListScreen.kt
            │   │   └── CountryListViewModel.kt
            │   ├── home
            │   │   └── HomeScreenRoute.kt
            │   ├── language
            │   │   ├── LanguageListScreen.kt
            │   │   └── LanguageListViewModel.kt
            │   ├── news
            │   │   ├── NewsListScreen.kt
            │   │   └── NewsListViewModel.kt
            │   ├── offline
            │   │   ├── OffineTopHeadlineScreen.kt
            │   │   └── OfflineTopHeadlineViewModel.kt
            │   ├── pagination
            │   │   ├── TopHeadlinePaginationScreen.kt
            │   │   └── TopHeadlinePaginationViewModel.kt
            │   ├── search
            │   │   ├── SearchScreen.kt
            │   │   └── SearchViewModel.kt
            │   ├── sources
            │   │   ├── NewsSourcesScreen.kt
            │   │   └── NewsSourcesViewModel.kt
            │   ├── theme
            │   │   ├── Color.kt
            │   │   ├── Shape.kt
            │   │   ├── Theme.kt
            │   │   └── Type.kt
            │   └── topheadline
            │       ├── TopHeadlineRoute.kt
            │       └── TopHeadlineViewModel.kt
            ├── utils
            │   ├── AppConstant.kt
            │   ├── DispatcherProvider.kt
            │   ├── NetworkHelper.kt
            │   ├── NetworkHelperImpl.kt
            │   ├── TimeUtil.kt
            │   ├── logger
            │   │   ├── AppLogger.kt
            │   │   └── Logger.kt
            │   └── typealias.kt
            └── worker
                └── FetchTopHeadlinesWorker.kt
```

| Home Screen | News detail | Search Screen | News Sources |
| ----------- | ----------- | ----------- | ----------- |
| ![HomeScreen](screenshots/home_screen.png) | ![NewsDetail](screenshots/web_view.png) | ![SearchScreen](screenshots/search_screen.png) | ![NewsSources](screenshots/news_sources.png) |

## 🚀 About Me
Hi there! My name is Praveen Payasi, I work as a Senior Consultant and like to expand my skill set in my spare time.

If you have any questions or want to connect, feel free to reach out to me on :

- [LinkedIn](https://www.linkedin.com/in/praveen-payasi-b9720590)
- [GitHub](https://github.com/praveenpayasi)
