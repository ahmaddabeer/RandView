package com.example.randomapitest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ImageView helo;
    TextView helo2;
    TextView helo4;
    TextView detail;
    Button refreshButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        helo = findViewById(R.id.imageView);
        helo2 = findViewById(R.id.name);
        helo4 = findViewById(R.id.textView3);
        detail = findViewById(R.id.textView5);
        refreshButton = findViewById(R.id.refresh);

        // Fetch data initially
        fetchData();

        // Set click listener to refresh button
        refreshButton.setOnClickListener(v -> fetchData());
    }

    private void fetchData() {
        String url = "https://randomuser.me/api/";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray results = response.getJSONArray("results");
                        JSONObject user = results.getJSONObject(0);

                        // Circular Image using Glide
                        String imageUrl = user.getJSONObject("picture").getString("large");
                        Glide.with(MainActivity.this)
                                .load(imageUrl)
                                .circleCrop() // circular crop
                                .placeholder(R.drawable.placeholder) // optional placeholder
                                .into(helo);

                        // Name
                        JSONObject nameObject = user.getJSONObject("name");
                        String firstName = nameObject.getString("first");
                        String lastName = nameObject.getString("last");
                        helo2.setText("Name is : " + firstName + " " + lastName);

                        // Address
                        JSONObject locationObject = user.getJSONObject("location");
                        JSONObject streetObject = locationObject.getJSONObject("street");
                        int flatnumber = streetObject.getInt("number");
                        String streetName = streetObject.getString("name");
                        String city = locationObject.getString("city");
                        String state = locationObject.getString("state");

                        detail.setText("Flat Number: " + flatnumber + ", Street: " + streetName + "\nCity: " + city);
                        helo4.setText("State is: " + state);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );

        queue.add(jsonObjectRequest);
    }
}
