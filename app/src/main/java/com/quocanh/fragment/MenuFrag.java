package com.quocanh.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFrag extends ListFragment {
    String[] menus = {"Flowers", "Animals", "Foods"};
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    IFragmentClickListener itemfragment;

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        ((MainActivity)getActivity()).onMenuItemClick(position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        listView = view.findViewById(android.R.id.list);
        arrayAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.menu_layout, new ArrayList<String>(Arrays.asList(menus)));
        listView.setAdapter(arrayAdapter);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            itemfragment = (IFragmentClickListener) context;
        }  catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public interface IFragmentClickListener {
        public void onMenuItemClick(int position);
    }
}
