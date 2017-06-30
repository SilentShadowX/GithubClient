package com.kpiega.githubclient.data.model

import com.google.gson.annotations.SerializedName

data class UserDetails
constructor(
        @SerializedName("login")
        val login: String,
        @SerializedName("avatar_url")
        val avatar: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("location")
        val location: String)
: Response()