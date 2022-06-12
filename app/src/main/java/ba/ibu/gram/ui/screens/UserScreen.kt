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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.PostTile
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.ProfileViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun UserScreen(userId: String?, navController: NavController? = null, viewModel: ProfileViewModel = viewModel()) {
  val userId = User( //pick up user from db based on ID
    "1",
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

  val postList = listOf(
    Post(
      "1",
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      userId
    ),
    Post(
      "1",
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      userId
    ),
    Post(
      "1",
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      userId
    ),
    Post(
      "1",
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      userId
    ),
    Post(
      "1",
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      userId
    )
  )//pick up posts from db based on ID

  val profileImage = rememberAsyncImagePainter(userId.photoUrl)
  val name = userId.name
  val followers = userId.followers
  val following = userId.following
  val posts = userId.postCount
  val bio = userId.bio
  var isFollowed by remember { mutableStateOf(false) }

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
        overflow = TextOverflow.Ellipsis
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 16.dp)
    ) {
      if (isFollowed)
        OutlinedButton(
          onClick = { isFollowed = !isFollowed },
          modifier = Modifier
            .fillMaxWidth()
        ) {
          Text(
            "Unfollow",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
          )
        }
      else
        Button(
          onClick = { isFollowed = !isFollowed },
          modifier = Modifier
            .fillMaxWidth()
        ) {
          Text(
            "Follow",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
          )
        }
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
  name = "User",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun UserDefaultPreview() {
  AppTheme {
    Scaffold { _ ->
      UserScreen("zSAnROYvqlae0JC9OIGf")
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
  name = "Profile Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun UserDarkDefaultPreview() {
  AppTheme {
    Scaffold { _ ->
      UserScreen("zSAnROYvqlae0JC9OIGf")
    }
  }
}