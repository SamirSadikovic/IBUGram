package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class GetFeedFunction @Inject constructor() : BaseFunction<UnitModel, List<Post>>() {
  override suspend fun call(input: UnitModel): List<Post>? {
    return callFunction("getFeed", input)
  }

  override fun getType(): Type = object : TypeToken<List<Post>>() {}.type
}