package ba.ibu.gram.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.functions.GetPostFunction
import ba.ibu.gram.functions.SearchUsersFunction
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
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchUiState(
  val searchResults: List<User>? = null,
  var textSearch: MutableStateFlow<String> = MutableStateFlow(""),
  val searchLoading: Boolean = false
)

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUsersFunction: SearchUsersFunction) : ViewModel() {
  var uiState by mutableStateOf(SearchUiState())
  private val textSearch: StateFlow<String> = uiState.textSearch

  init {
    viewModelScope.launch {
      uiState = uiState.copy(searchLoading = true)
      textSearch.debounce(1000).collect { query ->
        uiState = uiState.copy(searchResults = searchUsersFunction.call(StringModel(query)), searchLoading = false)
      }
    }
  }

  fun setSearchText(it: String) {
    uiState.textSearch.value = it
  }
}