package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ba.ibu.gram.R
import ba.ibu.gram.ui.components.PostTile
import ba.ibu.gram.ui.theme.AppTheme

@Composable
fun ProfileScreen(navController: NavController? = null) {
  val profileImage = painterResource(R.drawable.profileimage);
  val followers = 420
  val following = 69
  val posts = 69
  val bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
      "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in " +
      "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
      "culpa qui officia deserunt mollit anim id est laborum."
  val postId = "1"

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    Image(
      painter = profileImage,
      contentDescription = null,
      modifier = Modifier
        .clip(CircleShape)
        .size(160.dp)
        .padding(24.dp)
    )
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Text(
        bio,
        textAlign = TextAlign.Left,
        style = MaterialTheme.typography.bodyLarge,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(0.dp, 0.dp,0.dp, 24.dp)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Text(
        following.toString(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.weight(1f)
      )
      Text(
        followers.toString(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.weight(1f)
      )
      Text(
        posts.toString(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.weight(1f)
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Text(
        "following",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.weight(1f)
      )
      Text(
        "followers",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.weight(1f)
      )
      Text(
        "posts",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.weight(1f)
      )
    }
    PostTile() {
      navController?.navigate("post/${1}")
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
  name = "Profile",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ProfileDefaultPreview() {
  AppTheme {
    Scaffold { _ ->
      ProfileScreen()
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
  name = "Profile Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileDarkDefaultPreview() {
  AppTheme {
    Scaffold { _ ->
      ProfileScreen()
    }
  }
}