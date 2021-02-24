package udacoding.batch4.week2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelLogin (
        var username: String,
        var password: String
        ) : Parcelable