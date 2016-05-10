package com.rivaldi.movieapps.Dao;

import java.util.List;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class MovieDaoSet {
    final int page;
    final List<MovieDao> results;

    public MovieDaoSet(int page, List<MovieDao> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public List<MovieDao> getResults() {
        return results;
    }
}
