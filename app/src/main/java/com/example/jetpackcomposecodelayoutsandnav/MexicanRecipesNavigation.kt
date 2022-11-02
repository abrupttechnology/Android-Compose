package com.example.jetpackcomposecodelayoutsandnav

sealed class MexicanRecipesNavigation(var route: String) {
    object RecipeOne : MexicanRecipesNavigation("RecipeOne")
    object RecipeTwo : MexicanRecipesNavigation("RecipeTwo")
    object RecipeThree : MexicanRecipesNavigation("RecipeThree")
}