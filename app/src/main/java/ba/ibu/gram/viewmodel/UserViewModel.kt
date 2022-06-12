package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.functions.FollowFunction
import ba.ibu.gram.functions.GetFeedFunction
import ba.ibu.gram.functions.UnfollowFunction
import ba.ibu.gram.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class UserUiState(
  val following: Boolean = false
)

@HiltViewModel
class UserViewModel @Inject constructor(private val followFunction: FollowFunction, private val unfollowFunction: UnfollowFunction) : ViewModel() {
  var uiState by mutableStateOf(UserUiState())
    private set

  suspend fun follow(userId: String) {
    followFunction.call(StringModel(userId))
    uiState = uiState.copy(following = true)
  }

  suspend fun unfollow(userId: String) {
    unfollowFunction.call(StringModel(userId))
    uiState = uiState.copy(following = false)
  }
}
