package ba.ibu.gram.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Feed
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ba.ibu.gram.R
import ba.ibu.gram.navigation.BottomScreen.Chat
import ba.ibu.gram.navigation.BottomScreen.Feed
import ba.ibu.gram.navigation.BottomScreen.Profile
import ba.ibu.gram.navigation.BottomScreen.Search
import ba.ibu.gram.ui.screens.ChatScreen
import ba.ibu.gram.ui.screens.FeedScreen
import ba.ibu.gram.ui.screens.ProfileScreen
import ba.ibu.gram.ui.screens.SearchScreen

enum class BottomScreen(
  val route: String,
  val icon: ImageVector,
  val iconSelected: ImageVector,
  @StringRes val label: Int,
  val content: @Composable (navController: NavController) -> Unit
) {
  Feed(
    "feed",
    Icons.Outlined.Feed,
    Icons.Filled.Feed,
    R.string.feed,
    { navController -> FeedScreen(hiltViewModel(), navController) }),

  Search(
    "search",
    Icons.Outlined.Search,
    Icons.Filled.Search,
    R.string.search,
    { navController -> SearchScreen(hiltViewModel(), navController) }),

  Chat(
    "chat",
    Icons.Outlined.Chat,
    Icons.Filled.Chat,
    R.string.chat,
    { navController -> ChatScreen(hiltViewModel(), navController) }),

  Profile(
    "profile",
    Icons.Outlined.AccountCircle,
    Icons.Filled.AccountCircle,
    R.string.profile,
    { navController -> ProfileScreen(hiltViewModel(), navController) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation(navController: NavController) {
  val bottomNavController = rememberNavController()
  val items = listOf(Feed, Search, Chat, Profile)


  Scaffold(bottomBar = { BottomBar(bottomNavController, items) }) { innerPadding ->
    Box(
      modifier = Modifier
        .padding(innerPadding)
    ) {
      NavHost(navController = bottomNavController, startDestination = "feed") {
        items.forEach { screen -> composable(route = screen.route) { screen.content(navController) } }
      }
    }
  }
}

@Composable
fun BottomBar(navController: NavController, items: List<BottomScreen>) {
  BottomNavigation(backgroundColor = MaterialTheme.colorScheme.surface) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    items.forEach { screen ->
      val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

      BottomNavigationItem(
        icon = {
          Icon(
            if (selected) screen.iconSelected else screen.icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
          )
        },
        label = {
          Text(
            text = stringResource(screen.label),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface
          )
        },
        selected = selected,
        onClick = {
          navController.navigate(screen.route) {
            popUpTo(navController.graph.findStartDestination().id) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        }
      )
    }
  }

}