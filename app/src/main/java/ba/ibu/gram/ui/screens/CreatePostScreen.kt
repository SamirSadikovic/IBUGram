package ba.ibu.gram.ui.screens

import android.graphics.Bitmap
import android.graphics.drawable.shapes.Shape
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.viewmodel.CreatePostViewModel
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePostScreen(viewModel: CreatePostViewModel = viewModel(), navController: NavController? = null) {
  val uiState = viewModel.uiState

  var description by remember { mutableStateOf("") }
  val image = rememberAsyncImagePainter(uiState.imageUrl)
  println(uiState.imageUrl)

  val scope = rememberCoroutineScope()

  val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
    scope.launch {
      if (uri != null) viewModel.uploadImage(uri)
    }
  }

  Scaffold(topBar = {
    SmallTopAppBar(
      title = { Text(text = "Create new post") },
      navigationIcon = {
        IconButton({ navController?.popBackStack() }) {
          Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null
          )
        }
      }
    )
  }) {
    Column(
      modifier = Modifier
        .padding(it)
        .padding(16.dp, 24.dp)
        .fillMaxHeight(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Bottom,
    ) {
      Box(
        modifier = Modifier
          .weight(1f)
          .fillMaxWidth(), contentAlignment = Alignment.Center
      ) {

        if (uiState.imageUrl != null) {
          Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
              .fillMaxWidth()
              .aspectRatio(1f)
              .clip(RoundedCornerShape(8.dp))
          )
        } else {
          OutlinedButton(
            onClick = { launcher.launch("image/*") },
            modifier = Modifier
              .size(250.dp),
            shape = RoundedCornerShape(64.dp)
          ) {

            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(48.dp))
          }
        }

        if (uiState.imageLoading) {
          CircularProgressIndicator()
        }
      }



      OutlinedTextField(
        value = description,
        onValueChange = { description = it },
        label = { Text("Description") },
        modifier = Modifier
          .fillMaxWidth()
          .padding(0.dp, 24.dp),
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
        )
      )

      if (uiState.buttonLoading) {
        CircularProgressIndicator()
      } else {
        Button(
          onClick = {
            scope.launch {
              viewModel.createPost(Post("", uiState.imageUrl.toString(), "", description)) { navController?.popBackStack() }
            }
          },
          modifier = Modifier.fillMaxWidth(),
          enabled = uiState.imageUrl.toString().startsWith("https://")
        ) {
          Text("Post", style = MaterialTheme.typography.labelLarge)
        }
      }
    }
  }

}
