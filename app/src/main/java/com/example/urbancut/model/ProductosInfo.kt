package com.example.urbancut.model

import com.google.gson.annotations.SerializedName

data class ProductosInfo(
    @SerializedName("id_producto") val id_producto: Int?,
    @SerializedName("nombre_producto") val nombre_producto: String?,
    @SerializedName("no_existencias") val no_existencias: Double?,
    @SerializedName("precio") val precio: Double?,
    @SerializedName("descripcion") val descripcion: String?,
    @SerializedName("img") val img: String?

)
