package com.rivaldi.movieapps.Utils;

import android.app.Activity;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Retrieving on 5/8/2016.
 */
public class Util {
    private static NetworkServiceHandler handler;

    public static void init(Context ctx) {
        handler = NetworkServiceHandler.getInstance(ctx);
    }

    public static void sendGetWebservice(Activity activity, String url, Response.Listener responseListener, Response.ErrorListener errorListener) {
// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
// Add the request to the RequestQueue.
        handler.addToRequestQueue(stringRequest);
    }

    public static void sendPostWebservice(Activity activity, String url, Response.Listener responseListener, Response.ErrorListener errorListener, final Map<String, String> params) {
// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, responseListener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> paramh = new HashMap<String, String>();
                paramh.put("Content-Type", "application/x-www-form-urlencoded");
                return paramh;
            }
        };
// Add the request to the RequestQueue.
        handler.addToRequestQueue(stringRequest);
    }
}
