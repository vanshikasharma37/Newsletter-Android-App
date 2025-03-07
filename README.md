# Newsletter Subscription App

## Overview
This project is an Android application built using Kotlin and XML with ConstraintLayout. It demonstrates the use of Fragments, Bundle-based communication, and Activity navigation while following Object-Oriented Programming (OOP) principles.

## Features
### Android Application with Fragments
- **Fragment One:**
  - Newsletter Subscription Form including:
    - Name & Email input fields
    - Gender selection (Male, Female, Other)
    - Subscription preferences (Switch & Checkbox)
    - Dynamic Heading displaying the last name
    - "Register" Button
- **Fragment Two:**
  - Displays submitted details:
    - Thank You message
    - Name, Email, Gender
    - Subscription preferences status
  - Uses **Bundle** to transfer data from Fragment One to Fragment Two.

### Activity Navigation
- **Activity Two:**
  - "Go to Activity Two" Button in Fragment Two
  - Transfers the user’s name using a **Bundle**
  - Displays a welcome message including the user’s name

## Technologies Used
- **Programming Language:** Kotlin
- **UI Components:** XML, ConstraintLayout
- **Android Components:** Activity, Fragments, Intents, Bundles
- **Development Environment:** Android Studio

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.


## Author
**Vanshika Sharma**  
Email: vanshikasharma37303@gmail.com  
Seneca Polytechnic | Computer Programming & Analysis '25

## License
This project is open-source and available for educational purposes.
