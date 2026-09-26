package gupta.abhishek.bottomnavigation.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    val navItems = listOf(
        BottomNavItem.HomeItem,
        BottomNavItem.SearchItem,
        BottomNavItem.FavoritesItem,
        BottomNavItem.ProfileItem
    )

    NavigationBar(

    ) {

        navItems.forEachIndexed { index, item ->


            val selected = currentDestination?.route == item.route

            NavigationBarItem(selected = selected, onClick = {

                navController.navigate(item.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        saveState = true
                    }

                    launchSingleTop = true
                    restoreState = true
                }


            }, icon = {
                Icon(
                    imageVector = if (selected) {
                        item.selectedIcon
                    } else {
                        item.unselectedIcon
                    }, contentDescription = null
                )
            }, label = { Text(item.label) })

        }


    }

}