package itp341.bhatia.shamit.a9.Model;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Shamit on 10/31/17.
 */

public class MovieSingleton {

    private ArrayList<Movie> movieList;

    // reference to itself (the movie singleton)
    private static MovieSingleton mSingleton;

    // private singleton constructor
    private MovieSingleton(){
        movieList = new ArrayList<>();
    }

    public static MovieSingleton get(){
        // if singleton doesn't exist yet, make one and return it
        // if it does already, just return original
        if (mSingleton == null){
            mSingleton = new MovieSingleton();
        }
        return mSingleton;
    }

    // get the number of movie objects (an int)
    public int getNumberMovies(){
        return movieList.size();
    }

    // get all the movies
    public ArrayList<Movie> getMovies(){
        return movieList;
    }

    // get movie object at specific index
    public Movie getMovieAtIndex(int index){
        // checking if not out of bounds first
        if (index >= 0 && index <= movieList.size()){
            return movieList.get(index);
        }
        else{
            return null;
        }
    }

    // add movie object
    public void addMovieObject(Movie movie){
        movieList.add(movie);
    }

    // add comment to a specific movie object given comment and index
    public void addCommentToMovie(String comment, int i){
        Movie currMovie = getMovieAtIndex(i);
        currMovie.getMyList().add(comment);
    }
}
