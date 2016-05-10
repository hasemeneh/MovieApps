package com.rivaldi.movieapps.Dao;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class MovieDao {
    final String poster_path,overview,release_date,original_title;
    final float vote_average;
    final boolean video;
    final int runtime,id;

    public MovieDao(String poster_path, String overview, String release_date, String original_title, float vote_average, boolean video, int runtime, int id) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.original_title = original_title;
        this.vote_average = vote_average;
        this.video = video;
        this.runtime = runtime;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRuntime() {
        return runtime;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }
}
