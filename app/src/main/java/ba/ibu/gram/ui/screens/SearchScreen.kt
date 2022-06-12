package ba.ibu.gram.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.ui.components.SearchBar
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel(), navController: NavController? = null) {
  Column(
    modifier = Modifier
      .padding(16.dp)
  ) {
    SearchBar()
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