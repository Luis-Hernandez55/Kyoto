package mx.itson.kyoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import mx.itson.kyoto.entidades.Usuario

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFormulario = findViewById<Button>(R.id.btnFormulario)
        btnFormulario.setOnClickListener(this)

        val btnListado = findViewById<Button>(R.id.btnListado)
        btnListado.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            (R.id.btnFormulario) -> {
                val intentFormulario = Intent(this, UsuarioFormActivity::class.java)
                startActivity(intentFormulario)
            }
            (R.id.btnListado) -> {
                val intentFormulario = Intent(this, UsuarioListActivity::class.java)
                startActivity(intentFormulario)
            }
        }
    }
}