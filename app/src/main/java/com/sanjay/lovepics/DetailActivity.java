package com.sanjay.lovepics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jsibbold.zoomage.ZoomageView;

import java.io.File;

/**
 * Created by User on s1/9/2018.
 */

public class DetailActivity extends AppCompatActivity {
    TextView NumberOfSong, NameOfsong;
    ZoomageView imageView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ZoomageView ) findViewById(R.id.thumbnail_image_header);
//        NameOfsong = (TextView) findViewById(R.id.name);

//        NumberOfSong = (TextView) findViewById(R.id.numberofsongsdata);

//        String songname = getIntent().getExtras().getString("name");
//        String numofsongs = getIntent().getExtras().getString("numOfSongs");
        String thumbnail = getIntent().getExtras().getString("thumbnail");
        Log.d("", "onCreate: "+thumbnail);
//        NameOfsong.setText(songname);
//        NumberOfSong.setText(numofsongs);
        Glide.with(this)
                .load(thumbnail)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.load))
                .into(imageView);

        getSupportActionBar().setTitle("");


    }
    private void galleryAddPic(String imagePath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
    }
}

