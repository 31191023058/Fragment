package com.quocanh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContentFrag extends Fragment {
    GridView gridView;
    PhotoAdapter adapter;
    private AdapterView.OnItemClickListener onItem = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(getActivity(), ViewPhotoActivity.class);
            intent.putExtra("id", (int) gridView.getAdapter().getItemId(i));
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.findViewById(R.id.gridview);
        adapter = new PhotoAdapter(PhotoData.generatedPhotoData(),getContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(onItem);
        return view;
    }

    public void updateContent (int position) {
        PhotoAdapter photoAdapter = new PhotoAdapter(PhotoData.getPhotosByCategory(position), getContext());
        gridView.setAdapter(photoAdapter);
        gridView.setOnItemClickListener(onItem);
    }
}
