package com.example.favoritemovie

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movieBannerDetail: ImageView = findViewById(R.id.imageDetailMovie)
        val movieTitleDetail: TextView = findViewById(R.id.textViewDetailTitle)
        val movieOverviewDetail: TextView = findViewById(R.id.textDetailOverview)

        val img = intent.getStringExtra(EXTRA_IMAGE)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        Glide.with(this).load(img).into(movieBannerDetail)
        movieTitleDetail.text = title
        movieOverviewDetail.text = detail
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DETAIL = "extra_detail"
    }
}
