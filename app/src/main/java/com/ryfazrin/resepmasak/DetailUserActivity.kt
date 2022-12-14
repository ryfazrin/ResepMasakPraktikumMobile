package com.ryfazrin.resepmasak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.text.DecimalFormat

class DetailUserActivity : AppCompatActivity() {

    private lateinit var user: Resep

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)


        val imgUser: ImageView = findViewById(R.id.img_detail_user)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvFollowing: TextView = findViewById(R.id.text_following)
        val tvLocation: TextView = findViewById(R.id.tv_detail_location)
        val tvRepository: TextView = findViewById(R.id.tv_detail_repository)

        user = intent.getParcelableExtra<Resep>(EXTRA_USER) as Resep

        supportActionBar?.title = user.resep_title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load(user.avatar)
            .into(imgUser)
        tvName.text = user.resep_title
        tvFollowing.text = user.times
        tvLocation.text = user.difficulty
        tvRepository.text = user.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}