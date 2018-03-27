package com.iman.inc.doadzikirhisnulmuslim.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iman.inc.doadzikirhisnulmuslim.FragmentOnActionListener;
import com.iman.inc.doadzikirhisnulmuslim.R;
import com.iman.inc.doadzikirhisnulmuslim.adapter.ListJudulAdapter;
import com.iman.inc.doadzikirhisnulmuslim.helper.DbHelper;
import com.iman.inc.doadzikirhisnulmuslim.model.JudulModel;

import java.util.List;

/**
 * Created by z on 15/03/18.
 */

public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener{
    View v;
    DbHelper dbHelper ;
    Context context;
    ListView listView;
    ListJudulAdapter listJudulAdapter;
    List <JudulModel> listBalik;
    FragmentOnActionListener fragmentOnActionListener ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_home, container,false);
        initView();
        return v;
    }

    public void setFragmentOnActionListener(FragmentOnActionListener fragmentOnActionListener){
        this.fragmentOnActionListener = fragmentOnActionListener;


    }

    private void initView() {
        context=getContext();
       dbHelper = DbHelper.getInstance(context.getApplicationContext());
         listBalik= dbHelper.getAlldata();
        listJudulAdapter = new ListJudulAdapter(listBalik,context);
        listView = v.findViewById(R.id.recView);
        listView.setAdapter(listJudulAdapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putString("doa",listBalik.get(position).getBagName());
        bundle.putInt("chapID", listBalik.get(position).getIDBag());
        fragmentOnActionListener.onClickRecyclerd(bundle);
    }
}
