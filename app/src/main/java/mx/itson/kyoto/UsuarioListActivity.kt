package mx.itson.kyoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import mx.itson.kyoto.adapters.UsuarioAdapter
import mx.itson.kyoto.entidades.Usuario

var listaUsuarios : ListView? = null

class UsuarioListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_list)

        listaUsuarios = findViewById(R.id.listUsuarios)

        cargarUsuarios()
    }

    fun cargarUsuarios(){
        val usuarios : List<Usuario> = Usuario.obtener(this)
        val usuarioAdapter = UsuarioAdapter(this, usuarios)
        listaUsuarios?.adapter = usuarioAdapter
    }


}