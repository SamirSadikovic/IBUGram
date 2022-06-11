package ba.ibu.gram.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User

@Composable
fun UserScreen(user: User?, navController: NavController? = null) {
  val posts = listOf(
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    ),
    Post(
      "https://preview.redd.it/o44hchf54ix01.jpg?auto=webp&s=f15413e4eecdd3574c92b58633bd6b62b232c7f1",
      "1",
      "Sample description",
      420,
      null
    )
  )
}