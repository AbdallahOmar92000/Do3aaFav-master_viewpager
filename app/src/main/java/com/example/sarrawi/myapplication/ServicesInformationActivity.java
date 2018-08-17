package com.example.sarrawi.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sarrawi.myapplication.database.DatabaseHelper;
import com.example.sarrawi.myapplication.model.Adapter_zekr;
import com.example.sarrawi.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ServicesInformationActivity extends AppCompatActivity {
    String[] imageUrls;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    List<SliderUtils> sliderImg;
    ViewPagerAdapter viewPagerAdapter;
    SliderUtils sliderUtils;
    int titleID;
    ArrayList<Product> Data = new ArrayList();
    private int dotscount;
    private ImageView[] dots;
    private List<Adapter_zekr> mProductLists;
    private DatabaseHelper mDBHelper;
    private SliderUtils sliderUtils2;
    ////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_info);

        init();
        viewPager.setCurrentItem(mProductLists.size());
    }


    private void sliderImage() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public void init() {

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        sliderImg = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        mDBHelper = new DatabaseHelper(this);
        mProductLists = mDBHelper.getAllPrayerzekr();
        Data = mDBHelper.getAllPrayer();
        Intent i = getIntent();
        if (i.getExtras() != null) {
            titleID = i.getExtras().getInt("titleID");
            sliderImage();
            get_Slder_image();
        }
    }

    private void get_Slder_image() {

        for (int dataResponse = 0; dataResponse < mProductLists.size(); dataResponse++) {
            try {


                sliderUtils = new SliderUtils();

                if (mProductLists.get(titleID).getName_ID() == mProductLists.get(dataResponse).getName_ID()) {

                    sliderUtils.setText_doaa(mProductLists.get(dataResponse).getDescription());
                    sliderUtils.setText_counter(mProductLists.get(dataResponse).getCounter());
                    sliderUtils.setText_hint(mProductLists.get(dataResponse).getHint());
//                    sliderUtils.setText_qategory(mProductLists.get(dataResponse).getQat());
                    sliderImg.add(sliderUtils);


                } else if (mProductLists.get(dataResponse).getName_ID() == titleID) {
                    sliderImg.clear();
                    for (int x = 0; x < mProductLists.size(); x++) {
                        sliderUtils2 = new SliderUtils();
                        if (mProductLists.get(x).getName_ID() == titleID) {
                            sliderUtils2.setText_doaa(mProductLists.get(x).getDescription());
                            sliderUtils2.setText_counter(mProductLists.get(dataResponse).getCounter());
                            sliderUtils2.setText_hint(mProductLists.get(dataResponse).getHint());
//                            sliderUtils2.setText_qategory(mProductLists.get(dataResponse).getQat());
                            sliderImg.add(sliderUtils2);
                        }
                    }

                }


            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }

        // }// end of for() loop
        adapter_viewPager();


    }

    private void adapter_viewPager() {
        viewPagerAdapter = new ViewPagerAdapter(sliderImg, ServicesInformationActivity.this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(ServicesInformationActivity.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(0, 0, 0, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        

        return super.onOptionsItemSelected(item);

    }
}

