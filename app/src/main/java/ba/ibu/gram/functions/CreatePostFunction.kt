package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.UnitModel
import ba.ibu.gram.model.Post
import java.lang.reflect.Type
import javax.inject.Inject

class CreatePostFunction @Inject constructor() : BaseFunction<Post, UnitModel>() {
  override suspend fun call(input: Post): UnitModel? = callFunction("createPost", input)

  override fun getType(): Type = UnitModel::class.java
}