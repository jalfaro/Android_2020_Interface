package com.julioalfaro.interfaceapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.julioalfaro.interfaceapp.R;
import com.julioalfaro.interfaceapp.data.OptionMenu;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<OptionMenu> {
    private Context context;
    private int layout;
    private List<OptionMenu> opciones;
    public MenuAdapter(@NonNull Context context, @NonNull List<OptionMenu> objects) {
        super(context, R.layout.option_layout, objects);
        this.context = context;
        this.layout = R.layout.option_layout;
        this.opciones = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(layout, null);
        }
        if (opciones.get(position) != null) {
            ImageView image = v.findViewById(R.id.option_img);
            TextView texto = v.findViewById(R.id.txt_option);
            image.setImageResource(opciones.get(position).getImage());
            texto.setText(opciones.get(position).getMessage());
        }
        return v;
    }
}
