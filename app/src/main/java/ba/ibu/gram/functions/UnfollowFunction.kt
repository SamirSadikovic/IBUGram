package ba.ibu.gram.functions

import ba.ibu.gram.common.BaseFunction
import ba.ibu.gram.common.StringModel
import ba.ibu.gram.common.UnitModel
import java.lang.reflect.Type
import javax.inject.Inject

class UnfollowFunction @Inject constructor(): BaseFunction<StringModel, UnitModel>() {
  override suspend fun call(input: StringModel): UnitModel? {
    return callFunction("unfollow", input)
  }

  override fun getType(): Type = UnitModel:: class.java
}