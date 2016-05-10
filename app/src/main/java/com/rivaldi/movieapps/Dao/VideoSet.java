package com.rivaldi.movieapps.Dao;

import java.util.List;

/**
 * Created by Retrieving on 5/9/2016.
 */
public class VideoSet {
    final int id;
    final List<VideoDao> results;

    public VideoSet(int id, List<VideoDao> results) {
        this.id = id;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public List<VideoDao> getResult() {
        return results;
    }
}
