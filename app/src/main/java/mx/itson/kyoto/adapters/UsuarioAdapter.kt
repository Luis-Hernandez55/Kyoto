package mx.itson.kyoto.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.kyoto.R
import mx.itson.kyoto.entidades.Usuario
import kotlin.math.log

class UsuarioAdapter(context: Context?, usuarios: List<Usuario>)  : BaseAdapter(){

    var context : Context? = context
    var usuarios : List<Usuario> = usuarios

    override fun getCount(): Int {
        return usuarios.size
    }

    override fun getItem(i: Int): Any {
        return usuarios[i]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, p2: ViewGroup?): View {
        var elemento = LayoutInflater.from(context).inflate(R.layout.item_usuario, null)
        try {

            val u = getItem(i) as Usuario

            val txtNombre : TextView = elemento.findViewById(R.id.txtNombre)
            txtNombre.setText(u.nombre)

            val txtTelefono : TextView = elemento.findViewById(R.id.txtTelefono)
            txtTelefono.setText(u.telefono)

            val txtEmail : TextView = elemento.findViewById(R.id.txtEmail)
            txtEmail.setText(u.email)

        }catch (ex: Exception){
            Log.e("Ocurrio un errro al cargar la lista", ex.toString())
        }
        return elemento
    }

}