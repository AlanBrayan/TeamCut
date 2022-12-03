package com.example.urbancut.productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.urbancut.R
import com.example.urbancut.model.ProductosInfo
import com.example.urbancut.remote.RestApi
import com.example.urbancut.remote.RestApiService
import com.example.urbancut.remote.ServiceBuilder
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_crear_producto.*
import kotlinx.android.synthetic.main.activity_ver_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.create

class VerProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_producto)


        btnRegresar.setOnClickListener{
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }

        btnEliminarProducto.setOnClickListener {
            val url:String="https://eoompnbt.lucusvirtual.es/api/eliminaProducto/" + txt_ID.text.toString()
            val rq: RequestQueue = Volley.newRequestQueue(this)
            val sr = StringRequest(Request.Method.DELETE, url, Response.Listener { response ->
                Toast.makeText(this, "Producto eliminado", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
            }
            , Response.ErrorListener { error ->
                    Toast.makeText(this, "Producto no se elimino", Toast.LENGTH_SHORT).show()
                })
            rq.add(sr)


        }

    }




    fun buscarProducto(view: View) {
        val id_producto = findViewById<EditText>(R.id.txt_ID)
        val nombre_producto = findViewById<TextView>(R.id.txtVerNomPro)
        val no_existencias = findViewById<TextView>(R.id.txtVerExisPro)
        val precio = findViewById<TextView>(R.id.txtVerPrePro)
        val descripcion = findViewById<TextView>(R.id.txtVerDesPro)

        val url:String="https://eoompnbt.lucusvirtual.es/api/buscaProducto/" + id_producto.text.toString()
        val rq: RequestQueue = Volley.newRequestQueue(this)
        val jor= JsonObjectRequest(Request.Method.GET,url,null, Response.Listener { response ->
            nombre_producto.text=response.getString("nombre_producto")
            no_existencias.text=response.getString("no_existencias")
            precio.text=response.getString("precio")
            descripcion.text=response.getString("descripcion")
        }, Response.ErrorListener { error ->
            nombre_producto.text=error.message
        })
        rq.add(jor)
    }


    fun modificarProducto(view: View) {
        val apiService = RestApiService()
        val productosInfo = ProductosInfo(
            id_producto = txt_ID.text.toString().toInt(),
            nombre_producto = txtVerNomPro.text.toString(),
            no_existencias = txtVerExisPro.text.toString().toDouble(),
            precio = txtVerPrePro.text.toString().toDouble(),
            descripcion = txtVerDesPro.text.toString(),
            img = null
        )

        apiService.modificarProductos(productosInfo){
            if (it?.id_producto != null) {
                val intent = Intent(this, ProductActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Producto modificado con exito", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Producto no modificado ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}