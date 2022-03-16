package com.quocanh.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewPhotoActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textViewCapt;
    TextView textViewDesc;
    ArrayList<Photo> photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        photo = new ArrayList<>();
        imageView = findViewById(R.id.imv_viewphoto);
        textViewCapt = findViewById(R.id.tv_viewtitle);
        textViewDesc = findViewById(R.id.tv_viewdesc);
        int id = getIntent().getIntExtra("id", 0);
        Picasso.get().load(PhotoData.getPhotoFromId(id).getSource_photo()).resize(500, 500).centerCrop().into(imageView);
        textViewCapt.setText(PhotoData.getPhotoFromId(id).getTitle_photo());
        textViewDesc.setText(PhotoData.getPhotoFromId(id).getDescription_photo());
    }

}