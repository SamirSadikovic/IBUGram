package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.FeedPost
import ba.ibu.gram.ui.components.SearchBar
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.SearchViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel(), navController: NavController? = null) {
  val results = listOf(
    User(
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
    ),
    User(
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
    ),
    User(
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
    ),
    User(
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
    ),
    User(
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
  ) //pick up users from db based on search terms
  var text by remember { mutableStateOf("") }

  Column(
    modifier = Modifier
      .padding(16.dp)
  ) {
    SearchBar(text){ text = it }
    LazyColumn(
      contentPadding = PaddingValues(2.dp),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.Center
    ) {
      items(results.size) { i ->
        val user = results[i]
        val profileImage = rememberAsyncImagePainter(user.photoUrl)
        val name = user.name
        val id = user.id

        if (i <= results.lastIndex && i != 0)
          Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)

        Row(
          horizontalArrangement = Arrangement.Start,
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(8.dp, 8.dp)
            .clickable { navController?.navigate("user/$id") }
        ){
          Image(
            painter = profileImage,
            contentDescription = null,
            modifier = Modifier
              .fillParentMaxHeight()
              .clip(CircleShape)
          )
          Text(
            name,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
              .padding(16.dp, 0.dp, 0.dp, 0.dp)
          )
        }
      }
    }
  }
}

  @Preview(
    name = "SearchScreen",
    showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
  )
  @Composable
  fun SearchScreenDefaultPreview() {
    AppTheme {
      SearchScreen()
    }
  }

  @Preview(
    name = "SearchScreen Night",
    showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
  )
  @Composable
  fun SearchScreenDarkDefaultPreview() {
    AppTheme {
      SearchScreen()
    }
  }