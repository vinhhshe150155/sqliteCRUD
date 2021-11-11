package com.example.ls7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView()
        val db = DBManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.list_folder)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = db.getAllFolder()
        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

    }
    fun mapView(){
        btnAdd = findViewById(R.id.btn_add)
    }
}