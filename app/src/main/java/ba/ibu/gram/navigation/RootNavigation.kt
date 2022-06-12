package ba.ibu.gram.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ba.ibu.gram.ui.screens.CreatePostScreen
import ba.ibu.gram.ui.screens.LoginScreen
import ba.ibu.gram.ui.screens.PostScreen
import ba.ibu.gram.ui.screens.UserScreen

@Composable
fun RootNavigation(navController: NavHostController, loggedIn: Boolean) {

  NavHost(navController = navController, startDestination = if (loggedIn) "main" else "auth") {
    composable("auth") { LoginScreen(hiltViewModel(), navController) }

    navigation(route = "main", startDestination = "bottom") {
      composable("bottom") { MainNavigation(navController) }

      composable("createPost") { CreatePostScreen(hiltViewModel(), navController) }

      composable("post/{postId}") { backStackEntry ->
        PostScreen(backStackEntry.arguments?.getString("postId"), navController)
      }

      composable("user/{userId}") { backStackEntry ->
        UserScreen(backStackEntry.arguments?.getString("userId"), hiltViewModel(), navController)
      }
    }
  }
}