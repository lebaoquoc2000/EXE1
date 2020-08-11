package tdc.edu.vn.test.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "QLPHieuNhap", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table PhieuNhap(makho text, sophieu text, ngaylap text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
