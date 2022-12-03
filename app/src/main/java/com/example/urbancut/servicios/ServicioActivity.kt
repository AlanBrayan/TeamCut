package com.example.urbancut.servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.urbancut.MainActivity
import com.example.urbancut.R
import kotlinx.android.synthetic.main.activity_servicio.*

class ServicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)

        btnVerSer.setOnClickListener{
            val intent = Intent(this, VerServicioActivity::class.java)
            startActivity(intent)
        }

        btnCreSer.setOnClickListener{
            val intent = Intent(this, CrearServicioActivity::class.java)
            startActivity(intent)
        }

        btnRegresar2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}