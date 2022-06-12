package ba.ibu.gram.common

import ba.ibu.gram.model.Post
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.functions.HttpsCallableResult
import com.google.firebase.functions.ktx.functions
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.lang.reflect.Type
import javax.inject.Inject

abstract class BaseFunction<I: BaseModel, O> {
  @Inject lateinit var functions: FirebaseFunctions
  @Inject lateinit var gson: Gson

  abstract suspend fun call(input: I): O?

  abstract fun getType(): Type

  protected suspend fun callFunction(functionName: String, input: I): O? {
    return try {
     println("JSON obj ${gson.toJson(input)}")

      val hashValue = functions
        .getHttpsCallable(functionName)
        .call(input.toFunctionBody())
        .await()
        .data

      println("Api value $hashValue")

      val jsonValue = gson.toJson(hashValue)
      return gson.fromJson(jsonValue, getType())
    } catch (e: Exception) {
      println("# Api error: $e")
      null
    }
  }


}