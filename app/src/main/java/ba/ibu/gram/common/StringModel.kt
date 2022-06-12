package ba.ibu.gram.common

data class StringModel(val value: String): BaseModel {
  override fun toFunctionBody(): HashMap<String, Any> = hashMapOf(
    "value" to  value
  )
}