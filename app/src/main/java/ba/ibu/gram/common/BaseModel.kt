package ba.ibu.gram.common

interface BaseModel {
  fun toFunctionBody(): HashMap<String, Any>
}