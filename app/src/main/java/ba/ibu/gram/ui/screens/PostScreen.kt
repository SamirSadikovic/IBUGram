package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.PostViewModel

@Composable
fun PostScreen(postId: String?, viewModel: PostViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState

  LaunchedEffect(key1 = "start") {
    if (postId != null) viewModel.getPostData(postId)
  }
  val post = uiState.post

  if (uiState.postLoading) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      CircularProgressIndicator()
    }
  } else {
    if (post != null) {
      FeedPost(
        post,
        Modifier.padding(16.dp),
        uiState.liked,
        {
          navController?.navigate("user/" + post.userId)
        },
        { liked ->
          if (liked) {
            if (postId != null) {
              viewModel.likeFunction(postId)
            }
            post.likes = post.likes?.plus(1)
          } else {
            post.likes = post.likes?.minus(1)
            if (postId != null) {
              viewModel.unlikeFunction(postId)
            }
          }
        }
      )
    }
  }
}

@Preview(
  name = "Post",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PostDefaultPreview() {
  AppTheme {
    PostScreen("btS6BIN7y8BSNUn6Y44o")
  }
}

@Preview(
  name = "Post Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PostDarkDefaultPreview() {
  AppTheme {
    PostScreen("btS6BIN7y8BSNUn6Y44o")
  }
}