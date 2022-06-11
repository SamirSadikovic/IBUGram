package ba.ibu.gram.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.viewmodel.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel(), navController: NavController? = null) {
  Text("Search screen")
}