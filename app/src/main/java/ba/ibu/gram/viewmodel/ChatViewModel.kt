package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.functions.GetFeedFunction
import ba.ibu.gram.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class ChatUiState(
  val post: Post? = null
)

@HiltViewModel
class ChatViewModel @Inject constructor(private val getFeedFunction: GetFeedFunction) : ViewModel() {
  var uiState by mutableStateOf(ChatUiState())
    private set

  suspend fun fetchPost() {
    println(getFeedFunction.call(UnitModel()))
  }
}