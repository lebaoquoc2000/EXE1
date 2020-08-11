package tdc.edu.vn.test.GiaoDien;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.Adapter.CustomApdapter;
import tdc.edu.vn.test.DataBase.DBPhieuNhap;
import tdc.edu.vn.test.Model.PhieuNhap;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnXoa, btnSua, btnThoat;
    EditText txtMaKho, txtSoPhieu, txtNgayLap;
    ListView lvDanhSachSV;

    CustomApdapter apdapter;
    ArrayList<PhieuNhap> dataPN = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();


    }

    private void setEvent() {
        HienThiDL();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
                HienThiDL();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuaDL();
                HienThiDL();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDL();
                HienThiDL();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setMessage("Bạn có muốn thoát?");

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });
    }

    private void HienThiDL() {
        DBPhieuNhap dbPhieuNhap = new DBPhieuNhap(this);
        dataPN = dbPhieuNhap.LayDL();
        apdapter = new CustomApdapter(MainActivity.this, R.layout.listview_item, dataPN);
        lvDanhSachSV.setAdapter(apdapter);
    }

    private void ThemDL() {
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setMaKho(txtMaKho.getText().toString());
        phieuNhap.setSoPhieu(txtSoPhieu.getText().toString());
        phieuNhap.setNgayLap(txtNgayLap.getText().toString());

        DBPhieuNhap dbPhieuNhap = new DBPhieuNhap(this);
        dbPhieuNhap.Them(phieuNhap);
    }

    private void SuaDL() {
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setMaKho(txtMaKho.getText().toString());
        phieuNhap.setSoPhieu(txtSoPhieu.getText().toString());
        phieuNhap.setNgayLap(txtNgayLap.getText().toString());

        DBPhieuNhap dbPhieuNhap = new DBPhieuNhap(this);
        dbPhieuNhap.Sua(phieuNhap);
    }

    private void XoaDL() {
        PhieuNhap phieuNhap = new PhieuNhap();
        phieuNhap.setMaKho(txtMaKho.getText().toString());
        phieuNhap.setSoPhieu(txtSoPhieu.getText().toString());
        phieuNhap.setNgayLap(txtNgayLap.getText().toString());

        DBPhieuNhap dbPhieuNhap = new DBPhieuNhap(this);
        dbPhieuNhap.Xoa(phieuNhap);
    }

    private void setControl() {
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        btnXoa = findViewById(R.id.btnXoa);
        txtMaKho = findViewById(R.id.txtMa);
        txtSoPhieu = findViewById(R.id.txtSoPhieu);
        txtNgayLap = findViewById(R.id.txtNgayLap);
        lvDanhSachSV = findViewById(R.id.lvDanhSach);
    }


}

