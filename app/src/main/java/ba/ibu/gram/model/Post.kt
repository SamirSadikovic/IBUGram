package ba.ibu.gram.model

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
  val id: Int,
  val photoUrl: String,
  val userId: String,
  val description: String,
  val likes: Int,
  val user: User?
) : Parcelable {
  companion object {
    fun navType(): NavType<Post> {
      return object : NavType<Post>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): Post? {
          return bundle.getParcelable(key)
        }

        override fun parseValue(value: String): Post {
          return Gson().fromJson(value, Post::class.java)
        }

        override fun put(bundle: Bundle, key: String, value: Post) {
          bundle.putParcelable(key, value)
        }
      }
    }
  }
}

