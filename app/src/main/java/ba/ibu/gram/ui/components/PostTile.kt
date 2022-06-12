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

//@Preview(
//  name = "PostTile",
//  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
//)
//@Composable
//fun PostTileDefaultPreview() {
//  AppTheme {
//    PostTile(post)
//  }
//}
//
//@Preview(
//  name = "SearchBar Night",
//  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//fun PostTileDarkDefaultPreview() {
//  AppTheme {
//    PostTile(post)
//  }
//}