package com.example.jetpackcomposecodelayoutsandnav

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val navBarItems = listOf(
        RecipesNavigation.American,
        RecipesNavigation.Cajun,
        RecipesNavigation.Chinese,
        RecipesNavigation.Italian,
        RecipesNavigation.Mexican,
    )
    Column(
        modifier = Modifier
            .background(
                shape = RectangleShape,
                brush = Brush.linearGradient(
                    colors = listOf(Color.Blue, Color.Gray, Color.Cyan)
                )
            )
            .shadow(
                clip = true,
                elevation = 64.dp,
                ambientColor = Color.Yellow,
                spotColor = Color.Red,
                shape = CircleShape
            )
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(25.dp)
        )
        // Header
        Card(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(8.dp)
                .size(180.dp)
                .shadow(
                    clip = true,
                    elevation = 64.dp,
                    ambientColor = Color.Yellow,
                    spotColor = Color.Red,
                    shape = CircleShape
                ),
            shape = CircleShape,
        ) {
            Image(
                painter = painterResource(id = R.drawable.chefhat),
                contentDescription = "Drawer Photo",
                contentScale = ContentScale.Fit,
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )
        // List of navigation items
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navBarItems.forEach { item ->
            DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
                // Close drawer
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
            Spacer(modifier = Modifier.height(25.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Recipes",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun DrawerItem(item: RecipesNavigation, selected: Boolean, onItemClick: (RecipesNavigation) -> Unit) {
    val background = if (selected) R.color.black else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(colorResource(id = background), shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 10.dp,)

    ) {
        Image(
            painter = painterResource(id = item.Icon),
            contentDescription = item.title,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .padding(start = 10.dp, end = 10.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 26.sp,
            color = Color.White
        )
    }
}

@ExperimentalCoilApi
@ExperimentalCoroutinesApi
@ExperimentalPermissionsApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController, mainViewModel: MainViewModel) {
    var recipeOneClicked: Boolean = false
    var recipeTwoClicked: Boolean = false
    var recipeThreeClicked: Boolean = false
    NavHost(navController, startDestination = RecipesNavigation.American.route) {
        composable(RecipesNavigation.American.route) {
            mainViewModel.onTitleChanged("American")
            val navController = rememberNavController()

            val bottomSheetScaffolState2 = BottomSheetScaffoldState(
                drawerState = rememberDrawerState(
                    initialValue =
                    DrawerValue.Closed
                ),
                snackbarHostState = SnackbarHostState(),
                bottomSheetState = rememberBottomSheetState(
                    initialValue =
                    BottomSheetValue.Collapsed
                )
            )

            BottomSheetScaffold(
                backgroundColor = Color.Transparent,
                scaffoldState = bottomSheetScaffolState2,
                sheetPeekHeight = 25.dp,
                sheetBackgroundColor = Color.White,
                sheetShape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                ),
                sheetElevation = 4.dp, sheetContent = {

                    Column(modifier = Modifier.wrapContentSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.whitearrow),
                            contentDescription = "Image Banner",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color.Black),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)

                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeOneClicked = true

                                if (recipeOneClicked != false) {
                                    (navController.navigate(AmericanRecipesNavigation.RecipeOne.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe One", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeTwoClicked = true

                                if (recipeTwoClicked != false) {
                                    (navController.navigate(AmericanRecipesNavigation.RecipeTwo.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Two", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeThreeClicked = true

                                if (recipeThreeClicked != false) {
                                    (navController.navigate(AmericanRecipesNavigation.RecipeThree.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Three", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }
                    }
                }

            ) {
                NavHost(navController, startDestination = AmericanRecipesNavigation.RecipeOne.route) {
                    composable(AmericanRecipesNavigation.RecipeOne.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            americanRecipeVideoOne()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.american_recipe_one),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(AmericanRecipesNavigation.RecipeTwo.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            americanRecipeVideoTwo()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.american_recipe_two),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(AmericanRecipesNavigation.RecipeThree.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            americanRecipeVideoThree()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.american_recipe_three),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 124.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        composable(RecipesNavigation.Cajun.route) {
            var recipeOneClicked: Boolean = false
            var recipeTwoClicked: Boolean = false
            var recipeThreeClicked: Boolean = false
            mainViewModel.onTitleChanged("Cajun")
            val navController = rememberNavController()

            val bottomSheetScaffolState0 = BottomSheetScaffoldState(
                drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                ),
                snackbarHostState = SnackbarHostState(),
                bottomSheetState = rememberBottomSheetState(
                    initialValue = BottomSheetValue.Collapsed
                )
            )

            BottomSheetScaffold(
                backgroundColor = Color.Transparent,
                scaffoldState = bottomSheetScaffolState0,
                sheetPeekHeight = 25.dp,
                sheetBackgroundColor = Color.White,
                sheetShape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                ),
                sheetElevation = 4.dp, sheetContent = {
                    Column(modifier = Modifier.wrapContentSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.whitearrow),
                            contentDescription = "Image Banner",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color.Black),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)

                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeOneClicked = true

                                if (recipeOneClicked != false) {
                                    (navController.navigate(CajunRecipesNavigation.RecipeOne.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe One", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeTwoClicked = true

                                if (recipeTwoClicked != false) {
                                    (navController.navigate(CajunRecipesNavigation.RecipeTwo.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Two", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeThreeClicked = true

                                if (recipeThreeClicked != false) {
                                    (navController.navigate(CajunRecipesNavigation.RecipeThree.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Three", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }
                    }
                }
            ) {
                NavHost(navController, startDestination = CajunRecipesNavigation.RecipeOne.route) {
                    composable(CajunRecipesNavigation.RecipeOne.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            cajunRecipeVideoOne()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.cajun_recipe_one),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(CajunRecipesNavigation.RecipeTwo.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            cajunRecipeVideoTwo()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.cajun_recipe_two),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(CajunRecipesNavigation.RecipeThree.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            cajunRecipeVideoThree()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.cajun_recipe_three),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 140.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        composable(RecipesNavigation.Chinese.route) {
            var recipeOneClicked: Boolean = false
            var recipeTwoClicked: Boolean = false
            var recipeThreeClicked: Boolean = false
            mainViewModel.onTitleChanged("Chinese")
            val navController = rememberNavController()
            val bottomSheetScaffolState = BottomSheetScaffoldState(
                drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                ),
                snackbarHostState = SnackbarHostState(),
                bottomSheetState = rememberBottomSheetState(
                    initialValue = BottomSheetValue.Collapsed
                )
            )

            BottomSheetScaffold(
                backgroundColor = Color.Transparent,
                scaffoldState = bottomSheetScaffolState,
                sheetPeekHeight = 25.dp,
                sheetBackgroundColor = Color.White,
                sheetShape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                ),
                sheetElevation = 4.dp, sheetContent = {

                    Column(modifier = Modifier.wrapContentSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.whitearrow),
                            contentDescription = "Image Banner",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color.Black),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)

                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeOneClicked = true

                                if (recipeOneClicked != false) {
                                    (navController.navigate(ChineseRecipesNavigation.RecipeOne.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe One", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeTwoClicked = true

                                if (recipeTwoClicked != false) {
                                    (navController.navigate(ChineseRecipesNavigation.RecipeTwo.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Two", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeThreeClicked = true

                                if (recipeThreeClicked != false) {
                                    (navController.navigate(ChineseRecipesNavigation.RecipeThree.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Three", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }
                    }
                }
            ) {
                NavHost(navController, startDestination = ChineseRecipesNavigation.RecipeOne.route) {
                    composable(ChineseRecipesNavigation.RecipeOne.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            chineseRecipeVideoOne()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.chinese_recipe_one),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(ChineseRecipesNavigation.RecipeTwo.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            chineseRecipeVideoTwo()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.chinese_recipe_two),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(ChineseRecipesNavigation.RecipeThree.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            chineseRecipevideoThree()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.chinese_recipe_three),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 26.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        composable(RecipesNavigation.Italian.route) {
            var recipeOneClicked: Boolean = false
            var recipeTwoClicked: Boolean = false
            var recipeThreeClicked: Boolean = false
            mainViewModel.onTitleChanged("Italian")
            val navController = rememberNavController()
            val bottomSheetScaffolState3 = BottomSheetScaffoldState(
                drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                ),
                snackbarHostState = SnackbarHostState(),
                bottomSheetState = rememberBottomSheetState(
                    initialValue = BottomSheetValue.Collapsed
                )
            )

            BottomSheetScaffold(
                backgroundColor = Color.Transparent,
                scaffoldState = bottomSheetScaffolState3,
                sheetPeekHeight = 25.dp,
                sheetBackgroundColor = Color.White,
                sheetShape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                ),
                sheetElevation = 4.dp, sheetContent = {

                    Column(modifier = Modifier.wrapContentSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.whitearrow),
                            contentDescription = "Image Banner",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color.Black),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)

                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeOneClicked = true

                                if (recipeOneClicked != false) {
                                    (navController.navigate(ItalianRecipeNavigation.RecipeOne.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe One", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeTwoClicked = true

                                if (recipeTwoClicked != false) {
                                    (navController.navigate(ItalianRecipeNavigation.RecipeTwo.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Two", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeThreeClicked = true

                                if (recipeThreeClicked != false) {
                                    (navController.navigate(ItalianRecipeNavigation.RecipeThree.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Three", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }
                    }
                }
            ) {
                NavHost(navController, startDestination = ItalianRecipeNavigation.RecipeOne.route) {

                    composable(ItalianRecipeNavigation.RecipeOne.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            italianRecipeVideoOne()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.italian_recipe_one),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(ItalianRecipeNavigation.RecipeTwo.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            italianRecipeVideoTwo()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.italian_recipe_two),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(ItalianRecipeNavigation.RecipeThree.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            italianRecipeVideoThree()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.italian_recipe_three),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        composable(RecipesNavigation.Mexican.route) {
            var recipeOneClicked: Boolean = false
            var recipeTwoClicked: Boolean = false
            var recipeThreeClicked: Boolean = false
            mainViewModel.onTitleChanged("Mexican")
            val navController = rememberNavController()
            val bottomSheetScaffolState4 = BottomSheetScaffoldState(
                drawerState = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                ),
                snackbarHostState = SnackbarHostState(),
                bottomSheetState = rememberBottomSheetState(
                    initialValue = BottomSheetValue.Collapsed
                )
            )

            BottomSheetScaffold(
                backgroundColor = Color.Transparent,
                scaffoldState = bottomSheetScaffolState4,
                sheetPeekHeight = 25.dp,
                sheetBackgroundColor = Color.White,
                sheetShape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                ),
                sheetElevation = 4.dp, sheetContent = {
                    Column(modifier = Modifier.wrapContentSize()) {
                        Image(
                            painter = painterResource(id = R.drawable.whitearrow),
                            contentDescription = "Image Banner",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color.Black),
                            modifier = Modifier
                                .size(20.dp)
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)

                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeOneClicked = true

                                if (recipeOneClicked != false) {
                                    (navController.navigate(MexicanRecipesNavigation.RecipeOne.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe One", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeTwoClicked = true

                                if (recipeTwoClicked != false) {
                                    (navController.navigate(MexicanRecipesNavigation.RecipeTwo.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Two", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Transparent,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(size = 60.dp),
                            onClick = {
                                recipeThreeClicked = true

                                if (recipeThreeClicked != false) {
                                    (navController.navigate(MexicanRecipesNavigation.RecipeThree.route))
                                }
                            },
                            modifier = Modifier
                                .height(Dp(85F))
                                .width(Dp(400F))
                                .padding(Dp(8F))
                                .border(width = 6.dp, color = Color.Black, shape = CircleShape)
                        ) {
                            Text("Recipe Three", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                        }
                    }
                }
            ) {
                NavHost(navController, startDestination = MexicanRecipesNavigation.RecipeOne.route) {

                    composable(MexicanRecipesNavigation.RecipeOne.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            mexicanRecipeVideoOne()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.mexican_recipe_one),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(MexicanRecipesNavigation.RecipeTwo.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            mexicanRecipeVideoTwo()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.mexican_recipe_two),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }

                    composable(MexicanRecipesNavigation.RecipeThree.route) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            mexicanRecipeVideoThree()
                        }
                        LazyColumn(modifier = Modifier.padding(top = 255.dp)) {
                            item {
                                Text(
                                    text = stringResource(id = R.string.mexican_recipe_three),
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(bottom = 84.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
