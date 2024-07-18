package com.example.smartspaceaware.helper

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class ContextualIntegrityData(
    @SerializedName("device")@Expose var device:String?=null,
    @SerializedName("sensor")@Expose var sensor: String?=null,
    @SerializedName("purpose")@Expose var purpose: String?=null,
    @SerializedName("dataType")@Expose var dataType: String?=null,
    @SerializedName("dataRetention")@Expose var dataRetention: String?=null,
    @SerializedName("dataAccess")@Expose var dataAccess: String?=null,
    @SerializedName("description")@Expose var description: String?=null,
    @SerializedName("images")@Expose var image: String?=null
)
