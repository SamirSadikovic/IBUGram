package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.functions.FollowFunction
import ba.ibu.gram.functions.GetProfileFunction
import ba.ibu.gram.functions.GetProfilePostsFunction
import ba.ibu.gram.functions.GetUserFunction
import ba.ibu.gram.functions.GetUserPostsFunction
import ba.ibu.gram.functions.UnfollowFunction
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
  val userLoading: Boolean = false,
  val postsLoading: Boolean = false,
  val user: User? = null,
  val posts: List<Post> = emptyList()
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
  private val getProfileFunction: GetProfileFunction,
  private val getProfilePostsFunction: GetProfilePostsFunction
) : ViewModel() {
  var uiState by mutableStateOf(ProfileUiState())
    private set

  fun getUserData() {
    viewModelScope.launch {
      uiState = uiState.copy(userLoading = true)
      val user = getProfileFunction.call(UnitModel())
      uiState = uiState.copy(userLoading = false, user = user)
    }

    viewModelScope.launch {
      uiState = uiState.copy(postsLoading = true)
      val posts = getProfilePostsFunction.call(UnitModel())
      uiState = uiState.copy(posts = posts ?: emptyList(), postsLoading = false)
    }
  }
}
