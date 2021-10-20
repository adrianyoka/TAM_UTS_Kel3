package com.avenger.salamindonesia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProvinsiAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Provinsi> provinsis = new ArrayList<>();

    //setter hasil generate
    public void setProvinsis(ArrayList<Provinsi> provinsis) {
        this.provinsis = provinsis;
    }

    //constructor hasil generate
    public ProvinsiAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return provinsis.size();
    }

    @Override
    public Object getItem(int i) {
        return provinsis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_prov,viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Provinsi provinsi = (Provinsi) getItem(i);
        viewHolder.bind(provinsi);
        return itemView;
    }

    public class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private TextView txtSuku;
        private TextView txtKepala;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Provinsi provinsi) {
            txtName.setText(provinsi.getName());
            txtDescription.setText(provinsi.getDescription());
            imgPhoto.setImageResource(provinsi.getPhoto());
        }
    }
}
