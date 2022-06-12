package ba.ibu.gram.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ba.ibu.gram.functions.CreatePostFunction
import ba.ibu.gram.model.Post
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.util.UUID
import javax.inject.Inject

data class CreatePostUiState(
  val imageLoading: Boolean = false,
  val buttonLoading: Boolean = false,
  val imageUrl: Uri? = null,
)

@HiltViewModel
class CreatePostViewModel @Inject constructor(private val storage: FirebaseStorage, private val createPostFunction: CreatePostFunction) : ViewModel() {
  var uiState by mutableStateOf(CreatePostUiState())

  suspend fun uploadImage(uri: Uri) {
    try {
      uiState = uiState.copy(imageLoading = true, imageUrl = uri)

      val reference = storage.reference.child("images").child(UUID.randomUUID().toString())
      val downloadUrl = reference.putFile(uri).continueWithTask {
        reference.downloadUrl
      }
        .await()

      uiState = uiState.copy(imageLoading = false, imageUrl = downloadUrl)
    } catch (e: Exception) {
      uiState = uiState.copy(imageLoading = false, imageUrl = null)
    }
  }

  suspend fun createPost(post: Post, navigate: () -> Unit = {}) {
    uiState = uiState.copy(buttonLoading = true)
    val p = createPostFunction.call(post)
    uiState = uiState.copy(buttonLoading = false)

    println(p)

    navigate()
  }
}
