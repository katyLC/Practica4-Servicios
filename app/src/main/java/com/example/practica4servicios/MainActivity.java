package com.example.practica4servicios;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Radio> radios;
    AdapterRadio adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radios = new ArrayList<>();

        lv = findViewById(R.id.listView);

        adapter = new AdapterRadio(this, obtenerRadios());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Radio radio = radios.get(position);
                Intent intent = new Intent(getApplicationContext(), RadioActivity.class);
                intent.putExtra("radio", radio);

//                Bitmap bitmap = ((BitmapDrawable)radio.getImagen()).getBitmap();
//                intent.putExtra("imagen", bitmap);

                startActivity(intent);

            }
        });
    }

    public ArrayList<Radio> obtenerRadios() {
        radios.add(new Radio(1, "http://listen.radionomy.com/radio-mozart", "Radio Mozart",
            getResources().getDrawable(R.drawable.radio_mozart)));
        radios.add(new Radio(2, "http://listen.radionomy.com/iloveheavymetal", "I Love Heavy Metal", getResources().getDrawable(R.drawable.love_metal)));
        radios.add(new Radio(3, "http://listen.radionomy.com/radio-retro-rock--pop", "Radio Retro Rock & Pop", getResources().getDrawable(R.drawable.radio_retro)));
        radios.add(new Radio(4, "http://listen.radionomy.com/infusionradiotrujillo", "Infusión Radio Trujillo",
            getResources().getDrawable(R.drawable.infusion_radio)));
        return radios;
    }
}
