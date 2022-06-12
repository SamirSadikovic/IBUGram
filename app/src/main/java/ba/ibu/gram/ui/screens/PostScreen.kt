package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.ui.components.feedPost
import ba.ibu.gram.ui.theme.AppTheme

val user = User(
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

val feedPost = Post(
  1,
  "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
  "1",
  "Sample description",
  420,
  user
)

@Composable
fun PostScreen(postId: Int?, navController: NavController? = null) {
  val post = Post( //pick up user from db based on ID
    1,
    "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
    "1",
    "Sample description",
    420,
    user
  )

  FeedPost(post, Modifier.padding(16.dp)) {
    navController?.currentBackStackEntry?.savedStateHandle?.set("user", post.user)
    navController?.navigate("user")
  }
}

@Preview(
  name = "Post",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PostDefaultPreview() {
  AppTheme {
    PostScreen(1)
  }
}

@Preview(
  name = "Post Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PostDarkDefaultPreview() {
  AppTheme {
    PostScreen(1)
  }
}