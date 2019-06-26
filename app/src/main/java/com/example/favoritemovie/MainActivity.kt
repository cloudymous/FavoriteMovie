
package com.example.favoritemovie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvList: RecyclerView
    private var list: ArrayList<Movie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList = findViewById(R.id.recyclerMainMenu)
        rvList.setHasFixedSize(true)

        list.addAll(MovieData.listData)
        showRecylerList()

    }

    private fun showRecylerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvList.adapter = listMovieAdapter

        listMovieAdapter.onItemClickListener = { movie ->
            showDetailMovie(movie)
        }
    }

    private fun showDetailMovie(movie: Movie) {

        val detailMovieIntent = Intent(this@MainActivity, DetailMovieActivity::class.java)
        detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_TITLE, movie.movieName)
        detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_DETAIL, movie.movieOverview)
        detailMovieIntent.putExtra(DetailMovieActivity.EXTRA_IMAGE, movie.moviePoster)

        startActivity(detailMovieIntent)
    }

}
