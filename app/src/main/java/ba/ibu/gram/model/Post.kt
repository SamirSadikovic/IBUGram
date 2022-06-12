package ba.ibu.gram.model

import ba.ibu.gram.common.BaseModel

data class Post(
  val id: String,
  val photoUrl: String,
  val userId: String,
  val description: String,
  var likes: Int? = null,
  var liked: Boolean = false,
  val user: User? = null
) : BaseModel {
  override fun toFunctionBody(): HashMap<String, Any> = hashMapOf(
    "photoUrl" to photoUrl,
    "description" to description
  )
}

