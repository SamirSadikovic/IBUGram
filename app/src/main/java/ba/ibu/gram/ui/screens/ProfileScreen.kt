package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.R
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.PostTile
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.ProfileViewModel
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel(), navController: NavController? = null) {
  val profileUser = User(
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
  val profileImage = rememberAsyncImagePainter(profileUser.photoUrl)
  val name = profileUser.name
  val followers = profileUser.followers
  val following = profileUser.following
  val posts = profileUser.postCount
  val bio = profileUser.bio

  val postList = listOf(
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    ),
    Post(
      1,
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      1,
      "Sample description",
      420,
      profileUser
    )
  ) //pick up posts from db based on userID

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    FilledTonalIconButton(
      onClick = { navController?.navigate("settings") },
      modifier = Modifier
        .align(Alignment.End)
    ) {
      Icon(
        imageVector = Icons.Default.Settings,
        contentDescription = null
      )
    }
    Image(
      painter = profileImage,
      contentDescription = null,
      modifier = Modifier
        .size(160.dp)
        .clip(CircleShape)
    )
    Text(
      name,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.titleLarge,
      modifier = Modifier
        .padding(0.dp, 8.dp, 0.dp, 16.dp)
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
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 24.dp)
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
    LazyVerticalGrid(
      columns = GridCells.Fixed(3),
      modifier = Modifier
        .padding(0.dp, 24.dp)
    ) {
      items(postList.size) { i ->
        PostTile(postList[i], Modifier.padding(2.dp)){
          navController?.navigate("post/" + postList[i].id)
        }
      }
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