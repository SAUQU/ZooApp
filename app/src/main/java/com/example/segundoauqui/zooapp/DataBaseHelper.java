package com.example.segundoauqui.zooapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by segundoauqui on 8/11/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase";
    //Animals Categories
    public static final String TABLE_NAME_A = "Categories";
    public static final String CONTACT_ID_A = "ID";
    public static final String CONTACT_CATEGORIES_A = "Categories";
    public static final String CONTACT_DESCRIPTION= "Description";

//Animals Categories

    public static final String TABLE_NAME = "Contacts";
    public static final String CONTACT_ID = "ID";
    public static final String CONTACT_NAME = "Name";
    public static final String CONTACT_CLASE = "Clase";
    public static final String CONTACT_ORDER = "Orde";
    public static final String CONTACT_RANGE = "Range";
//    public static final String CONTACT_PHOTO = "photo";

    private static final String TAG = "savedata";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
                CONTACT_ID + " Integer Primary Key Autoincrement, " +
                CONTACT_NAME + " TEXT, " +
                CONTACT_CLASE + " TEXT, " +
                CONTACT_ORDER + " TEXT, " +
                CONTACT_RANGE + " TEXT " +
//                CONTACT_PHOTO + " BLOB "+
                ")";
        Log.d(TAG, "onCreate: "+CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE);

        String CREATE_TABLE_A = "CREATE TABLE " + TABLE_NAME_A + " ( " +
                CONTACT_ID_A + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CONTACT_CATEGORIES_A + " TEXT, " +
                CONTACT_DESCRIPTION+ " TEXT " +
                ")";
        Log.d(TAG, "onCreate: "+CREATE_TABLE_A);
        sqLiteDatabase.execSQL(CREATE_TABLE_A);
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_CATEGORIES_A, "Mammals");
        contentValues.put(CONTACT_DESCRIPTION, "African Lion, Alpaca, Amur Tiger, American Beaver");
        Log.d(TAG, "onCreate: " + contentValues);
        sqLiteDatabase.insert(TABLE_NAME_A,null,contentValues);

        contentValues.put(CONTACT_CATEGORIES_A, "Birds");
        contentValues.put(CONTACT_DESCRIPTION, "African Penguin, Bald Eagle, African Spoonbill, American Avocet");
        Log.d(TAG, "onCreate: " + contentValues);
        sqLiteDatabase.insert(TABLE_NAME_A,null,contentValues);


        contentValues.put(CONTACT_CATEGORIES_A, "Reptiles");
        contentValues.put(CONTACT_DESCRIPTION, "African Rock Python, Black Tree Monitor, Green Tree Python, Wood Turtle");
        Log.d(TAG, "onCreate: " + contentValues);
        sqLiteDatabase.insert(TABLE_NAME_A,null,contentValues);

        contentValues.put(CONTACT_CATEGORIES_A, "Amphibious");
        contentValues.put(CONTACT_DESCRIPTION, "American Toad, Axolotl, Emperor Newt, Solomon Island Leaf Frog");
        Log.d(TAG, "onCreate: " + CONTACT_CATEGORIES_A);
        sqLiteDatabase.insert(TABLE_NAME_A,null,contentValues);
        


//        contentValues.put(CONTACT_ORDER, contact.getOrder());
//        contentValues.put(CONTACT_RANGE, contact.getRange());
//        database.insert(TABLE_NAME,null,contentValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_A);
        onCreate(sqLiteDatabase);



    }
//
//    public void saveNewContact(MyContacs contact){
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(CONTACT_NAME, contact.getName());
//        contentValues.put(CONTACT_CLASE, contact.getClase());
//        contentValues.put(CONTACT_ORDER, contact.getOrder());
//        contentValues.put(CONTACT_RANGE, contact.getRange());
//        database.insert(TABLE_NAME,null,contentValues);
//        Log.d(TAG, "saveNewContact: " + contact.getName() + " " + contact.getClase() + " " + contact.getOrder() + " "
//                + " " + contact.getRange();
//    }

    public ArrayList<MyContacs> getMyContacs(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "";
        String [] parame = null;
        if(id.equals("-1"))
            query = "SELECT * FROM " + TABLE_NAME;
        else
            query = "SELECT * FROM " + TABLE_NAME + " Where " + CONTACT_ID + " = ? " ;
        parame = new String[]{id};
        Log.d(TAG, "getContacs: " + query+ " " + id);
        //Cursor cursor = database.rawQuery(query, new String[]{CONTACT_NAME,"Jose"});
        Cursor cursor = database.rawQuery(query, parame);
        ArrayList<MyContacs> animals = new ArrayList();
        if(cursor.moveToFirst()){
            do{
                Log.d(TAG, "getContacts: Name:" + cursor.getString(0) + ", Origin: "+ cursor.getString(1));
                animals.add(new MyContacs(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            }while(cursor.moveToNext());
        }
        else{
            Log.d(TAG, "getContacts: empty");
        }
        return animals;
    }


    public ArrayList<Categories> getCategories(){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "";
        String [] parame1 = null;
        query = "SELECT * FROM " + TABLE_NAME_A;
        //Cursor cursor = database.rawQuery(query, new String[]{CONTACT_NAME,"Jose"});
        Cursor cursor = database.rawQuery(query, null);
        ArrayList<Categories> categoriesArrayList = new ArrayList();
        if(cursor.moveToFirst()){
            do{
               // Log.d(TAG, "getCategories: Name:" + cursor.getString(0) + ", Description: "+ cursor.getString(1));
                categoriesArrayList.add(new Categories(cursor.getInt(0),cursor.getString(1), cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        else{
            Log.d(TAG, "getCategories: empty");
        }
        return categoriesArrayList;
    }


}
