package com.example.liepin.qtablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by liepin on 2017/8/7.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    FragmentManager fm;
    private List<Fragment> fragments;
    private List<String> titles;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fm = fm;
    }

    public FragmentAdapter(FragmentManager fm, List<Fragment> fs, List<String> ts) {
        super(fm);
        this.fm = fm;
        fragments = fs;
        titles = ts;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles != null && titles.size() > position ? titles.get(position) : "";

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (position < getCount()) {
            removeFragment(container, position);
        }

        return super.instantiateItem(container, position);
    }

    private void removeFragment(ViewGroup container, int index) {
        String tag = getFragmentTag(container.getId(), index);
        Fragment fragment = fm.findFragmentByTag(tag);
        if (fragment == null)
            return;
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
        ft = null;
        fm.executePendingTransactions();
    }

    private String getFragmentTag(int viewId, int index) {
        try {
            Class<FragmentPagerAdapter> cls = FragmentPagerAdapter.class;
            Class<?>[] parameterTypes = {int.class, long.class};
            Method method = cls.getDeclaredMethod("makeFragmentName",
                    parameterTypes);
            method.setAccessible(true);
            String tag = (String) method.invoke(this, viewId, index);
            return tag;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}