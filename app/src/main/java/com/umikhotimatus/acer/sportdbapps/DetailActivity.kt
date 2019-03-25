package com.umikhotimatus.acer.sportdbapps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image = intent.getStringExtra("IMAGE")
        val nama_team = intent.getStringExtra("NAMA_TEAM")
        val description_stadium = intent.getStringExtra("DESCRIPTION_STADIUM")
        val nama_stadium = intent.getStringExtra("NAMA_STADIUM")

        Glide.with(this)
            .load(image)
            .override(512, 512)
            .error(android.R.drawable.ic_dialog_alert)
            .into(ivPoster)


        tvNamaTeam.text = nama_team
        tvNamaStadium.text = nama_stadium
        tvDescriptionStadium.text = description_stadium
    }
}
