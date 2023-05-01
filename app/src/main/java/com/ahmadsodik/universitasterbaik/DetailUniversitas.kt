@file:Suppress("DEPRECATION")

package com.ahmadsodik.universitasterbaik

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Suppress("RedundantExplicitType")
class DetailUniversitas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_universitas)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Universitas"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetLokasi: TextView = findViewById(R.id.tv_item_lokasi)
        val tvSetIden: TextView = findViewById(R.id.Univ_detail)

        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tIDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tLokasi = intent.getStringExtra(EXTRA_LOKASI)
        val tImg = intent.getIntExtra(EXTRA_PHOTO,0)




        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetLokasi.text = tLokasi
        tvSetIden.text = tIDetail

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_LOKASI = "extra_lokasi"
        const val EXTRA_PHOTO = "extra_photo"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share->{
                shareApp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareApp() {
        val appMsg :String = "Share ke teman-teman mu!" + "https://play.google.com/store/apps/details?id=com.ahmadsodik.universitasterbaik"

        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT,appMsg)
        intent.type = "text/plain"
        startActivity(intent)
    }
}