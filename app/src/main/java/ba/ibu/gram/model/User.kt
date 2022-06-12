package ba.ibu.gram.model

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
  val userId: Int,
  val name: String,
  val photoUrl: String,
  val bio: String,
  val followers: Int,
  val following: Int,
  val postCount: Int
) : Parcelable {
  companion object {
    fun navType(): NavType<User> {
      return object : NavType<User>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): User? {
          return bundle.getParcelable(key)
        }

        override fun parseValue(value: String): User {
          println(value)
          return Gson().fromJson(value, User::class.java)
        }

        override fun put(bundle: Bundle, key: String, value: User) {
          bundle.putParcelable(key, value)
        }
      }
    }
  }
}

