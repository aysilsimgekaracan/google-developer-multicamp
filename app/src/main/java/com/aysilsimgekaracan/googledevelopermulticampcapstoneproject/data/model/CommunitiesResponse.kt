package com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

object Communities {
    @Serializable
    @Parcelize
    data class CommunitiesResponse (
        val name: String?,
        val description: String?,
        val banner: String?,
        val leader: Leader?,
        val links: Links?
    ) : Parcelable
}


@Serializable
@Parcelize
data class Leader (
    val name: String?,
    val photo: String?
) : Parcelable

@Serializable
@Parcelize
data class Links (
    val instagram: String?,
    val twitter: String?,
    val youtube: String?,
    val participation: String?
) : Parcelable

