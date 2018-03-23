package com.iman.inc.doadzikirhisnulmuslim.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iman.inc.doadzikirhisnulmuslim.R;
import com.iman.inc.doadzikirhisnulmuslim.adapter.JudulAdapt;
import com.iman.inc.doadzikirhisnulmuslim.helper.DbHelper;
import com.iman.inc.doadzikirhisnulmuslim.model.JudulModel;

import java.util.List;

/**
 * Created by z on 15/03/18.
 */

public class HomeFragment extends Fragment {
    View v;
    DbHelper dbHelper ;
    Context context;
    RecyclerView recyclerView;
    JudulAdapt adapt ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_home, container,false);
        initView();
        return v;
    }

    private void initView() {
        context=getContext();
        dbHelper = new DbHelper(context);
        List <JudulModel> listBalik= dbHelper.getAlldata();
        adapt = new JudulAdapt(listBalik,context);
        recyclerView = v.findViewById(R.id.recView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapt);

    }
}
