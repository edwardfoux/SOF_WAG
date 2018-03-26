
#### Overview

This application displays the first page from the StackOverflow API url:

https://api.stackexchange.com/2.2/users?site=stackoverflow

The payload is displayed in the form of the scrollable list with a few engagement elements for each item:

* Author’s name
* Author’s location
* Button to transition to author’s website

#### Architecture
* This project is implemented with MVVM architecture pattern. This structure consists of 3 parts:
* View - an activity that displays the list in RecyclerView
* Model -  parcelable Kotlin data classes with optional values to prevent NPE.
* ViewModel - observable business logic for fetching the payload from remote data source. ViewModel has no reference to the view, but provides observable data collection, that the view react to.

#### The following libraries were used:
* Android architecture components for managing ViewModel and LiveData components
* Glide for image loading and caching for possible reuse
* RecyclerView with ViewHolder pattern to properly reused view in the list components
* RxJava for efficient threads transition during the data loading from remote data source
* Retrofit for loading data from remote data source
* Butterknife for view binding
* ConstraintLayout for flat hierarchy in the view holder

