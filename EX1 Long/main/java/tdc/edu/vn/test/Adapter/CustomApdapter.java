package tdc.edu.vn.test.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.GiaoDien.MainDetailSV;
import tdc.edu.vn.test.Model.PhieuNhap;

public class CustomApdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<PhieuNhap> data;
    ArrayList<PhieuNhap> data_DS;

    public CustomApdapter(Context context, int resource, ArrayList<PhieuNhap> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<PhieuNhap>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgDetail;
        TextView txtMaKho;
        TextView txtSoPhieu;
        TextView txtNgayLap;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        Holder holder = null;
        if(view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            holder.txtMaKho = view.findViewById(R.id.txtMaKho);
            holder.txtSoPhieu = view.findViewById(R.id.txtSoPhieu);
            holder.txtNgayLap = view.findViewById(R.id.txtNgayLap);
            view.setTag(holder);
        }
        else

            holder=(Holder)view.getTag();

        final PhieuNhap phieuNhap = data.get(position);

        holder.txtMaKho.setText(phieuNhap.getMaKho());
        holder.txtSoPhieu.setText(phieuNhap.getSoPhieu());
        holder.txtNgayLap.setText(phieuNhap.getNgayLap());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainDetailSV.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma",phieuNhap.getMaKho());
                intent.putExtras(bundle);
                context.startActivity(intent);


            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length()==0){
            data.addAll(data_DS);
        }
        else {
            for (PhieuNhap model : data_DS){
                if (model.getMaKho().toLowerCase(Locale.getDefault())
                        .contains(charText) ){
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
