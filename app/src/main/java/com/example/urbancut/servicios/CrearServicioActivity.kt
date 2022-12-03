package com.example.urbancut.servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.urbancut.R
import com.example.urbancut.model.ServiciosInfo
import com.example.urbancut.remote.RestApiService
import kotlinx.android.synthetic.main.activity_crear_servicio.*
import kotlinx.android.synthetic.main.activity_crear_servicio.btnRegresar3

class CrearServicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_servicio)

        btnCrearServicio.setOnClickListener{
            val apiService = RestApiService()
            val serviciosInfo = ServiciosInfo(
                id_servicio = null,
                nombre_servicio = txtNombreSer.text.toString(),
                precio = txtPrecioSer.text.toString().toDouble(),
                descripcion = txtDescripcionSer.text.toString(),
                img = txtImgSer.text.toString()
            )

            apiService.addServicios(serviciosInfo){
                if (it?.id_servicio != null) {
                    val intent = Intent(this, ServicioActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Servicio agregado con exito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Servicio no agregado ", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnRegresar3.setOnClickListener{
            val intent = Intent(this, ServicioActivity::class.java)
            startActivity(intent)
        }
    }
}