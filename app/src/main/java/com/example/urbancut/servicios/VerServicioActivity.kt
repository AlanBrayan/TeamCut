package com.example.urbancut.servicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.urbancut.R
import kotlinx.android.synthetic.main.activity_ver_servicio.*

class VerServicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_servicio)

        btnRegresar4.setOnClickListener{
            val intent = Intent(this, ServicioActivity::class.java)
            startActivity(intent)
        }
    }
}