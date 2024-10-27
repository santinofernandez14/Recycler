package com.mysoft.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.mysoft.recycler.databinding.ItemMovieBinding;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private MovieClickedListener movieClickedListener;
    private Context context;

    public MoviesAdapter(List<Movie> movies, MovieClickedListener movieClickedListener, Context context) {
        this.movies = movies;
        this.movieClickedListener = movieClickedListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // Clase interna ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Método para enlazar datos con las vistas
        public void bind(Movie movie) {
            Log.d("MoviesAdapter", "Título: " + movie.getTitle());
            Log.d("MoviesAdapter", "URL de la imagen: " + movie.getCover());
            binding.movieTitle.setText(movie.getTitle());
            Glide.with(context)
                    .load(movie.getCover())
                    .into(binding.movieCover);
            binding.movieRating.setRating(movie.getEstrellas());
            binding.movieCover.setOnClickListener(v -> movieClickedListener.onMovieClicked(movie));
        }

    }
}