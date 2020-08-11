package tdc.edu.vn.test.GiaoDien;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.Adapter.CustomApdapter;
import tdc.edu.vn.test.DataBase.DBPhieuNhap;
import tdc.edu.vn.test.Model.PhieuNhap;

public class MainGridView extends AppCompatActivity {
    GridView gvDanhSach;
    ArrayList<PhieuNhap> dataPN = new ArrayList<>();
    CustomApdapter apdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }

    private void setEvent() {
        HienThiDL();
    }

    private void HienThiDL() {
        DBPhieuNhap dbPhieuNhap = new DBPhieuNhap(this);
        dataPN = dbPhieuNhap.LayDL();
        apdapter = new CustomApdapter(MainGridView.this, R.layout.listview_item, dataPN);
        gvDanhSach.setAdapter(apdapter);
    }

    private void setControl() {

        gvDanhSach =  findViewById(R.id.gvDanhSach);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
