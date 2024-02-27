
# Animated SplashScreen with _Lottie Android library_


This project is your guide to building better Android apps! It teaches you two important things:

__Lottie animations:__ 
Learn how to add cool, moving graphics (animations) from https://lottiefiles.com/ to your app.

__Pager implementation:__ Discover how to make "flipping between screens" (navigation) smooth and easy for users.
By exploring this code, you'll:

_Boost your app's looks: Add eye-catching animations with Lottie.
Improve user experience: Make it easy for users to navigate your app.
Get started and learn how to build awesome apps!_

# Demo

![Lottie Animation - Splash Screen](https://github.com/Kota-Kun22/LottieAnimation_splashScreen/assets/68362699/dd8d028c-d218-4075-bee3-232aa65cfa6e) | ![Lottie Animation - Dark Mode](https://github.com/Kota-Kun22/LottieAnimation_splashScreen/assets/68362699/1d30bbfc-fcaa-4e84-bd07-8cd769c670de)
---
*As from the view we can see there are Light and Dark mode also later you will learn how to implement this also*





# Tech Stack

1. **Language:** Kotlin

2. **Design :** JetPackCompose


4. **Dependencies ::**


__a.__ Dependency for  Lottie Android library:

` implementation("com.airbnb.android:lottie-compose:5.2.0")` 

__b.__ Dependency for  Lottie Android library:

`implementation ("androidx.navigation:navigation-compose:2.8.0-alpha03")`

__c.__ Dependency for  Lottie Android library:

`implementation ("com.google.accompanist:accompanist-pager:0.12.0")`


5. **Plugins ::**

**.**  `id("com.android.application")`

**.** `id("org.jetbrains.kotlin.android")`





#  Lessons Learned


What did I learn while building this project? What challenges did I face ?



1. __Compose Pager for Intuitive Navigation:__
\
*__Learn:__* Understand the `HorizontalPager` or `VerticalPager` composables for swiping between content.

__Implement:__ Create a `Pager` with `children` composables representing your pages. Utilize `rememberPagerState` to track current position and enable navigatio

__code:__
\
![image](https://github.com/Kota-Kun22/Animated_SplashScreen/assets/68362699/ad8e2473-c167-48ff-ad99-ef7f45c1a12d)





2. __Customize Page Indicators for Clarity:__ 
\
*__Explore:__*  Create custom composables to visually represent the user's pager position.

*__Implement:__*  Use a `Box` with `Row` or `Column` to arrange indicator elements based on `pagerState.currentPage`

__code:__
\
![image](https://github.com/Kota-Kun22/Animated_SplashScreen/assets/68362699/14704abf-8a08-4f2f-b74f-c7a25b3d0eb0)




3. __Integrate Lottie Animations Seamlessly:__
\
*__Discover:__*  
Leverage the `LottieAnimation` composable to display Lottie animations in your app.

*__Implement:__*  
 Use `rememberLottieComposition` to load your animation and provide it to the `LottieAnimation` with desired options.

 __code:__


 ![image](https://github.com/Kota-Kun22/Animated_SplashScreen/assets/68362699/09211de0-46f0-4353-a4ae-a4455e685990)







# Pull Requests

**..** Fork the repository and create a new branch for your feature or bug fix:

**..** git checkout -b  feature-name Make your changes and commit them :

**..** git commit -m  "Description of changes" Push your changes to your fork :

**..** git push origin feature-name Open a pull request to the main branch of the original repository.
# Analogies To Remember


Some of the key point that I should keep in mind are--


### *_Lottie Animations :_*

*__Add visual appeal:__*
Enhance your app's interface with engaging, fluid animations that are far more lightweight than traditional video files.

*__rovide visual cues and feedback:__*
Use animations to indicate loading states, successful actions, or to guide the user's attention to specific elements.

### *_Pager Implementation:_*

*__Efficient screen swiping:__* Enable seamless transitions between different screens or views within your app, similar to a carousel style.
Manage structured content: Organize content into easily-navigable pages, ideal for onboarding sequences, image galleries, or step-by-step instructions.
Navigation Components

*__Simplify in-app navigation:__* Create a structured and intuitive flow for moving between different screens in your app.

*__Manage navigation history:__* Maintains a "back stack" to enable easy back-button functionality and logical movement within your app's structure.

### *_SharedPreferences:_*

*__Store small data sets:__* Persist simple data like user preferences, settings, or temporary session information across app launches.

*__Retrieve data for customization:__* Load saved data to tailor the app's behavior, offering a personalized experience for users.

***Explore the symphony of Android development!*** ️

Join the journey - 
craft beautiful, 
innovative apps, unlock new skills, and push the boundaries of what's possible!  No matter your level, this project is your playground.  ***Let's build something amazing together!*** ✨
