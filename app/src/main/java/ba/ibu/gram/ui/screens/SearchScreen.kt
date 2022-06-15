package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.User
import ba.ibu.gram.ui.components.SearchBar
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.SearchViewModel
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState
  val textSearch by uiState.textSearch.collectAsState()

  Column(
    modifier = Modifier
      .padding(16.dp)
  ) {
    SearchBar(textSearch) {
      viewModel.setSearchText(it)
    }
    if (uiState.searchLoading) {
      Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
      }
    } else {
      LazyColumn(
        contentPadding = PaddingValues(2.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
      ) {
        if (uiState.searchResults != null) {
          items(uiState.searchResults.size) { i ->
            val user = uiState.searchResults[i]
            val profileImage = rememberAsyncImagePainter(user.photoUrl)
            val name = user.name
            val id = user.id

            if (i <= uiState.searchResults.lastIndex && i != 0)
              Divider(color = MaterialTheme.colorScheme.outline, thickness = 0.5.dp)

            Row(
              horizontalArrangement = Arrangement.Start,
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(8.dp, 8.dp)
                .clickable { navController?.navigate("user/$id") }
            ) {
              Image(
                painter = profileImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                  .fillParentMaxHeight()
                  .aspectRatio(1f)
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