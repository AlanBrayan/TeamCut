package com.example.urbancut.remote
import androidx.lifecycle.LiveData
import com.example.urbancut.model.ProductosInfo
import com.example.urbancut.model.ServiciosInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addProductos(productosData: ProductosInfo, onResult: (ProductosInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addProducto(productosData).enqueue(
            object : Callback<ProductosInfo> {
                override fun onFailure(call: Call<ProductosInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<ProductosInfo>, response: Response<ProductosInfo>) {
                    val addedProductos = response.body()
                    onResult(addedProductos)
                }
            }
        )
    }

    fun addServicios(serviciosData: ServiciosInfo, onResult: (ServiciosInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addServicio(serviciosData).enqueue(
            object : Callback<ServiciosInfo> {
                override fun onFailure(call: Call<ServiciosInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<ServiciosInfo>, response: Response<ServiciosInfo>) {
                    val addedServicios = response.body()
                    onResult(addedServicios)
                }
            }
        )
    }



    fun modificarProductos(productosData: ProductosInfo, onResult: (ProductosInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.modificarProducto(productosData).enqueue(
            object : Callback<ProductosInfo>{
                override fun onFailure(call: Call<ProductosInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<ProductosInfo>, response: Response<ProductosInfo>) {
                    val modificaredProductos = response.body()
                    onResult(modificaredProductos)
                }
            }
        )

    }


}