package com.example.liepin.qtablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 文 件 名：TabFragment
 * 创 建 人：qyh
 * 创建日期：2018/6/21 12:49
 * 描   述：
 */
public class TabFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tabview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView  tvTypename = (TextView) view.findViewById(R.id.tv_typename);
        if (getArguments() != null) {
            String tabName = getArguments().getString("tabName");
            if (!TextUtils.isEmpty(tabName)) {
                tvTypename.setText(tabName);
            }
        }
    }
}
