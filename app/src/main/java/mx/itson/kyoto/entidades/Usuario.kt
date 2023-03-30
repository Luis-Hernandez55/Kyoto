package mx.itson.kyoto.entidades

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.kyoto.persistencias.KyotoDB

object Usuario : java.io.Serializable{

    var id = 0
    var nombre: String? = null
    var telefono: String? = null
    var email: String? = null



    fun guardar(context: Context, nombre: String, telefono: String, email: String){
        try {
            val kyotoDB = KyotoDB(context, "Kyoto", null, 1)
            val baseDatos : SQLiteDatabase = kyotoDB.writableDatabase
            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("telefono", telefono)
            valores.put("email", email)
            baseDatos.insert("Usuario", null, valores)
        }catch (ex: Exception){
            Log.e("Ocurrio un error al guaradar", ex.toString())
        }
    }

    fun editar(context: Context, id: Int, nombre: String, telefono: String, email: String){
        try{
            val kyotoDB = KyotoDB(context, "KyotoDB", null, 1)
            val baseDatos : SQLiteDatabase = kyotoDB.writableDatabase
            val valores = ContentValues()
            valores.put("nombre", nombre)
            valores.put("telefono", telefono)
            valores.put("email", email)

            val idUsuario = arrayOf(id.toString())
            baseDatos.update("Usuario", valores, "id = ?", idUsuario)
        } catch (ex: Exception){
            Log.e("Ocurrió un error al guardar usuario", ex.toString())
        }
    }

    fun obtener(context: Context) : List<Usuario>{
        var usuarios : MutableList<Usuario> = ArrayList()
        try {
            val kyotoDB = KyotoDB(context, "Kyoto", null, 1)
            val baseDatos : SQLiteDatabase = kyotoDB.readableDatabase

            val cursor = baseDatos.rawQuery("SELECT id, nombre, telefono, email FROM Usuario", null)
            //cursor es una clase que representa el resulset que arroja la consulta

            while (cursor.moveToNext()){
                var u = Usuario.apply {
                    nombre = cursor.getString(1)
                    telefono = cursor.getString(2)
                    email = cursor.getString(3)
                }
                usuarios.add(u)
            }

        }catch (ex: Exception){
            Log.e("Ocurrio un error los usuarios", ex.toString())
        }
        return usuarios
    }
}