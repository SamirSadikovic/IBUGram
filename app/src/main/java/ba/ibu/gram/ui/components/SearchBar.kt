package ba.ibu.gram.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ba.ibu.gram.ui.theme.AppTheme

@Composable
fun SearchBar() {
  var text by remember { mutableStateOf("") }

  TextField(
    modifier = Modifier.fillMaxWidth(),
    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
    trailingIcon = {
      if (text.isNotBlank())
        Icon(
          imageVector = Icons.Default.Close,
          contentDescription = null,
          modifier = Modifier
            .clickable { text = "" }
            .padding(16.dp)
        )
      else
        null
    },
    placeholder = { Text("Search...") },
    value = text,
    onValueChange = { text = it }
  )
}

@Preview(
  name = "SearchBar",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun SearchDefaultPreview() {
  AppTheme {
    SearchBar()
  }
}

@Preview(
  name = "SearchBar Night",
  showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SearchDarkDefaultPreview() {
  AppTheme {
    SearchBar()
  }
}