package com.mysoft.recycler;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.mysoft.recycler.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding; // 4 usages
    private MoviesViewModel moviesViewModel; // 2 usages

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Inicializar el ViewModel con un proveedor
        moviesViewModel = new ViewModelProvider(  this).get(MoviesViewModel.class);
        // Configurar el RecyclerView
        binding.recycler.setLayoutManager(new GridLayoutManager(this,  2));
        // Observar los cambios en la lista de películas
        moviesViewModel.getMovies().observe(  this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                if (movies != null && !movies.isEmpty()) {
                    Log.d( "MoviesList",  "Mi lista: " + movies.size());
                    // Configurar el adaptador del RecyclerView
                    MoviesAdapter adapter = new MoviesAdapter(movies, new MovieClickedListener() {
                        @Override // 1 usage
                        public void onMovieClicked(Movie movie) {
                            Toast.makeText( MainActivity.this,  "Eliges: " + movie.getTitle(), Toast.LENGTH_LONG).show();
                        }
                    }, MainActivity.this);
                    binding.recycler.setAdapter(adapter);
                } else {
                    Log.d("MoviesList",  "Lista vacía");
                }
            }
        });
    }
}