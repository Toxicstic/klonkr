package nl.linsoft.klonkr.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "questions_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "questions")
    val question: String,

    @ColumnInfo(name = "mode")
    val mode: String
): Parcelable