package ba.ibu.gram.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.viewmodel.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel(), navController: NavController? = null) {
  Text("Feed screen")
}