package com.example.urbancut.remote

import retrofit2.Call
import com.example.urbancut.model.ProductosInfo
import com.example.urbancut.model.ServiciosInfo
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response

import retrofit2.http.*

interface RestApi {
    //@Headers("Content-Type: application/json")
    @POST("altaProducto")
    fun addProducto(@Body productosData: ProductosInfo): Call<ProductosInfo>

    @POST("altaServicio")
    fun addServicio(@Body serviciosData: ServiciosInfo): Call<ServiciosInfo>

    @PUT("modificarProducto")
    fun modificarProducto(@Body productosData: ProductosInfo): Call<ProductosInfo>


}