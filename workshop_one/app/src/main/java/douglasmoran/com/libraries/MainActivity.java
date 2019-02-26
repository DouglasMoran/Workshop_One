package douglasmoran.com.libraries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.MapView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import douglasmoran.com.libraries.Adapters.LibrariesAdapter;
import douglasmoran.com.libraries.Models.Libraries;

public class MainActivity extends AppCompatActivity{

    private String jsonUrl = "https://raw.githubusercontent.com/DouglasMoran/Workshop_One/master/data_libraries.json";
    private ArrayList<Libraries> librariesArrayList = new ArrayList<>();
    //ImageView imageMapsView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadContent();

    }

    private void loadContent() {
        RequestQueue resRequestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(jsonUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    parseContent(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR al obtener los recursos de la red",Toast.LENGTH_SHORT).show();
            }
        });

        resRequestQueue.add(jsonArrayRequest);
    }

    private void parseContent(JSONArray jsonArray) throws JSONException {

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject tmp = jsonArray.getJSONObject(i);
            Gson gson = new Gson();
            Libraries library = gson.fromJson(tmp.toString(),Libraries.class);
            librariesArrayList.add(library);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewItem);
        recyclerView.setAdapter(new LibrariesAdapter(this, librariesArrayList));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

}
