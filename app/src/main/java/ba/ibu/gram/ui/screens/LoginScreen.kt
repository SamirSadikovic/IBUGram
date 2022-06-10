package ba.ibu.gram.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.R
import ba.ibu.gram.common.AuthResultContract
import ba.ibu.gram.ui.theme.AppTheme
import ba.ibu.gram.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel(), navController: NavController? = null) {
  val signInRequestCode = 1
  var loading by remember { mutableStateOf(false) }

  val authResultLauncher =
    rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
      if (task?.result != null) {
        viewModel.signIn(task.result) {
          navController?.navigate("main") {
            popUpTo("auth") { inclusive = true }
          }
        }
        loading = false
      }
    }

  Column(
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .padding(48.dp)
      .fillMaxSize()
  ) {
    val painter = painterResource(R.drawable.ic_burch)

    Image(
      painter = painter, contentDescription = null,
      modifier = Modifier
        .weight(1f, fill = false)
        .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
        .fillMaxWidth()
    )

    if (loading) {
      CircularProgressIndicator()
    } else {
      LoginButton {
        authResultLauncher.launch(signInRequestCode)
        loading = true
      }
    }
  }
}

@Composable
fun LoginButton(onClick: () -> Unit = {}) {
  Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Icon(
        painter = painterResource(R.drawable.ic_google),
        contentDescription = null,
      )
      Text(
        text = stringResource(R.string.login),
      )
    }
  }
}

@Preview(
  name = "Login",
  showBackground = true, uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun DefaultPreview() {
  AppTheme {
    LoginScreen()

  }
}

@Preview(
  name = "Login Night",
  showBackground = true, uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DarkDefaultPreview() {
  AppTheme {
    LoginScreen()
  }
}
