package com.avenger.salamindonesia;

//import static android.os.Looper.prepare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ProvinsiAdapter adapter;
    private String[] dataName;
    private String[] dataSuku;
    private String[] dataBahasa;
    private String[] dataIbukota;
    private String[] dataKepala;
    private String[] dataDescription;
    private String[] dataLat;
    private String[] dataLng;
    private TypedArray dataPhoto;
    private ArrayList<Provinsi> provinsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.lv_list);
        adapter = new ProvinsiAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, provinsis.get(i).getName(), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("nama",provinsis.get(i).getName());
                bundle.putInt("photo",provinsis.get(i).getPhoto());
                bundle.putString("desc",provinsis.get(i).getDescription());
                bundle.putString("suku",provinsis.get(i).getSuku());
                bundle.putString("kepala",provinsis.get(i).getKepala());
                bundle.putString("bahasa",provinsis.get(i).getBahasa());
                bundle.putString("ibukota",provinsis.get(i).getIbukota());
                bundle.putString("lat",provinsis.get(i).getLat());
                bundle.putString("lng",provinsis.get(i).getLng());
                Pindah(view, bundle);

            }
        });
    }
    public void Pindah(View view, Bundle prov){
        Intent go = new Intent(MainActivity.this, DetailActivity.class);
        go.putExtras(prov);
        startActivity(go);
    }
    private void prepare() {
        dataSuku =getResources().getStringArray(R.array.data_suku);
        dataBahasa=getResources().getStringArray(R.array.data_suku);
        dataKepala=getResources().getStringArray(R.array.data_kepala);
        dataIbukota=getResources().getStringArray(R.array.ibukota);
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataLat = getResources().getStringArray(R.array.latitude);
        dataLng = getResources().getStringArray(R.array.longitude);
    }

    private void addItem() {
        provinsis = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Provinsi provinsi = new Provinsi();
            provinsi.setPhoto(dataPhoto.getResourceId(i,-1));
            provinsi.setName(dataName[i]);
            provinsi.setIbukota(dataIbukota[i]);
            provinsi.setKepala(dataKepala[i]);
            provinsi.setSuku(dataSuku[i]);
            provinsi.setBahasa(dataBahasa[i]);
            provinsi.setDescription(dataDescription[i]);
            provinsi.setLat(dataLat[i]);
            provinsi.setLng(dataLng[i]);
            provinsis.add(provinsi);
        }
        adapter.setProvinsis(provinsis);
    }
}