package com.example.urbancut.model

import com.google.gson.annotations.SerializedName

data class ServiciosInfo(
    @SerializedName("id_servicio") val id_servicio: Int?,
    @SerializedName("nombre_servicio") val nombre_servicio: String?,
    @SerializedName("descripcion") val descripcion: String?,
    @SerializedName("precio") val precio: Double?,
    @SerializedName("img") val img: String?
)
