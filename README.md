# ProjectHomemaker

This is an app for creating and storing recipes. The recipe will have a Name, Category, Star Rating, Serving, Cost Rating, Ingredient List, and Directions
What was implemented in this application as far as from Unit 2 (and some before):

  1.)Inheritance - There is one Recipe class and several sub classes (BreakfastRecipe) which will inherit from the main
  
  2.)Interfaces - There is a JSONable Interface which requires a toJsonString and fromJsonString method
  
  3.)Generics - There is a Generic List of Recipes which contains all subclasses as well
  
  4.)Data Persistence - The recipes are stored in and received from  an SQL Database 
  
  5.)Code Quality - There are Unit Tests, UI Tests, I have Debugged and ran performance testing on this app.
  
  6.)Media Programming - I have a mediaplayer in the app to play a sound as its going to the new activity.
  
  7.)Menus - There is an action bar made from a menu resource file which will take you to the search function.
  
  8.)Networking - There is a network call made with the recipe search
  
  9.)Services - Utilizing the Action_View service to load a browser from the applications search functionality
  
  10.)Custom View - There is a Custom edit Text as a Custom View. (Future Implications will have a Timer View)
  
  11.)Animated Layouts - The Recycler View is fully animated with a slide in animation.
  
  12.)Animated Images - The Landing Page has an animated image as a Button to launch the Recipe Activity.
  
  
  Things not included are:
  
  1.)Location - I didn't see a reason to have any form of location services for a personal Recipe app
  
  2.)Concurrency - There is only one piece of data that is handled between classes and there are no possibilities for race Conditions.
  
  3.)Google Play Store - I have every intention of putting on the store once its fully polished, but in a 1 week project I didnt want
  that to show up on my portfolio until I was happy with it.
  
  Everything else I can think of as far as utilization in the application I have applied. I believe I have met MVP
