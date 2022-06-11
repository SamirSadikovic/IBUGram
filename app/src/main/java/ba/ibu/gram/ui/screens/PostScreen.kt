package ba.ibu.gram.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ba.ibu.gram.model.Post

@Composable
fun PostScreen(post: Post?, navController: NavController? = null) {
  Text("Post screen")
}