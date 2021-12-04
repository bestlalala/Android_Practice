package smwu.mobileprogramming.part7_2_2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "Customerdatabase";
    private static final String DATABASE_NAME = "customer.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "customer";
    public static final String CUSTOMER_ID = "_id";
    public static final String CUSTOMER_NAME = "name";
        public static final String CUSTOMER_MOBILE = "mobile";
    public static final String CUSTOMER_EMAIL = "email";

    public static final String[] ALL_COLUMNS = {CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_MOBILE, CUSTOMER_EMAIL };

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CUSTOMER_NAME + " TEXT, " +
                    CUSTOMER_MOBILE + " TEXT, " +
                    CUSTOMER_EMAIL + " TEXT " +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

}
