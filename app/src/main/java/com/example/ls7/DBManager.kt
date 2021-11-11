package com.example.ls7

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    private var query = "CREATE TABLE IF NOT EXISTS folder (id integer primary key, name text, detail text)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    companion object{
        const val DATABASE_NAME = "folder.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "folder"
    }
    fun addFolder(f: Folder){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("id", f.id)
        contentValues.put("name", f.name)
        contentValues.put("detail", f.detail)
        db.insert(TABLE_NAME,null, contentValues)
        db.close()
    }
    fun getAllFolder(): List<Folder>{

        val list = ArrayList<Folder>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        if(cursor.moveToFirst()){
            do{
                val folder = Folder(cursor.getInt(0),
                cursor.getString(1), cursor.getString(2))
                list.add(folder)
            }while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return list
    }
    fun edit(f : Folder){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name", f.name)
        contentValues.put("detail", f.detail)
        db.update(TABLE_NAME, contentValues, "id = " + f.id, null)
        db.close()
    }
    fun delete(id: Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "id = ?", Array(1){id.toString()})
        db.close()
    }
}