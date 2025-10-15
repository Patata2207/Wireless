package com.example.wireless

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var inputTexto: EditText
    private lateinit var btnenviar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MainActivity","Inicio la aplicacion")

        inputTexto = findViewById( R.id.inputTexto)
        btnenviar = findViewById(R.id.btnEnviar)

        btnenviar.setOnClickListener {
            val texto = inputTexto.text.toString().ifBlank { "Sin texto" }
            val intent = Intent(this, DetalleActivity::class.java).apply {
                putExtra("EXTRA_TEXTO", texto)
            }
            startActivity(intent)
        }


    }

}