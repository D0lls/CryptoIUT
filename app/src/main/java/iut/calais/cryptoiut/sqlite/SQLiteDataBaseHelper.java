package iut.calais.cryptoiut.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "crypto.db";
    public static final String TABLE_NAME = "crypto_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOM";
    public static final String COL_3 = "VALEUR";

    public  SQLiteDataBaseHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY, NOM TEXT, VALEUR INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String nom, String valeur){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,nom);
        contentValues.put(COL_3,valeur);
        long result=((SQLiteDatabase) db).insert(TABLE_NAME,null, contentValues);
        if(result== -1)
            return false;
        else
            return true;

    }


}
