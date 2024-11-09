import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Hero (
    val heroImage: Int,
    val heroName: String,
    val heroCompany: String,
    val heroPower: String,
    val alterEgo: String,
    val powerOrigins: String,
    val enemies: String,
    val creationDate: String
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeInt(heroImage);
        p0.writeString(heroName);
        p0.writeString(heroCompany);
        p0.writeString(heroPower)
        p0.writeString(alterEgo)
        p0.writeString(powerOrigins)
        p0.writeString(enemies)
        p0.writeString(creationDate)
    }

    companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }

        override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }
    }
}