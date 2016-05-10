package com.rivaldi.movieapps.Utils;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class Constants {
    private static String API_KEY = "api_key=c521053231c2f6129a0ba5f93f01cd2d";
    private static String BaseURL = "https://api.themoviedb.org/3";
    public static String BasePosterURL = "http://image.tmdb.org/t/p/w185/";
    private static String MOVIE = BaseURL + "/movie/";
    public static String POPULAR = BaseURL + "/movie/popular?"+API_KEY;
    public static String TOP_RATED = BaseURL + "/movie/top_rated?"+API_KEY;
    public static String MOVIES_DATA = "MOVIES_DATA";
    public static String genVideo(int id){
        return MOVIE +id+"/videos?api_key=c521053231c2f6129a0ba5f93f01cd2d";
    }
    public static String genUrlDetail(int id){
        return MOVIE +id+"?api_key=c521053231c2f6129a0ba5f93f01cd2d";
    }

}
