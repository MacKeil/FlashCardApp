package edu.smccme.zack.flashcardapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zack on 2/9/16.
 */
public class DBManager {

    public static final String m_DB_NAME = "flashcard.db";
    public static final int m_DB_VERSION = 1;

    //Collection table fields
    public static final String m_COLLECTIONS_TABLE = "collection";
    public static final String m_COLLECTIONS_ID = "_id";
    public static final int m_COLLECTIONS_ID_COL = 0;

    public static final String m_COLLECTIONS_NAME = "collection_name";
    public static final int m_COLLECTIONS_NAME_COL = 1;

    //Cards table fields
    public static final String m_CARDS_TABLE = "card";
    public static final String m_CARDS_ID = "_id";
    public static final int m_CARDS_ID_COL = 0;

    public static final String m_CARDS_COLLECTIONS_ID = "collection_id";
    public static final int m_CARDS_COLLECTIONS_ID_COL = 1;

    public static final String m_CARDS_QUESTION = "question";
    public static final int m_CARDS_QUESTION_COL = 2;

    public static final String m_CARDS_ANSWER_ONE = "answer one location";
    public static final int m_CARDS_ANSWER_ONE_COL = 3;

    public static final String m_CARDS_ANSWER_TWO = "answer two location";
    public static final int m_CARDS_ANSWER_TWO_COL = 4;

    //CREATE and DROP TABLE statements
    public static final String CREATE_COLLECTIONS_TABLE = "CREATE TABLE " + m_COLLECTIONS_TABLE + " ("
            + m_COLLECTIONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            m_COLLECTIONS_NAME + " TEXT NOT NULL);";

    public static final String CREATE_CARDS_TABLE =
            "CREATE TABLE " + m_CARDS_TABLE + " (" +
                    m_CARDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    m_CARDS_COLLECTIONS_ID + " INTEGER NOT NULL, " +
                    m_CARDS_QUESTION + " TEXT NOT NULL, " +
                    m_CARDS_ANSWER_ONE + " TEXT NOT NULL, "+
                    m_CARDS_ANSWER_TWO + " TEXT NOT NULL);";

    public static final String DROP_COLLECTIONS_TABLE =
            "DROP TABLE IF EXISTS " + m_COLLECTIONS_TABLE;

    public static final String DROP_CARDS_TABLE =
            "DROP TABLE IF EXISTS " + m_CARDS_TABLE;

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_COLLECTIONS_TABLE);
            db.execSQL(CREATE_CARDS_TABLE);
            //TODO insert sample collection and add cards
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.d("Flash Cards", "Upgrading db from version " + oldVersion + " to " + newVersion);

            db.execSQL(DBManager.DROP_COLLECTIONS_TABLE);
            db.execSQL(DBManager.DROP_CARDS_TABLE);
            onCreate(db);
        }
    }



}
