package ba.ibu.gram.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.viewmodel.ChatViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun ChatScreen(viewModel: ChatViewModel = viewModel(), navController: NavController? = null) {
  val coroutineScope = rememberCoroutineScope()

  val uiState = viewModel.uiState

  Button(onClick = {
    coroutineScope.launch {
      viewModel.fetchPost()
    }

  }) {
    Text("Djes")
  }

  uiState.post?.let {
    Text(it.description)
  }
}