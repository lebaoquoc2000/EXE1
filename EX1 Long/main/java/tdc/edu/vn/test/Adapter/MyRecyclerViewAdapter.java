package tdc.edu.vn.test.Adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import tdc.edu.vn.myapplication.R;
import tdc.edu.vn.test.Model.CardViewModel;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
    private int layoutID;
    private Vector<CardViewModel> data;

    public MyRecyclerViewAdapter(int layoutID, Vector<CardViewModel> data) {
        this.layoutID = layoutID;
        this.data = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.imageText);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        CardView viewItem = (CardView) inflater.inflate(layoutID, viewGroup, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        CardViewModel cardViewModel = data.get(i);
        Drawable drawable = viewHolder.imageView.getResources().getDrawable(cardViewModel.getImageResourceId());
        viewHolder.imageView.setImageDrawable(drawable);
        viewHolder.textView.setText(cardViewModel.getCardName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
