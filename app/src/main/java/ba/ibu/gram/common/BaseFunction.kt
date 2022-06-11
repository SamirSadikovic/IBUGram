package ba.ibu.gram.common

import com.google.firebase.functions.FirebaseFunctions
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

abstract class BaseFunction<I, O> {
  @Inject lateinit var functions: FirebaseFunctions

  abstract suspend fun call(input: I): O

  protected suspend fun callFunction(functionName: String, input: I): O? {
    return try {
      functions
        .getHttpsCallable(functionName)
        .call(input)
        .await()
        .data as? O
    } catch (e: Exception) {
      null
    }
  }
}