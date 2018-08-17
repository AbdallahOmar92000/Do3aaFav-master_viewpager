package com.example.sarrawi.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by futures on 6/6/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<SliderUtils> sliderImg;
    private OnItemClickListener mOnItemClickListener;
    TextView tv1, tv2, tv3;
    Button b1;
    int counter = 0;

    public ViewPagerAdapter(List sliderImg, Context context) {

        this.sliderImg = sliderImg;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_slider, null);
        final SliderUtils utils = sliderImg.get(position);



        tv1 = (TextView)view.findViewById(R.id.textView1);
        tv2 = (TextView)view.findViewById(R.id.textView2);
        tv3 = (TextView)view.findViewById(R.id.textView3);
        b1  = (Button) view.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == b1) {

                    counter++;
                    //textTitle.setText(Integer.toString(counter));
                    b1.setText(Integer.toString(counter));
                    //scoreText.setBackgroundColor(Color.CYAN);
                    b1.setTextColor(Color.BLUE);
                }
            }
        });
        tv3.setText(utils.getText_counter());
        tv1.setText(utils.getText_doaa());
        tv2.setText(utils.getText_hint());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }



}
