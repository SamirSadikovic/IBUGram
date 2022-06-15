package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.functions.FollowFunction
import ba.ibu.gram.functions.GetFeedFunction
import ba.ibu.gram.functions.GetUserFunction
import ba.ibu.gram.functions.GetUserPostsFunction
import ba.ibu.gram.functions.UnfollowFunction
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserUiState(
  val following: Boolean = false,
  val userLoading: Boolean = false,
  val postsLoading: Boolean = false,
  val followLoading: Boolean = false,
  val user: User? = null,
  val posts: List<Post> = emptyList()
)

@HiltViewModel
class UserViewModel @Inject constructor(
  private val followFunction: FollowFunction,
  private val unfollowFunction: UnfollowFunction,
  private val getUserFunction: GetUserFunction,
  private val getUserPostsFunction: GetUserPostsFunction,
) : ViewModel() {
  var uiState by mutableStateOf(UserUiState())
    private set

  fun getUserData(userId: String) {
    viewModelScope.launch {
      uiState = uiState.copy(userLoading = true)
      val user = getUserFunction.call(StringModel(userId))
      uiState = uiState.copy(userLoading = false, user = user, following = if (user?.isFollowed != null) user.isFollowed else false)
    }

    viewModelScope.launch {
      uiState = uiState.copy(postsLoading = true)
      val posts = getUserPostsFunction.call(StringModel(userId))
      uiState = uiState.copy(posts = posts ?: emptyList(), postsLoading = false)
    }
  }

  fun follow(userId: String) {
    viewModelScope.launch {
      uiState = uiState.copy(followLoading = true)
      followFunction.call(StringModel(userId))
      uiState = uiState.copy(following = true, followLoading = false)
    }
  }

  fun unfollow(userId: String) {
    viewModelScope.launch {
      uiState = uiState.copy(followLoading = true)
      unfollowFunction.call(StringModel(userId))
      uiState = uiState.copy(following = false, followLoading = false)
    }
  }
}
