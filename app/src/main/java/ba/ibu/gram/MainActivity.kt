package ba.ibu.gram

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ba.ibu.gram.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)

    setContent {
      AppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Burch()
        }
      }
    }
  }
}

@Composable
fun Burch() {
  Image(painter = painterResource(R.drawable.ic_burch), contentDescription = null)
}

@Preview(
  name = "Burch",
  showBackground = true
)
@Composable
fun DefaultPreview() {
  AppTheme {
    Burch()
  }
}

@Preview(
  name = "Burch Night",
  showBackground = true, uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DarkDefaultPreview() {
  AppTheme {
    Burch()
  }
}
