package com.iman.inc.doadzikirhisnulmuslim;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.iman.inc.doadzikirhisnulmuslim.adapter.ViewPagerAdapt;
import com.iman.inc.doadzikirhisnulmuslim.fragment.FragmentCat;
import com.iman.inc.doadzikirhisnulmuslim.fragment.FragmentFav;
import com.iman.inc.doadzikirhisnulmuslim.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener , ViewPager.OnPageChangeListener{
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevItemViewPager ;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        setupViewPager();
        setUpBotNav();
        setUpToolbar();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.item_cat:
                viewPager.setCurrentItem(1);
                break;
            case R.id.item_fav:
                viewPager.setCurrentItem(2);
                break;

        }


        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (prevItemViewPager!=null){


            prevItemViewPager.setChecked(false);

        }else {
            bottomNavigationView.getMenu().getItem(0).setChecked(false);
        }

            bottomNavigationView.getMenu().getItem(position).setChecked(true);
            prevItemViewPager = bottomNavigationView.getMenu().getItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setUpToolbar() {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void setupViewPager() {
        viewPager= findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(this);
        ViewPagerAdapt viewPagerAdapt = new ViewPagerAdapt(getSupportFragmentManager());
        viewPagerAdapt.addFragment(new FragmentHome());
        viewPagerAdapt.addFragment(new FragmentCat());
        viewPagerAdapt.addFragment(new FragmentFav());
        viewPager.setAdapter(viewPagerAdapt);

    }

    public void setUpBotNav() {
        bottomNavigationView= findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);    }
}
