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
import ba.ibu.gram.functions.LikeFunction
import ba.ibu.gram.functions.UnfollowFunction
import ba.ibu.gram.functions.UnlikeFunction
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
  val feedData: List<Post> = emptyList(),
  var liked: Boolean = false,
  val feedLoading: Boolean = false
)

@HiltViewModel
class FeedViewModel @Inject constructor(private val getFeedFunction: GetFeedFunction, private val likeFunction: LikeFunction, private val unlikeFunction: UnlikeFunction) : ViewModel() {
  var uiState by mutableStateOf(FeedUiState())

  fun getFeedData() {
    viewModelScope.launch {
      uiState = uiState.copy(feedLoading = true)
      uiState = uiState.copy(feedData = getFeedFunction.call(UnitModel())?: emptyList(), feedLoading = false)
    }
  }

  fun likeFunction(postId: String){
    viewModelScope.launch {
      likeFunction.call(StringModel(postId))
      val data = uiState.feedData.toMutableList()
      val index = data.indexOfFirst { it.id == postId }
      data[index] = data[index].copy(liked = true)
      uiState = uiState.copy(feedData = data)
    }
  }

  fun unlikeFunction(postId: String){
    viewModelScope.launch {
      unlikeFunction.call(StringModel(postId))
      val data = uiState.feedData.toMutableList()
      val index = data.indexOfFirst { it.id == postId }
      data[index] = data[index].copy(liked = false)
      uiState = uiState.copy(feedData = data)
    }
  }
}