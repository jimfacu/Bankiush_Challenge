#Bankiush Challenge

Bankiush Challenge is a app that show you a category of repositories from GitHub.

## Description

By Retrofit we request to the GITHUB API repositories of kotlin category , and save the results to show in a list. 
We parse JSON objects to KOTLIN objects using the Google GSON library, the information show in recyclerView there is also the possibility to tap on specific repository 
and go to second screen to show the detail of the repository.

## libraries

WEB SERVICES

  * **Retrofit**          'com.squareup.retrofit2:retrofit:2.9.0'
  * **API** **REST** **GITHUB**   
   
EXTRA COMPLEMENTS
   
  * **SwipeRefresh**     "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
  * **GSONParser**       'com.squareup.retrofit2:converter-gson:2.9.0'
  * **Coroutines**       'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'
  * **Navigation**       'androidx.navigation:navigation-fragment-ktx:2.4.1'
  * **Dagger**           "com.google.dagger:hilt-android:2.37"
  * **UnitTest**         'testImplementation 'androidx.arch.core:core-testing:2.1.0'
  * **MOCKK**            'testImplementation 'io.mockk:mockk:1.12.2'
 
# MATERIAL ELEMENTS

    - RecyclerView
    - ProgressBar
    
    
