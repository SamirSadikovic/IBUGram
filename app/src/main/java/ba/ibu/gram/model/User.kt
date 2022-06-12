package ba.ibu.gram.model

data class User(
  val id: String,
  val name: String,
  val photoUrl: String,
  val bio: String,
  val followers: Int,
  val following: Int,
  val postCount: Int
)

