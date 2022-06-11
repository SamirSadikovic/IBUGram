package ba.ibu.gram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import ba.ibu.gram.navigation.RootNavigation
import ba.ibu.gram.ui.theme.AppTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.functions.FirebaseFunctions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject lateinit var auth: FirebaseAuth
  @Inject lateinit var functions: FirebaseFunctions

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)

    setContent { App(auth.currentUser != null) }
  }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(loggedIn: Boolean) {
  AppTheme {
    val navController = rememberNavController()

    Scaffold { _ ->
      RootNavigation(navController, loggedIn)
    }
  }
}

