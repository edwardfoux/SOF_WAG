package com.example.user.stackoverflowapiproject.model

import android.os.Parcel
import android.os.Parcelable

data class BadgeCount(
        val bronze: Int = 0,
        val silver: Int = 0,
        val gold: Int = 0) : Parcelable {

    constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(bronze)
        writeInt(silver)
        writeInt(gold)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BadgeCount> = object : Parcelable.Creator<BadgeCount> {
            override fun createFromParcel(source: Parcel): BadgeCount = BadgeCount(source)
            override fun newArray(size: Int): Array<BadgeCount?> = arrayOfNulls(size)
        }
    }
}


