package com.example.listview2top10;

public class MovieDataProvider {
    private int Movie_poster;
    private String Movie_ratings;
    private String Movie_title;

    public MovieDataProvider(int movie_poster, String movie_rating, String movie_title) {
        Movie_poster = movie_poster;
        Movie_ratings = movie_rating;
        Movie_title = movie_title;
    }

    public int getMovie_poster() {
        return Movie_poster;
    }

    public void setMovie_poster(int movie_poster) {
        Movie_poster = movie_poster;
    }

    public String getMovie_ratings() {
        return Movie_ratings;
    }

    public void setMovie_ratings(String movie_ratings) {
        Movie_ratings = movie_ratings;
    }

    public String getMovie_title() {
        return Movie_title;
    }

    public void setMovie_title(String movie_title) {
        Movie_title = movie_title;
    }
}
