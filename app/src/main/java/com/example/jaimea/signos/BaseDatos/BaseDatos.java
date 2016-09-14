package com.example.jaimea.signos.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by jaimea on 9/13/16.
 */
public class BaseDatos extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Preguntas.db";

    public static abstract class PregTabla implements BaseColumns {
        public static final String TABLE_NAME = "paciente";
        public static final String COLUMNA_ID = "ID";
        public static final String COLUMNA_NOMBRE = "nombre";
        public static final String COLUMNA_APELLIDO = "apellido";
        public static final String COLUMNA_RH = "rh";
        public static final String COLUMNA_TELEFONO = "telefono";
        public static final String COLUMNA_CORREO = "correo";
        public static final String COLUMNA_DIAGNOSTICO = "diagnostico";

        public static final String TEXT_TYPE = " TEXT";
        public static final String COMMA_SEP = ",";
        public static final String CREAR_TABLA =
                "CREATE TABLE " + PregTabla.TABLE_NAME + " ( " +
                        PregTabla.COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        PregTabla.COLUMNA_NOMBRE + TEXT_TYPE + COMMA_SEP +
                        PregTabla.COLUMNA_APELLIDO + TEXT_TYPE + COMMA_SEP +
                        PregTabla.COLUMNA_RH + TEXT_TYPE + COMMA_SEP +
                        PregTabla.COLUMNA_TELEFONO + TEXT_TYPE + COMMA_SEP +
                        PregTabla.COLUMNA_CORREO + TEXT_TYPE + COMMA_SEP +
                        PregTabla.COLUMNA_DIAGNOSTICO + TEXT_TYPE +" )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + PregTabla.TABLE_NAME;
    }

    public BaseDatos(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PregTabla.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(PregTabla.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
