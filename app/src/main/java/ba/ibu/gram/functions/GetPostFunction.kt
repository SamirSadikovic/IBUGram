package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.model.Post
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class GetPostFunction @Inject constructor() : BaseFunction<StringModel, Post>() {
  override suspend fun call(input: StringModel): Post? {
    return callFunction("getPost", input)
  }

  override fun getType(): Type = Post::class.java
}