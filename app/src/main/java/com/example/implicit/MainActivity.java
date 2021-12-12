package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickopenWebPageButton(View view) {
        String stringurl = "https://www.google.com/";
        Webpage(stringurl);


    }

    public void onClickopenAddressButton(View view) {
        String addressstring = "1600 AmphiTheatre Parkway,CA";
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo")
                .path("0,0")
                .appendQueryParameter("q", addressstring);
        Uri addressUri = builder.build();
        showMap(addressUri);


    }


    public void onClicksharetextButton(View view) {
         String str="i am shareing something";
         shareText(str);

    }

    public void Createyourown(View view) {


    }

    private void Webpage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }
    }

    private void showMap(Uri geolocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW, geolocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);


        }


    }
    private void shareText(String sharetotext){
        String mimetype="text/plain";
        String title="Learning how to share";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimetype)
                .setChooserTitle(title)
                .setText("sharetotext")
                .startChooser();



    }
}