package ba.ibu.gram.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.viewmodel.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState

  uiState.feedData?.let {
    LazyColumn(
      modifier = Modifier
        .padding(16.dp)
    ) {
      items(it.size) { i ->
        FeedPost(it[i], Modifier.padding(0.dp, 8.dp)){
          navController?.navigate("user/" + it[i].userId)
        }
      }
    }
  }

}