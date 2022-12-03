package com.example.urbancut.productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.urbancut.R
import com.example.urbancut.model.ProductosInfo
import com.example.urbancut.remote.RestApiService
import kotlinx.android.synthetic.main.activity_crear_producto.*

class CrearProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_producto)

        btnCrearProducto.setOnClickListener{
            val apiService = RestApiService()
            val productosInfo = ProductosInfo(
                id_producto = null,
                nombre_producto = txtNombre.text.toString(),
                no_existencias = txtExistencias.text.toString().toDouble(),
                precio = txtPrecio.text.toString().toDouble(),
                descripcion = txtDescripcion.text.toString(),
                img = txtImg.text.toString()
            )

            apiService.addProductos(productosInfo){
                if (it?.id_producto != null) {
                    val intent = Intent(this, ProductActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Producto agregado con exito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Producto no agregado ", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnRegresar3.setOnClickListener{
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
    }
}