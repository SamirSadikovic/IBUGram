package ba.ibu.gram.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.ui.components.PostTile
import ba.ibu.gram.viewmodel.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel(), navController: NavController? = null) {
  val userPosted = User(
    1,
    "SamirS",
    "https://cdn2.iconfinder.com/data/icons/facebook-51/32/FACEBOOK_LINE-01-512.png",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
        "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
        "culpa qui officia deserunt mollit anim id est laborum.",
    420,
    69,
    34
  )

  val feedPosts = listOf(
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      userPosted
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      userPosted
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      userPosted
    )
  )

  LazyColumn(
    modifier = Modifier
      .padding(16.dp)
  ) {
    items(feedPosts.size) { i ->
      FeedPost(feedPosts[i], Modifier.padding(0.dp, 8.dp)){
          navController?.navigate("user/" + feedPosts[i].user?.id)
      }
    }
  }
}