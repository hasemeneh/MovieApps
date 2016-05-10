package com.rivaldi.movieapps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.rivaldi.movieapps.Adapter.PosterListAdapter;
import com.rivaldi.movieapps.Dao.MovieDao;
import com.rivaldi.movieapps.Dao.MovieDaoSet;
import com.rivaldi.movieapps.Utils.Constants;
import com.rivaldi.movieapps.Utils.Util;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    final LinkedList<MovieDao> data = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.init(this);

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        Util.sendGetWebservice(this, Constants.TOP_RATED, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final Gson gson = new Gson();
                final MovieDaoSet daoSet = gson.fromJson(response, MovieDaoSet.class);
                final PosterListAdapter adapter = new PosterListAdapter(MainActivity.this, daoSet.getResults());
                gridView.setAdapter(adapter);
                data.addAll(daoSet.getResults());
                gridView.setOnItemClickListener(MainActivity.this);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(findViewById(R.id.fragment_container)!=null){

        }else{

            DetailActivity.startThisActivity(this,data.get(position));
        }
    }
}
