package ba.ibu.gram.model

data class Post(
  val id: Int,
  val photoUrl: String,
  val userId: Int,
  val description: String,
  val likes: Int,
  val user: User?
)

