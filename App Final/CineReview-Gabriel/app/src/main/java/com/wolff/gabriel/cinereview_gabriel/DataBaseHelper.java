package com.wolff.gabriel.cinereview_gabriel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by professor on 22/07/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 4;

    String[] cinemas;

    // Database Name
    private static final String DATABASE_NAME = "reviews";


    String CRIAR_TABELA_CINEMAS = "CREATE TABLE cinemas(" +
            " _id INTEGER PRIMARY KEY, " +
            "cinema_nome  TEXT " +
            ");";

    String CRIAR_TABELA_REVIEWS = "CREATE TABLE reviews (" +
            "id INTEGER PRIMARY KEY, " +
            "nome_filme TEXT, " +
            "nota_avaliacao INTEGER, " +
            "texto_avaliacao TEXT, " +
            "cinema_id INTEGER, " +
            "FOREIGN KEY(cinema_id) REFERENCES cinemas(_id)" +
            ");";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        cinemas = context.getResources().getStringArray(R.array.cinemas);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CRIAR_TABELA_CINEMAS);
        db.execSQL(CRIAR_TABELA_REVIEWS);


        for (int i = 0; i < cinemas.length; i++){

            ContentValues values = new ContentValues();
            values.put("cinema_nome", cinemas[i]);
            db.insert("cinemas", null, values);


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS cinemas");
        db.execSQL("DROP TABLE IF EXISTS reviews" );

        // create new tables
        onCreate(db);
    }

    public ArrayList<String> listaTodosCinemas() {
        ArrayList<String> employeeList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "cinemas";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String cinema = cursor.getString(cursor.getColumnIndex("cinema_nome"));

                employeeList.add(cinema);
            } while (cursor.moveToNext());
        }

        return employeeList;
    }

}