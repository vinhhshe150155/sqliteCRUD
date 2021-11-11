package com.example.ls7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddActivity : AppCompatActivity() {
    private lateinit var btnAdd : Button
    private lateinit var btnCancel : Button
    private lateinit var tvName : EditText
    private lateinit var tvDetail : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val db = DBManager(this)
        mapView()
        btnCancel.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
        btnAdd.setOnClickListener {
            val list = db.getAllFolder()
            val folder = Folder(list.size+1, tvName.text.toString(), tvDetail.text.toString())
            db.addFolder(folder)
            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    fun mapView(){
        btnAdd = findViewById(R.id.btn_add)
        btnCancel = findViewById(R.id.btn_cancel)
        tvName = findViewById(R.id.tv_name)
        tvDetail = findViewById(R.id.tv_detail)
    }
}