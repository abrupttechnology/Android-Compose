package com.example.jetpackcomposecodelayoutsandnav

sealed class AmericanRecipesNavigation(val route: String) {
    object RecipeOne : AmericanRecipesNavigation("RecipeOne")
    object RecipeTwo : AmericanRecipesNavigation("RecipeTwo")
    object RecipeThree : AmericanRecipesNavigation("RecipeThree")
}


