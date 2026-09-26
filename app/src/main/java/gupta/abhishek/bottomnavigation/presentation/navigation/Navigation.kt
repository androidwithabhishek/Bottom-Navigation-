package gupta.abhishek.bottomnavigation.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import gupta.abhishek.bottomnavigation.presentation.Screens.FavoriteScreen
import gupta.abhishek.bottomnavigation.presentation.Screens.HomeScreen
import gupta.abhishek.bottomnavigation.presentation.Screens.ProfileScreen
import gupta.abhishek.bottomnavigation.presentation.Screens.SearchScreen
import gupta.abhishek.bottomnavigation.presentation.Screens.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<Home> {
                HomeScreen()
            }

            composable<Search> {
                SearchScreen()
            }

            composable<Favorites> {
                FavoriteScreen()
            }

            composable<Profile> {
                ProfileScreen(

                    onClick = {
                        navController.navigate(Settings)
                    }
                )
            }

            composable <Settings>{
                SettingsScreen ()
            }


        }
    }


}



