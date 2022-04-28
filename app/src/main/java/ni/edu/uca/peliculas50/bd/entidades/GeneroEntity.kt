package ni.edu.uca.peliculas50.bd.entidades

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="TblGenero")
data class GeneroEntity(
    @PrimaryKey(autoGenerate = true)
    val idGenero:Int = 0,
    @ColumnInfo(name = "activo")
    val activo: Boolean,
    @ColumnInfo(name = "nombre")
    val nombre: String

    ): Parcelable