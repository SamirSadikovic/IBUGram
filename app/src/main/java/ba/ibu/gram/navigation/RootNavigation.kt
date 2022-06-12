package ba.ibu.gram.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.screens.LoginScreen
import ba.ibu.gram.ui.screens.PostScreen
import ba.ibu.gram.ui.screens.SettingsScreen
import ba.ibu.gram.ui.screens.UserScreen

@Composable
fun RootNavigation(navController: NavHostController, loggedIn: Boolean) {

  NavHost(navController = navController, startDestination = if (loggedIn) "main" else "auth") {
    composable("auth") { LoginScreen(hiltViewModel(), navController) }

    navigation(route = "main", startDestination = "bottom") {
      composable("bottom") { MainNavigation(navController) }

      composable("settings") { SettingsScreen() }

      composable(
        "post/{postId}",
        arguments = listOf(navArgument("postId") {
          type = NavType.IntType
        })
      ) { backStackEntry ->
        PostScreen(backStackEntry.arguments?.getInt("postId"), navController)
      }

      composable(
        "user/{userId}",
        arguments = listOf(navArgument("userId") {
          type = NavType.IntType
        })
      ) { backStackEntry ->
        UserScreen(backStackEntry.arguments?.getInt("userId"), navController)
      }
    }
  }
}