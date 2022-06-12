package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.model.User
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class SearchUsersFunction @Inject constructor() : BaseFunction<StringModel, List<User>>() {
  override suspend fun call(input: StringModel): List<User>? {
    return callFunction("searchUsers", input)
  }

  override fun getType(): Type = object : TypeToken<List<User>>() {}.type
}