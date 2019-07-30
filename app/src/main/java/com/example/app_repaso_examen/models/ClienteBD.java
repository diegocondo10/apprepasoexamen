package com.example.app_repaso_examen.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ClienteBD extends ResourceManager {

    ClienteBD(Context context) {
        super(context);
    }


    public boolean insert(ClienteMD cliente) {

        ContentValues values = new ContentValues();

        values.put("identificacion", cliente.getIdentificacion());
        values.put("nombres", cliente.getNombres());
        values.put("apellidos", cliente.getApellidos());
        values.put("correo", cliente.getCorreo());
        values.put("sexo", cliente.getSexo());
        values.put("estado_civil", cliente.getEstadoCivil());

        SQLiteDatabase db = this.getWritableDatabase();

        return db.insert("Cliente", null, values) > 0;
    }


}
