package iut.calais.cryptoiut.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Permet la création et la mise à jour du schéma de la base de données SQLite de l'appli.
 */
public class SQLiteDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NOM = "blackjack.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_RESULTATS = "t_resultats_res";
    public static final String KEY_NAME = "";


    /**
     * Requete de création de la table des résultats.
     */
    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_RESULTATS + " ("
            + KEY_NAME + " STRING PRIMARY KEY);";

    /**
     * Constructeur
     *
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public SQLiteDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    /**
     * Creation de la base
     *
     * @param db
     */
    @Override
    public void onCreate(final SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    /**
     * Upgrade de la base
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_RESULTATS + ";");
        onCreate(db);
    }
}
