package android.app.navjot.catchy;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GroceryDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "grocerylist.db";
    public static final int DB_VERSION = 1;

    public static final String ITEM_TABLE = "grocery";
    public static final String COLOUMN_NAME = "name";
    public static final String COLOUMN_NUMBER = "noitems";

    public static final String CREATE_TABLE_GROCERY = "CREATE TABLE " + ITEM_TABLE + "("
            + COLOUMN_NAME + " TEXT,"
            + COLOUMN_NUMBER + " TEXT);";

    public GroceryDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GROCERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE" + ITEM_TABLE);
        onCreate(db);
    }

    //storing grocery details in the database
    public void CreateGrocListItem(String dbname, String dbnumber) {
        SQLiteDatabase DataBase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLOUMN_NAME, dbname);
        values.put(COLOUMN_NUMBER, dbnumber);

        long id = DataBase.insert(ITEM_TABLE, null, values);
        DataBase.close();
    }


    public boolean getItem(String dbname, String dbnumber) {

        String selectQuery = "select * from " + ITEM_TABLE + " where " +
                COLOUMN_NAME + " = " + "'"+dbname+"'" + " and " + COLOUMN_NUMBER + " = " + "'"+dbnumber+"'";

        SQLiteDatabase DataBase = this.getReadableDatabase();
        Cursor cursor = DataBase.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        DataBase.close();

        return false;
    }
}

//This class has been done with the help of this tutorial
//http://techblogon.com/android-login-registration-screen-with-sqlite-database-example/