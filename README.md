# RandView
In this project I used the simple Volley library to fetch data using a random API and display it in my app.

# Simple Android Project – Random Data Display App

This is a basic Android app that demonstrates the use of a splash screen, random data fetching from the internet, and a refresh mechanism using a button. It also showcases a circular display design using a third-party library.

## ✨ Features

- **Splash Screen**: Displays briefly when the app starts.
- **Random Data Display**: Fetches and shows random data from the internet in a circular view using a third-party circle library.
- **Refresh Button**: Allows users to fetch new random data every time the button is pressed.

## 🧱 Technologies Used

- Java (Android)
- Circle Image / View Library
- Internet Permissions (for API call)
- Basic UI Elements (Button, TextView, etc.)

## 📱 Screens

1. **Splash Screen**
   - Appears for a few seconds when the app launches.  
   <img src="https://github.com/user-attachments/assets/0608a28f-1cf1-4bce-9764-fb3edb119087" width="300"/>

2. **Main Activity**
   - Random data is shown in a circular view.
   - A refresh button fetches and updates the content with new data.  
   <img src="https://github.com/user-attachments/assets/e0047e7b-8238-4ee3-9e55-3439ea31a344" width="300"/>  
   <img src="https://github.com/user-attachments/assets/46a84668-bc7d-4324-acac-0683a48fa615" width="300"/>  
   <img src="https://github.com/user-attachments/assets/a5a6df47-d90f-4197-9564-b43404d32ac9" width="300"/>

## 🔄 How it Works

- On launch, the splash screen is shown.
- The main screen displays a piece of random data fetched from an API.
- Pressing the **"Refresh"** button triggers a new API call, and the circular display updates with the new data.

## 🎬 Video Demo

[Click here to watch the video](https://github.com/user-attachments/assets/ee8a44b6-a672-4b1d-9164-affc3257991c)

## 🧩 Dependencies

Make sure you include the required circle library in your `build.gradle`:

```gradle
implementation 'de.hdodenhof:circleimageview:3.1.0'
