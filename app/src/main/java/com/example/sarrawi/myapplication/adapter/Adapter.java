package com.example.sarrawi.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarrawi.myapplication.R;
import com.example.sarrawi.myapplication.database.DatabaseHelper;
import com.example.sarrawi.myapplication.model.Product;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProductList;
    LayoutInflater inflater;

    public Adapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductList.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Adapter.ViewHolder holder;

        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, null);
            holder = new Adapter.ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.title);
            holder.imgFav = (ImageView) convertView.findViewById(R.id.img_fav1);


            convertView.setTag(holder);


        } else {

            holder = (Adapter.ViewHolder) convertView.getTag();
        }

        final Product m = mProductList.get(position);
        final DatabaseHelper databaseHelper = new DatabaseHelper(mContext);
        holder.tvName.setText(m.getName());
//holder.tvMsg.setTextColor(Color.BLACK);
        if (m.getFav() == 0) {
//            holder.fav.setBackgroundColor(Color.rgb(76, 255, 0));
            holder.imgFav.setImageResource(R.drawable.ic_launcher_background);
        } else {
//            holder.fav.setBackgroundColor(Color.rgb(255, 0, 0));
            holder.imgFav.setImageResource(R.drawable.ic_launcher_background);
        }
        holder.imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (m.getFav() == 1) {
//                    holder.fav.setBackgroundColor(Color.rgb(76, 255, 0));
                    holder.imgFav.setImageResource(R.drawable.ic_launcher_background);
                    DatabaseHelper.getInstance(mContext).fav(m.getId(),m.getName(),m.getName_filter(),0);
                    mProductList.get(position).setFav(0);
                    m.setFav(0);
                    Toast.makeText(mContext, "تم الإزالة من المفضلة", Toast.LENGTH_LONG).show();
                } else {
//                    holder.fav.setBackgroundColor(Color.rgb(255, 0, 0));
                    holder.imgFav.setImageResource(R.drawable.ic_launcher_background);
                    DatabaseHelper.getInstance(mContext).fav(m.getId(),m.getName(),m.getName_filter(),1);
                    mProductList.get(position).setFav(1);
                    m.setFav(1);
                    Toast.makeText(mContext, "تم الإضافة إلى المفضلة", Toast.LENGTH_LONG).show();
                }



            }
        });

        return convertView;
    }





    private class ViewHolder {
        TextView tvName;
        ImageView imgFav;
    }
}