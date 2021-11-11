package com.example.ls7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EditActivity : AppCompatActivity() {
    private lateinit var tvName : EditText
    private lateinit var tvDetail : EditText
    private lateinit var btnCancel : Button
    private lateinit var btnEdit : Button
    private lateinit var btnDelete : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        mapView()
        val db = DBManager(this)
        val folder = intent.getSerializableExtra("folder") as Folder
        tvName.setText(folder.name)
        tvDetail.setText(folder.detail)
        btnEdit.setOnClickListener{
            db.edit(Folder(folder.id, tvName.text.toString(), tvDetail.text.toString()))
            Toast.makeText(this, "Add successfully", Toast.LENGTH_SHORT).show()
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
        btnCancel.setOnClickListener {
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
        btnDelete.setOnClickListener {
            db.delete(folder.id)
            val newIntent = Intent(this, MainActivity::class.java)
            startActivity(newIntent)
        }
    }
    fun mapView(){
        tvName = findViewById(R.id.tv_name)
        tvDetail = findViewById(R.id.tv_detail)
        btnCancel = findViewById(R.id.btn_cancel)
        btnEdit = findViewById(R.id.btn_edit)
        btnDelete = findViewById(R.id.btn_delete)
    }
}