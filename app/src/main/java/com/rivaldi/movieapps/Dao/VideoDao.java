package com.rivaldi.movieapps.Dao;

/**
 * Created by Retrieving on 5/9/2016.
 */
public class VideoDao {
    final String id,
            iso_639_1,
            iso_3166_1,
            key,
            name,
            site,
            type;
    final int size;

    public VideoDao(String id, String iso_639_1, String iso_3166_1, String key, String name, String site, String type, int size) {
        this.id = id;
        this.iso_639_1 = iso_639_1;
        this.iso_3166_1 = iso_3166_1;
        this.key = key;
        this.name = name;
        this.site = site;
        this.type = type;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public String getType() {
        return type;
    }

}
