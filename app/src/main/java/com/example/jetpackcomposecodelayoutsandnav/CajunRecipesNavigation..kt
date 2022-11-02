package com.example.jetpackcomposecodelayoutsandnav

sealed class CajunRecipesNavigation(val route: String) {
    object RecipeOne : CajunRecipesNavigation("RecipeOne")
    object RecipeTwo : CajunRecipesNavigation("RecipeTwo")
    object RecipeThree : CajunRecipesNavigation("RecipeThree")
}
