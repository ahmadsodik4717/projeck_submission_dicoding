package com.ahmadsodik.universitasterbaik

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
                actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgLinkedIn = findViewById<ImageView>(R.id.ic_linkedin)
        val imgInstagram = findViewById<ImageView>(R.id.ic_instagram)
        val imgGit = findViewById<ImageView>(R.id.ic_github)
        imgLinkedIn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.linkedin.com/in/ahmad-sodik-03bb931aa")
            startActivity(intent)
        }
        imgInstagram.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://instagram.com/ahmadsodik4717")
            startActivity(intent)
        }
        imgGit.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/ahmsdk")
            startActivity(intent)
        }

    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}