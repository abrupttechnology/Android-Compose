package com.example.jetpackcomposecodelayoutsandnav

sealed class ChineseRecipesNavigation(var route: String) {
    object RecipeOne : ChineseRecipesNavigation("RecipeOne")
    object RecipeTwo : ChineseRecipesNavigation("RecipeTwo")
    object RecipeThree : ChineseRecipesNavigation("RecipeThree")
}

