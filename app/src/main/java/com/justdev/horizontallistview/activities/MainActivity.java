package com.justdev.horizontallistview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.justdev.android.jhorizontallistview.HorizontalListView;
import com.justdev.horizontallistview.R;
import com.justdev.horizontallistview.adapters.ListGalleryAdapter;
import com.justdev.horizontallistview.adapters.ListHorizontalAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    HorizontalListView listGallery;
    HorizontalListView listHorizontal;
    ListGalleryAdapter galleryAdapter;
    ListHorizontalAdapter horizontalAdapter;
    List<String> listItems = Arrays.asList("This", "is", "Horizontal", "List", "sample");
    List<String> listGalleryITems = Arrays.asList("This","is","Endless","Horizontal","List","sample");

    int currentGalleryPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listGallery = (HorizontalListView) findViewById(R.id.list_gallery);
        listHorizontal = (HorizontalListView) findViewById(R.id.listview);
        galleryAdapter = new ListGalleryAdapter(this, listGalleryITems);
        horizontalAdapter = new ListHorizontalAdapter(this, listItems);
        listGallery.setAdapter(galleryAdapter);
        listHorizontal.setAdapter(horizontalAdapter);

        /* Create endless gallery using horizontal list view */
        currentGalleryPosition = galleryAdapter.MIDDLE;
        listGallery.setSelection(currentGalleryPosition);

        listGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentGalleryPosition = position;
                Toast.makeText(MainActivity.this, listGalleryITems.get((int)galleryAdapter.getItemId(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
