package com.ahmadsodik.universitasterbaik

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("unused")
class MainActivity : AppCompatActivity() {
    private lateinit var rvUniversitas: RecyclerView
    private var list: ArrayList<Universitas> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar?.title= "Universitas Terbaik"

        rvUniversitas = findViewById(R.id.rv_list)
        rvUniversitas.setHasFixedSize(true)

        list.addAll(UniversitasData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvUniversitas.layoutManager = LinearLayoutManager(this)
        val listUniversitasAdapter = ListUniversitasAdapter(list)
        rvUniversitas.adapter = listUniversitasAdapter
    }
    private fun showSelectedHero(universitas: Universitas) {
        Toast.makeText(this,
            "Kamu memilih " + universitas.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId==R.id.about_page) {
            startActivity(Intent(this,About::class.java))
            true
        }else super.onOptionsItemSelected(item)
    }

}