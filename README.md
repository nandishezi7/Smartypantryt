# Smartypantryt
# Smart Pantry Manager

Smart Pantry Manager is a Java-based Android application developed for the **Mobile App Development 700** practical assignment.

The application helps users reduce food waste by tracking ingredients available in their pantry and suggesting recipes that can be prepared using only those ingredients.

## Student Information

**Name:** Nandi Shezi
**Student Number:** 402413409
**Programme:** Bachelor of Science in Information Technology
**Year:** 3
**Module:** Mobile App Development 700

## Application Overview

The Smart Pantry Manager allows users to:

* Add pantry ingredients
* View pantry ingredients
* Edit existing ingredients
* Delete ingredients
* Record quantities and units
* Record optional expiry dates
* View available recipes
* Receive recipe suggestions based on their pantry
* View recipe details and preparation instructions
* Configure application settings

### Strict Recipe Matching

The main feature of the application is its strict recipe-matching system.

A recipe is suggested **only when every required ingredient is available in the user's pantry in the required quantity**.

For example, if a recipe requires five ingredients and the user only has four, the recipe will not appear in the Suggested Recipes list.

## Technologies Used

* Java
* Android Studio
* SQLite
* SQLiteOpenHelper
* RecyclerView
* Custom RecyclerView Adapters
* Android Activities
* Intents
* XML layouts
* SharedPreferences

## Database

The application uses **SQLite** for local persistent storage.

SQLite stores the user's pantry information and the application's recipe collection on the Android device. The data remains available after the application is closed and reopened.

The database contains:

### Pantry

```text
id
name
quantity
unit
expiry_date
```

### Recipes

```text
id
name
method
minutes
servings
```

### Recipe Ingredients

```text
id
recipe_id
name
quantity
unit
```

## Main Screens

### Pantry List

Displays the user's current pantry ingredients using a RecyclerView.

Users can add, edit and delete ingredients.

### Add/Edit Ingredient

Allows users to enter an ingredient name, quantity, unit and optional expiry date.

Input validation is applied before saving.

### Suggested Recipes

Compares the pantry contents against the recipe database and displays only recipes that can currently be prepared.

### Recipe Detail

Displays the recipe name, required ingredients, quantities and preparation method.

### Settings

Provides application preferences such as expiry alerts and unit preferences.

## CRUD Functionality

The pantry supports complete CRUD functionality:

* **Create** — add a new pantry ingredient
* **Read** — display existing pantry ingredients
* **Update** — edit an existing ingredient
* **Delete** — remove an ingredient

All pantry information is stored persistently in SQLite.

## Strict Matching Logic

The application checks every ingredient required by a recipe.

```text
For each recipe:

    Assume the recipe can be made

    For each required ingredient:

        Find the ingredient in the pantry

        If it does not exist:
            Reject the recipe

        If pantry quantity is insufficient:
            Reject the recipe

    If all ingredients pass:
        Display the recipe
```

Partial matches are therefore excluded from the main Suggested Recipes list.

## Ingredient Normalisation

The application performs basic normalisation to handle simple singular and plural differences.

For example:

```text
tomato  → tomato
tomatoes → tomato

onion → onion
onions → onion
```

This prevents trivial naming differences from incorrectly causing a recipe to fail the matching process.

## Running the Application

1. Install Android Studio.
2. Clone this repository.
3. Open the project in Android Studio.
4. Allow Gradle to synchronise.
5. Start an Android emulator or connect an Android device.
6. Click **Run** in Android Studio.

The SQLite database is created automatically when the application is first launched.

## Testing the Strict Matching Feature

To test the main functionality:

1. Add all ingredients required by a recipe.
2. Open **Suggested Recipes**.
3. Confirm that the recipe appears.
4. Remove one required ingredient.
5. Return to **Suggested Recipes**.
6. Confirm that the recipe disappears.
7. Add the missing ingredient again.
8. Confirm that the recipe appears again.

This demonstrates that recipe suggestions are based on the user's current pantry.

## Project Structure

```text
SmartPantryManager/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── za/co/smartpantrymanager/
│           │       ├── data/
│           │       ├── model/
│           │       ├── util/
│           │       └── ui/
│           │
│           ├── res/
│           │   ├── drawable/
│           │   ├── layout/
│           │   └── values/
│           │
│           └── AndroidManifest.xml
│
├── build.gradle
├── settings.gradle
├── gradle.properties
└── README.md
```

## Assignment Requirements Demonstrated

| Requirement              | Implementation                |
| ------------------------ | ----------------------------- |
| Java Android application | Java                          |
| Minimum screens          | 5 Activities                  |
| Persistent database      | SQLite                        |
| CRUD                     | Pantry management             |
| Dynamic list             | RecyclerView                  |
| Custom Adapter           | PantryAdapter / RecipeAdapter |
| Intents                  | Activity navigation           |
| Input validation         | Add/Edit Ingredient           |
| Recipe collection        | 20 seeded recipes             |
| Strict matching          | Recipe matching algorithm     |
| Settings                 | Settings Activity             |
| Empty-state feedback     | Suggested Recipes             |
| GPS/Maps                 | Not used                      |

## Author

**Nandi Shezi**
**Student Number:** 402413409
**Bachelor of Science in Information Technology — Year 3**

**Mobile App Development 700**

