package com.avenger.salamindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private String lng;
    private String lat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);
        TextView nama = (TextView) findViewById(R.id.txt_name);
        TextView desc = (TextView) findViewById(R.id.txt_description);
        ImageView img = (ImageView) findViewById(R.id.img_photo);
        TextView suku = (TextView) findViewById(R.id.txt_suku);
        TextView kepala = (TextView) findViewById(R.id.txt_kepala);
        TextView ibukota = (TextView) findViewById(R.id.txt_ibukota);
        TextView bahasa = (TextView) findViewById(R.id.txt_bahasa);
        Bundle bundle = getIntent().getExtras();
        nama.setText(bundle.getString("nama"));
        desc.setText(bundle.getString("desc"));
        img.setImageResource(bundle.getInt("photo"));
        suku.setText(bundle.getString("suku"));
        kepala.setText(bundle.getString("kepala"));
        ibukota.setText(bundle.getString("ibukota"));
        bahasa.setText(bundle.getString("bahasa"));
        this.lat = bundle.getString("lat");
        this.lng = bundle.getString("lng");
    }

    public void Maps(View view) {
        Intent goMaps = new Intent(DetailActivity.this,MapsActivity.class);
        Bundle data = new Bundle();
        data.putString("lat",lat);
        data.putString("lng",lng);
        goMaps.putExtras(data);
        startActivity(goMaps);
    }
}