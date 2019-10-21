package com.mambure.aad_team_65_animation_challenge.animatedLayoutChange1;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class CatRepository {
    private static final String TAG = CatRepository.class.getSimpleName();
    private static final String CAT_API_URL = "https://api.thecatapi.com/v1/images/search";
    private RequestQueue requestQueue;
    private MutableLiveData<String> catImageUrlLiveData;
    private JsonArrayRequest request = new JsonArrayRequest(
            Request.Method.GET,
            CAT_API_URL,
            null,
            this::parseJson,
            Throwable::printStackTrace
    );

    CatRepository(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        VolleyLog.DEBUG = true;
        catImageUrlLiveData = new MutableLiveData<>();
    }

    LiveData<String> getCatImage() {
        requestQueue.add(request);
        return catImageUrlLiveData;
    }

    private void parseJson(JSONArray jsonArray) {
        try {
            Log.d(TAG, "Response from sever: \n" + jsonArray.toString());
            String url = jsonArray.getJSONObject(0).getString("url");
            catImageUrlLiveData.postValue(url);

        } catch (JSONException e) {
            e.printStackTrace();
            getCatImage();
        }
    }
}
