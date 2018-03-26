package com.example.user.stackoverflowapiproject.model

import android.os.Parcel
import android.os.Parcelable

data class PayloadResponse(
        var items: List<StackResponse> = listOf(StackResponse())
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(StackResponse.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(items)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PayloadResponse> = object : Parcelable.Creator<PayloadResponse> {
            override fun createFromParcel(source: Parcel): PayloadResponse = PayloadResponse(source)
            override fun newArray(size: Int): Array<PayloadResponse?> = arrayOfNulls(size)
        }
    }
}
