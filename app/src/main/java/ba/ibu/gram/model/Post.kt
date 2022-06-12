package ba.ibu.gram.model

import ba.ibu.gram.common.BaseModel

data class Post(
  val id: String,
  val photoUrl: String,
  val userId: String,
  val description: String,
  val likes: Int? = null,
  val user: User? = null
) : BaseModel {
  override fun toFunctionBody(): HashMap<String, Any> = hashMapOf(
    "photoUrl" to photoUrl,
    "description" to description
  )
}

