package ba.ibu.gram.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.theme.AppTheme
import coil.compose.rememberAsyncImagePainter

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

val post = Post(
  1,
  "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
  1,
  "Sample description",
  420,
  userPosted
)

@Composable
fun PostTile(post: Post, modifier: Modifier = Modifier,  onClick: () -> Unit = {}) {
  val postImage = rememberAsyncImagePainter(post.photoUrl)

  Image(
    painter = postImage,
    contentDescription = null,
    contentScale = ContentScale.Crop,
    modifier = modifier
      .clickable { onClick() }
      .fillMaxWidth()
      .aspectRatio(1f)
  )
}

@Preview(
  name = "PostTile",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PostTileDefaultPreview() {
  AppTheme {
    PostTile(post)
  }
}

@Preview(
  name = "SearchBar Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PostTileDarkDefaultPreview() {
  AppTheme {
    PostTile(post)
  }
}