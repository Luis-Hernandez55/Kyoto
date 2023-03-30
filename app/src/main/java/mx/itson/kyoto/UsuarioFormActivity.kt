package mx.itson.kyoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import mx.itson.kyoto.entidades.Usuario

class UsuarioFormActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var txtNombre: EditText
    lateinit var txtTelefono: EditText
    lateinit var txtEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_form)

        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtEmail = findViewById(R.id.txtEmail)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        btnGuardar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            (R.id.btnGuardar) ->{
                Usuario.guardar(applicationContext, ""+txtNombre, ""+txtTelefono, ""+txtEmail)
            }
        }
    }
}