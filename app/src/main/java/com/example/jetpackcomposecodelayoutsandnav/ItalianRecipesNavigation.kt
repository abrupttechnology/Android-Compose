package com.example.jetpackcomposecodelayoutsandnav

sealed class ItalianRecipeNavigation(var route: String, var icon: Int, var title: String) {
    object RecipeOne : ItalianRecipeNavigation("RecipeOne", R.drawable.ic_launcher_foreground, "RecipeOne")
    object RecipeTwo : ItalianRecipeNavigation("RecipeTwo", R.drawable.ic_launcher_foreground, "RecipeTwo")
    object RecipeThree : ItalianRecipeNavigation("RecipeThree", R.drawable.ic_launcher_foreground, "RecipeThree")
}
