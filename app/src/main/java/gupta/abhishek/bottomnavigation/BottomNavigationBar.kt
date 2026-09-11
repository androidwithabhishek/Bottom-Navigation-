package gupta.abhishek.bottomnavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.selects.select

@Composable
fun BottomNavigationBar(navController: NavHostController) {


    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination


    val navitems = listOf(
        BottomNavItem.HomeItem,
        BottomNavItem.SearchItem,
        BottomNavItem.FavoritesItem,
        BottomNavItem.ProfileItem
    )

    NavigationBar(

    ) {

        navitems.forEachIndexed { index, item ->

            val selected = currentDestination
                ?.hasRoute(item.route::class) == true


            NavigationBarItem(selected = false, onClick = {

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