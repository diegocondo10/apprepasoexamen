package com.example.app_repaso_examen.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ResourceManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "clientes.db";

    ResourceManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE \"Cliente\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"identificacion\"\tTEXT UNIQUE,\n" +
                "\t\"nombres\"\tTEXT ,\n" +
                "\t\"apellidos\"\tTEXT ,\n" +
                "\t\"correo\"\tTEXT ,\n" +
                "\t\"sexo\"\tTEXT ,\n" +
                "\t\"estado_civil\"\tTEXT \n" +
                ");";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Cliente";

        db.execSQL(sql);

        onCreate(db);
    }
}
