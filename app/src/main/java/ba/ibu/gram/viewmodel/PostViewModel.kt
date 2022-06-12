package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.functions.GetPostFunction
import ba.ibu.gram.functions.LikeFunction
import ba.ibu.gram.functions.UnlikeFunction
import ba.ibu.gram.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PostUiState(
  val post: Post? = null,
  val liked: Boolean = false
)

@HiltViewModel
class PostViewModel @Inject constructor(private val getPostFunction: GetPostFunction, private val likeFunction: LikeFunction, private val unlikeFunction: UnlikeFunction) : ViewModel() {
  var uiState by mutableStateOf(PostUiState())

  fun likeFunction(postId: String){
    viewModelScope.launch {
      likeFunction.call(StringModel(postId))
      uiState = uiState.copy(liked = true)
    }
  }

  fun unlikeFunction(postId: String){
    viewModelScope.launch {
      unlikeFunction.call(StringModel(postId))
      uiState = uiState.copy(liked = false)
    }
  }

  fun getPostData(postId: String) {
    viewModelScope.launch {
      val post = getPostFunction.call(StringModel(postId))
      uiState = uiState.copy(post = post, liked = if (post?.liked != null) post.liked!! else false)
    }
  }
}