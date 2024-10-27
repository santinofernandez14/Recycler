package com.mysoft.recycler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MoviesViewModel extends ViewModel {  // 4 usages
    private MutableLiveData<List<Movie>> moviesList;  // 3 usages
    public MoviesViewModel() {
        moviesList = new MutableLiveData<>();
        loadMovies();
    }

    private void loadMovies() {  // 1 usage
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Vacaciones en Familia",  "https://via.assets.so/movie.png?id=1&q=95&w=360&h=360&fit=fill",  3.0f));
        movies.add(new Movie("He's All That",  "https://via.assets.so/movie.png?id=2&q=95&w=360&h=360&fit=fill",  4.0f));
        movies.add(new Movie("Venom",  "https://via.assets.so/movie.png?id=3&q=95&w=360&h=360&fit=fill",  2.5f));
        movies.add(new Movie("Encanto",  "https://via.assets.so/movie.png?id=4&q=95&w=360&h=360&fit=fill",  4.0f));
        movies.add(new Movie("Los Locos Adams",  "https://via.assets.so/movie.png?id=5&q=95&w=360&h=360&fit=fill",  4.0f));
        movies.add(new Movie("LAMB",  "https://via.assets.so/movie.png?id=6&q=95&w=360&h=360&fit=fill",  2.0f));
        moviesList.setValue(movies);
    }

    public LiveData<List<Movie>> getMovies() {
        return moviesList;
    }
    }