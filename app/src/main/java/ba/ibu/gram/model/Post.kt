package ba.ibu.gram.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post (
  val photoUrl: String,
  val userId: String,
  val description: String,
  val likes: Int,
  val user: User?
):Parcelable