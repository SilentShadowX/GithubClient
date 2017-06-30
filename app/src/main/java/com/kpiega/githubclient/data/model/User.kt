package com.kpiega.githubclient.data.model

import com.google.gson.annotations.SerializedName

data class User
    constructor(
            @SerializedName("login")
            val login: String,
            @SerializedName("avatar_url")
            val avatar: String)
    : Response()