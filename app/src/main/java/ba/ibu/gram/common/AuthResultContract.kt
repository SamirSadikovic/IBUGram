package ba.ibu.gram.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task

fun getGoogleSignInClient(context: Context): GoogleSignInClient {
  val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
    .requestEmail()
    .requestIdToken("866108403683-cl0945adolv0ccmfinm6ki3d8m1ura4a.apps.googleusercontent.com")
    .build()

  return GoogleSignIn.getClient(context, signInOptions)
}

class AuthResultContract : ActivityResultContract<Int, Task<GoogleSignInAccount>?>() {
  override fun createIntent(context: Context, input: Int): Intent =
    getGoogleSignInClient(context).signInIntent.putExtra("input", input)

  override fun parseResult(resultCode: Int, intent: Intent?): Task<GoogleSignInAccount>? {
    return when (resultCode) {
      Activity.RESULT_OK -> GoogleSignIn.getSignedInAccountFromIntent(intent)
      else               -> null
    }
  }
}