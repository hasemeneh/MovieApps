package com.rivaldi.movieapps;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.androidquery.AQuery;
import com.google.gson.Gson;
import com.rivaldi.movieapps.Dao.MovieDao;
import com.rivaldi.movieapps.Dao.VideoDao;
import com.rivaldi.movieapps.Dao.VideoSet;
import com.rivaldi.movieapps.Utils.Constants;
import com.rivaldi.movieapps.Utils.Util;

import java.util.List;

import javax.xml.datatype.Duration;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class DetailActivity extends AppCompatActivity {
    public static void startThisActivity(Activity activity,MovieDao dao){
        final Intent intent = new Intent(activity,DetailActivity.class);
        final Gson gson= new Gson();
        intent.putExtra(Constants.MOVIES_DATA,gson.toJson(dao));
        activity.startActivity(intent);
    }
    private MovieDao dao;
    private TextView txtDuration;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        final Gson gson= new Gson();
        final Bundle bundle = getIntent().getExtras();

        dao = gson.fromJson(bundle.getString(Constants.MOVIES_DATA),MovieDao.class);
        getSupportActionBar().setTitle(dao.getOriginal_title());
        ((TextView) findViewById(R.id.textViewTahun)).setText(dao.getRelease_date().substring(0, 4));
        ((TextView) findViewById(R.id.textViewOverView)).setText(dao.getOverview());
        ((TextView) findViewById(R.id.textViewRating)).setText(dao.getVote_average() + "/10");
        txtDuration = ((TextView) findViewById(R.id.textViewDuration));
        txtDuration.setVisibility(View.GONE);

        final LinearLayout layoutTrailer = (LinearLayout) findViewById(R.id.trailer_layout);
        final AQuery aQuery = new AQuery(this);
        aQuery.id(R.id.imageViewPoster).image(Constants.BasePosterURL+dao.getPoster_path(),false,true);
        final String link = Constants.genVideo(dao.getId());
        Util.sendGetWebservice(this, link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                final VideoSet dataSet = gson.fromJson(response,VideoSet.class);
                final List<VideoDao> daos = dataSet.getResult();
                int size = dataSet.getResult().size();
                View v;
                for (int i = 0 ; i <size ;i++){
                    v = DetailActivity.this.getLayoutInflater().inflate(R.layout.layout_trailer,null);
                    final int x = i;
                    ((TextView) v.findViewById(R.id.txtJudulTrailer)).setText(""+daos.get(x).getName());
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            watchYoutubeVideo(daos.get(x).getKey());
                        }
                    });
                    layoutTrailer.addView(v, i);
                }
//                Toast.makeText(DetailActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
//        ((ImageView) findViewById(R.id.textViewDuration)).setText(dao.getRuntime()+"min");
        Util.sendGetWebservice(this, Constants.genUrlDetail(dao.getId()), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dao = gson.fromJson(response,MovieDao.class);
                txtDuration.setVisibility(View.VISIBLE);
                txtDuration.setText(dao.getRuntime()+" min.");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
    public void watchYoutubeVideo(String id){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
            startActivity(intent);

        } catch (ActivityNotFoundException ex) {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=" + id));
            startActivity(intent);
        }
    }
}
