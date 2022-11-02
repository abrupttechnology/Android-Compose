package com.example.jetpackcomposecodelayoutsandnav

sealed class RecipesNavigation(var route: String, var title: String, var Icon: Int) {
    object American : RecipesNavigation("American", "American", R.drawable.iconusa)
    object Cajun : RecipesNavigation("Cajun", "Cajun", R.drawable.iconsfrance)
    object Chinese : RecipesNavigation("Chinese", "Chinese", R.drawable.iconschina)
    object Italian : RecipesNavigation("Italian", "Italian", R.drawable.iconitaly)
    object Mexican : RecipesNavigation("Mexican", "Mexican", R.drawable.iconmexico)
}
