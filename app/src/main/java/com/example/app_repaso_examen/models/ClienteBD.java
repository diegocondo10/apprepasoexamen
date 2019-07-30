package com.example.app_repaso_examen.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteBD extends ResourceManager {

    public ClienteBD(Context context) {
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


    public List<ClienteMD> selectAll() {
        List<ClienteMD> lista = new ArrayList<>();

        Cursor res = this.getReadableDatabase().rawQuery("SELECT identificacion, nombres, apellidos From Cliente", null);

        res.moveToFirst();

        while (!res.isAfterLast()) {

            ClienteMD cliente = new ClienteMD();

            cliente.setIdentificacion(res.getString(res.getColumnIndex("identificacion")));
            cliente.setNombres(res.getString(res.getColumnIndex("nombres")));
            cliente.setApellidos(res.getString(res.getColumnIndex("apellidos")));

            lista.add(cliente);

            res.moveToNext();

        }


        return lista;
    }


}
