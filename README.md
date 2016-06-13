# Githubbi

Simple Android app that searches github repositories and opens them in a webview.

## Architecture

__Tools Used__
* Retrofit (api consumption)
* GSON (JSON parser)
* RXJava - Observable pattern abstraction
* Databinder library

Much of the architecture was dictated by patterns created by the Databinder API. I originally wanted to start with an MVC inspired architecture but the whole Activity object really throws a wrench in that Pattern. I've added an observable pattern to better handle async variables and decouple business/view logic. I've then used the Databinder API to abstract data binding; which was difficult to get setup, but eliminates a lot of boilerplate view logic; as well makes editing views easier. I've used retrofit to setup interfaces for itneracting with githubs Rest API, initial setup is a pain but adding new methods will be easy going forward via the API interface.

#### 3 Hour Mark
There's an annotated tag label 3hr on this repository that marks 3 hours into the project. I spent a few hours familiarizing myself with Android Studio and a little bit of the API before getting started. As you can see in this commit not a lot happened. I was getting an error from the API & had a hard time implementing a debugger. Likely I was probably getting the correct request but was casting the returned object as a List. In later commits you can see that I've recast appropriately. I struggled with finding up to date examples of using retrofit and getting various parts of the library to work together. The next commit after this, without as the time constraints I was better able to slow down and think about what I was building & used updated versions of the library.