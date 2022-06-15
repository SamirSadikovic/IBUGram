package ba.ibu.gram.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.viewmodel.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState

  LaunchedEffect(key1 = "start") {
    viewModel.getFeedData()
  }

  if (uiState.feedLoading) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      CircularProgressIndicator()
    }
  } else {
    uiState.feedData.let {
      LazyColumn(
        modifier = Modifier
          .padding(16.dp)
      ) {
        items(it.size) { i ->
          FeedPost(it[i],
                   Modifier.padding(0.dp, 8.dp),
                   it[i].liked,
                   {
                     navController?.navigate("user/" + it[i].userId)
                   },
                   { liked ->
                     if (liked) {
                       viewModel.likeFunction(it[i].id)
                       it[i].likes = it[i].likes?.plus(1)
                     } else {
                       it[i].likes = it[i].likes?.minus(1)
                       viewModel.unlikeFunction(it[i].id)
                     }
                   }
          )
        }
      }
    }
  }

}