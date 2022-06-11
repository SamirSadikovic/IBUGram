package ba.ibu.gram.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
  val email: String,
  val displayName: String
):Parcelable
