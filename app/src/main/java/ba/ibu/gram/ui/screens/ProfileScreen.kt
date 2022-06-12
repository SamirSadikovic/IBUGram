package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun ProfileScreen(viewModel: ProfileViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState

  LaunchedEffect(key1 = "start") {
    viewModel.getUserData()
  }
  val profileImage = rememberAsyncImagePainter(uiState.user?.photoUrl)

  if (uiState.userLoading || uiState.postsLoading) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      CircularProgressIndicator()
    }
  } else {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      if (uiState.user?.photoUrl != null) {
        Image(
          painter = profileImage,
          contentDescription = null,
          modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
        )
      } else {
        Icon(
          imageVector = Icons.Default.AccountCircle,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.primary,
          modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
        )
      }
      Text(
        uiState.user?.name ?: "",
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
          uiState.user?.bio ?: "",
          textAlign = TextAlign.Left,
          style = MaterialTheme.typography.bodyLarge,
          maxLines = 3,
          overflow = TextOverflow.Ellipsis
        )
      }
      Row(
        modifier = Modifier
          .fillMaxWidth()
      ) {
        Text(
          uiState.user?.following.toString(),
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier.weight(1f)
        )
        Text(
          uiState.user?.followers.toString(),
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier.weight(1f)
        )
        Text(
          uiState.user?.postCount.toString(),
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
        items(uiState.posts.size) { i ->
          PostTile(uiState.posts[i], Modifier.padding(2.dp)) {
            navController?.navigate("post/" + uiState.posts[i].id)
          }
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