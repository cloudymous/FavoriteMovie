package com.example.favoritemovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.favoritemovie.model.Movie
import com.example.favoritemovie.R

class ListMovieAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<ListMovieAdapter.MovieViewHolder>() {

    var onItemClickListener: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemRow = LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
        return MovieViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvTitle.text = listMovie[position].movieName
        holder.tvRating.text = listMovie[position].movieRating

        Glide.with(holder.itemView.context)
            .load(listMovie[position].moviePoster)
            .apply(RequestOptions().override(150, 300))
            .into(holder.imageBanner)

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(listMovie[holder.adapterPosition])
        }

    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        var tvRating: TextView = itemView.findViewById(R.id.textViewRating)
        var imageBanner: ImageView = itemView.findViewById(R.id.imageBanner)

    }

}