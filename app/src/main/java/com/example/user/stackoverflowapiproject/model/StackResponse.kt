package com.example.user.stackoverflowapiproject.model

import android.os.Parcel
import android.os.Parcelable

data class StackResponse(
        val badge_counts: BadgeCount = BadgeCount(),
        val account_id: Int = 0,
        val is_employee: Boolean = false,
        val last_modified_date: Long = 0,
        val last_access_date: Long = 0,
        val age: Int = 0,
        val reputation_change_year: Int = 0,
        val reputation_change_quarter: Int = 0,
        val reputation_change_month: Int = 0,
        val reputation_change_week: Int = 0,
        val reputation_change_day: Int = 0,
        val reputation: Int = 0,
        val creation_date: Long = 0,
        val user_type: String = "",
        val user_id: Int = 0,
        val accept_rate: Int = 0,
        val location: String = "",
        val website_url: String = "",
        val link: String = "",
        val profile_image: String = "",
        val display_name: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<BadgeCount>(BadgeCount::class.java.classLoader),
            source.readInt(),
            1 == source.readInt(),
            source.readLong(),
            source.readLong(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readInt(),
            source.readLong(),
            source.readString(),
            source.readInt(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(badge_counts, 0)
        writeInt(account_id)
        writeInt((if (is_employee) 1 else 0))
        writeLong(last_modified_date)
        writeLong(last_access_date)
        writeInt(age)
        writeInt(reputation_change_year)
        writeInt(reputation_change_quarter)
        writeInt(reputation_change_month)
        writeInt(reputation_change_week)
        writeInt(reputation_change_day)
        writeInt(reputation)
        writeLong(creation_date)
        writeString(user_type)
        writeInt(user_id)
        writeInt(accept_rate)
        writeString(location)
        writeString(website_url)
        writeString(link)
        writeString(profile_image)
        writeString(display_name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<StackResponse> = object : Parcelable.Creator<StackResponse> {
            override fun createFromParcel(source: Parcel): StackResponse = StackResponse(source)
            override fun newArray(size: Int): Array<StackResponse?> = arrayOfNulls(size)
        }
    }
}
