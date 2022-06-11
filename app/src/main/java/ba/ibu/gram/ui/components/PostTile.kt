package ba.ibu.gram.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.ibu.gram.model.Post
import ba.ibu.gram.ui.theme.AppTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun PostTile(post: Post, onClick: () -> Unit) {
  val postImage = rememberAsyncImagePainter(post.photoUrl)

  Image(
    painter = postImage,
    contentDescription = null,
    modifier = Modifier
      .size(160.dp)
      .clickable { onClick() }
  )
}

@Preview(
  name = "PostTile",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PostTileDefaultPreview() {
  AppTheme {
    PostTile()
  }
}

@Preview(
  name = "SearchBar Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PostTileDarkDefaultPreview() {
  AppTheme {
    PostTile()
  }
}