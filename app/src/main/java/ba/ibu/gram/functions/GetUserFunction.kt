package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.model.Post
import ba.ibu.gram.model.User
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class GetUserFunction @Inject constructor() : BaseFunction<StringModel, User>() {
  override suspend fun call(input: StringModel): User? {
    return callFunction("getUser", input)
  }

  override fun getType(): Type = User::class.java
}