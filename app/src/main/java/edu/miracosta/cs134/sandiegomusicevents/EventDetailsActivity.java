// Programmer: Sabas Sanchez
// Date: Feb 18, 2020
// Project: IC07 San Diego Music Events

package edu.miracosta.cs134.sandiegomusicevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    ImageView eventImageView;
    TextView eventArtistTextView;
    TextView eventDateDayTextView;
    TextView eventTimeTextView;
    TextView eventVenueTextView;
    TextView eventCityTextView;
    TextView eventStateTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Reference
        eventImageView = findViewById(R.id.eventImageView);
        eventArtistTextView = findViewById(R.id.eventArtistTextView);
        eventDateDayTextView = findViewById(R.id.eventDateDayTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventCityTextView = findViewById(R.id.eventCityTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);



        Intent currentIntent = getIntent();
        String artist = currentIntent.getStringExtra("Artist");
        String date = currentIntent.getStringExtra("Date");
        String city = currentIntent.getStringExtra("City");
        String day = currentIntent.getStringExtra("Day");
        String imageName = currentIntent.getStringExtra("ImageName");
        String state = currentIntent.getStringExtra("State");
        String time = currentIntent.getStringExtra("Time");
        String venue = currentIntent.getStringExtra("Venue");

        eventArtistTextView.setText(artist);
        eventDateDayTextView.setText(day + ", " + date);
        eventTimeTextView.setText(time);
        eventVenueTextView.setText(venue);
        eventCityTextView.setText(city);
        eventStateTextView.setText(state);

       // AssetManager am = mContext.getAssets();
        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageName);
            Drawable image = Drawable.createFromStream(stream, imageName);
            eventImageView.setImageDrawable(image);
        } catch (IOException e)
        {
            Log.e("SD Music Events", "Error loading " + imageName, e);
        }


    }
}
