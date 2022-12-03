package com.example.urbancut.productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.urbancut.MainActivity
import com.example.urbancut.R
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.android.synthetic.main.activity_producto.btnRegresar

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)


        btnVerPro.setOnClickListener{
            val intent = Intent(this, VerProductoActivity::class.java)
            startActivity(intent)
        }

        btnCrePro.setOnClickListener{
            val intent = Intent(this, CrearProductoActivity::class.java)
            startActivity(intent)
        }

        btnRegresar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }


}