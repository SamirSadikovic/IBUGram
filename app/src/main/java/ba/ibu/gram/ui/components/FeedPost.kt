package ba.ibu.gram.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.theme.AppTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun FeedPost(post: Post, modifier: Modifier = Modifier, liked: Boolean, onNameClick: () -> Unit = {}, onReact: (liked: Boolean) -> Unit = {}) {
  val postImage = rememberAsyncImagePainter(post.photoUrl)
  val userName = post.user?.name
  val description = post.description
  val likes = post.likes

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .fillMaxWidth()
  ) {
    Image(
      painter = postImage,
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
    )
    Row(
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
      IconToggleButton(
        checked = liked,
        onCheckedChange = { onReact(it) },
        modifier = Modifier
          .size(32.dp)
      ) {
        Icon(
          imageVector = if (liked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
          contentDescription = null,
          modifier = Modifier
            .fillMaxSize()
        )
      }
      Text(
        likes.toString(),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
          .padding(8.dp, 0.dp)
      )
      Text(
        "-",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
      )
      if (userName != null) {
        Text(
          "userName",
          style = MaterialTheme.typography.bodyLarge,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          modifier = Modifier
            .padding(8.dp, 0.dp)
            .clickable { onNameClick() }
        )
      }
    }
    Row(
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.Top,
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp, 0.dp, 8.dp, 8.dp)
    ) {
      if (description != null) {
        Text(
          description,
          textAlign = TextAlign.Left,
          style = MaterialTheme.typography.bodyLarge,
          maxLines = 3,
          overflow = TextOverflow.Ellipsis
        )
      }
    }
  }
}

//@Preview(
//  name = "FeedPost",
//  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
//)
//@Composable
//fun FeedPostDefaultPreview() {
//  AppTheme {
//    FeedPost(feedPost, false)
//  }
//}
//
//@Preview(
//  name = "FeedPost Night",
//  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//fun FeedPostDarkDefaultPreview() {
//  AppTheme {
//    FeedPost(feedPost, false)
//  }
//}