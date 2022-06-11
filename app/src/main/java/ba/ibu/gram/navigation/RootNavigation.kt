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
import ba.ibu.gram.ui.screens.LoginScreen
import ba.ibu.gram.ui.screens.PostScreen

@Composable
fun RootNavigation(navController: NavHostController, loggedIn: Boolean) {

  NavHost(navController = navController, startDestination = if (loggedIn) "main" else "auth") {
    composable("auth") { LoginScreen(hiltViewModel(), navController) }

    navigation(route = "main", startDestination = "bottom") {
      composable("bottom") { MainNavigation() }
      composable("post/{post}", arguments = listOf(navArgument("post") { type = NavType<Post>() } )) { PostScreen(it.post, navController) }
    }
  }
}