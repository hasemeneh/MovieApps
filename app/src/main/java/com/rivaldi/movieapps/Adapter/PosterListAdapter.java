package com.rivaldi.movieapps.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.rivaldi.movieapps.Dao.MovieDao;
import com.rivaldi.movieapps.R;
import com.rivaldi.movieapps.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class PosterListAdapter extends BaseAdapter {
    final List<MovieDao> data = new ArrayList<MovieDao>();
    final Activity activity;
    final AQuery aQuery ;
    public PosterListAdapter(final Activity activity,final List<MovieDao> data){
        this.data.addAll(data);
        aQuery = new AQuery(activity);
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position+1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.item_list,null);
        }
        aQuery.id(convertView).image(Constants.BasePosterURL+data.get(position).getPoster_path());
        return convertView;
    }
}
