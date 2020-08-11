package tdc.edu.vn.test.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.test.Model.PhieuNhap;

public class DBPhieuNhap {
    DBHelper dbHelper;

    public DBPhieuNhap(Context context)   {
        dbHelper= new DBHelper(context);
    }

    public void Them(PhieuNhap phieuNhap)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("makho",phieuNhap.getMaKho());
        values.put("sophieu",phieuNhap.getSoPhieu());
        values.put("ngaylap",phieuNhap.getNgayLap());
        db.insert("PhieuNhap", null, values);
    }

    public  void Sua(PhieuNhap phieuNhap)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("makho",phieuNhap.getMaKho());
        values.put("sophieu",phieuNhap.getSoPhieu());
        values.put("ngaylap",phieuNhap.getNgayLap());
        db.update("PhieuNhap",values,"makho ='"+phieuNhap.getMaKho() +"'",null);
    }


    public  void Xoa(PhieuNhap phieuNhap)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from PhieuNhap where makho= '"+phieuNhap.getMaKho()+"'";
        db.execSQL(sql);

    }

    public ArrayList<PhieuNhap> LayDL()
    {
        ArrayList<PhieuNhap> data = new ArrayList<>();
        String sql="select * from PhieuNhap";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setMaKho(cursor.getString(0));
                phieuNhap.setSoPhieu(cursor.getString(1));
                phieuNhap.setNgayLap(cursor.getString(2));
                data.add(phieuNhap);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}



        return  data;
    }

    public ArrayList<PhieuNhap> LayDL(String makho)
    {
        ArrayList<PhieuNhap> data = new ArrayList<>();
        String sql="select * from PhieuNhap where makho ='"+makho+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try{
            cursor.moveToFirst();
            do {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setMaKho(cursor.getString(0));
                phieuNhap.setSoPhieu(cursor.getString(1));
                phieuNhap.setNgayLap(cursor.getString(2));
                data.add(phieuNhap);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex )
        {}
        return  data;
    }
}
