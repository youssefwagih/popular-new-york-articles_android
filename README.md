# NY Times Most Popular Articles
This is an application that displays the most popular articles from NewYork Times.
- Language used is java.
- Android Architecture Components are applied in this project.
- MVVM design pattern is used in this application.
- NewYork Times API needs API key to be able to use it and i put it as constant and it should be in gradle as config variable with different build variant if there are more than one environment but this for the tight time of task.
- No data binding applied but i knew about it also i knew about butterknife is better than using findviewbyId method and also databinding makes us get rid of these boilerplate code
- respository pattern will be used for handling the data layer to be responsible for the logic of getting data from remote APIs or from local database but our app has only remote APIs so no need to add the other logic.

# Project structure
- **UI**: it contains all the activities, fragments and viewmodels used in the app
- **Adapters**: it contains all the adapter used all over the app.
- **Network**: it contains the initialization or any helper class used in network
- **Repository**: it contains all the data layer classes (models, sharedpreferences,  database and remote implementations) it should be responsible for handling data if it should come from remote or from database.


# Testing
- I have added UI tests using Espresso for testing success of existing articles and another one for the failure as empty articles.
- I couldn't apply unit testing in this task as the logic doesn't contain too much logic also i'm learning about unit testing but didn't work with it in real projects but learning only. Also i have applied MVVM pattern to be better in unit testing as there is no dependency on the view like MVP design pattern.
- No reports done with SonarQube as it's new for me also tight time make me not to look for implementing it.

### Libraries: ###
- [Android architecture components](https://developer.android.com/topic/libraries/architecture/index.html)
- [Retrofit2](https://github.com/square/retrofit)
- [Picasso](https://github.com/square/picasso)
- [CircleImageView](https://github.com/hdodenhof/CircleImageView)
- [Espresso](https://developer.android.com/training/testing/espresso)