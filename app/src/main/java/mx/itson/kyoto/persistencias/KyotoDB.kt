package mx.itson.kyoto.persistencias

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class KyotoDB(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqLiteDatebase: SQLiteDatabase) {
        try {
            sqLiteDatebase.execSQL("CREATE TABLE Usuario " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, telefono TEXT, email TEXT)")

        }catch (ex: Exception){
            Log.e("Ocurrio un error al crear la base de datos", ex.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}