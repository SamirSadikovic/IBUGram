package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.functions.FollowFunction
import ba.ibu.gram.functions.GetFeedFunction
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

data class FeedUiState(
  val feedData: List<Post>? = null
)

@HiltViewModel
class FeedViewModel @Inject constructor(private val getFeedFunction: GetFeedFunction) : ViewModel() {
  var uiState by mutableStateOf(FeedUiState())

  init {
    viewModelScope.launch {
      uiState = uiState.copy(feedData = getFeedFunction.call(UnitModel()))
    }
  }
}