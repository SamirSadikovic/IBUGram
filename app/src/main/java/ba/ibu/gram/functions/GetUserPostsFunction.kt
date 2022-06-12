package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.model.Post
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class GetUserPostsFunction @Inject constructor() : BaseFunction<StringModel, List<Post>>() {
  override suspend fun call(input: StringModel): List<Post>? {
    return callFunction("getUserPosts", input)
  }

  override fun getType(): Type = object : TypeToken<List<Post>>() {}.type
}