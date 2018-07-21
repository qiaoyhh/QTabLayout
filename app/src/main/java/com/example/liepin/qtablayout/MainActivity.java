package com.example.liepin.qtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.qyh.qtablayoutlib.QTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QTabLayout qTablayout;
    private ViewPager viewPager;
    private List<String> tabNames;
    private FragmentAdapter baseFragmentAdapter;
    private static final String TAG = "qyh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qTablayout = (QTabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        qTablayout.setTabMode(QTabLayout.SCROLL_AXIS_NONE);

        initData();
        initFragmenAdapter();
    }

    private void initFragmenAdapter() {
        List<Fragment> tabFragmentList = new ArrayList<>();
        for (int i = 0; i < tabNames.size(); i++) {
            tabFragmentList.add(createListFragments(tabNames.get(i)));
        }
        if (baseFragmentAdapter == null) {
            baseFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), tabFragmentList,
                    tabNames);
        }

        if (viewPager != null) {
            viewPager.setAdapter(baseFragmentAdapter);
            qTablayout.setupWithViewPager(viewPager);
        }
    }

    private Fragment createListFragments(String tabName) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tabName", tabName);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    private void initData() {
        tabNames = new ArrayList<>();
        tabNames.add("Android");
        tabNames.add("IOS");
        tabNames.add("Java");
        tabNames.add("PHP(最好的编程语音)");
        tabNames.add("Python");
        tabNames.add("C++");
    }
}
