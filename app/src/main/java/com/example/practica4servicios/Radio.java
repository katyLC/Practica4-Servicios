package com.example.practica4servicios;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Radio implements Parcelable {
    private int id;
    private String url;
    private String nombre;
    private Drawable imagen;

    public Radio() {
    }

    public Radio(int id, String url, String nombre, Drawable imagen) {
        this.id = id;
        this.url = url;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    protected Radio(Parcel in) {
        id = in.readInt();
        url = in.readString();
        nombre = in.readString();
    }

    public static final Creator<Radio> CREATOR = new Creator<Radio>() {
        @Override
        public Radio createFromParcel(Parcel in) {
            return new Radio(in);
        }

        @Override
        public Radio[] newArray(int size) {
            return new Radio[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeString(nombre);
    }
}
