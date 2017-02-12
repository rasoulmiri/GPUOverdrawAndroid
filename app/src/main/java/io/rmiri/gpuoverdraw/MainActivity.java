/*
 * Created by Rasoul Miri on 2/3/17 9:03 PM.
 */

package io.rmiri.gpuoverdraw;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ProgressBar progressBar;
    ImageView header;
    private WatchAdapter adapter;
    private List<Watch> watchList;

    private int[] thumbnails = new int[]{R.drawable.watch_1, R.drawable.watch_2, R.drawable.watch_3, R.drawable.watch_4};
    private String[] brands = new String[]{"Nike Sport Band","Nike Sport Band","Nike Sport Band","Nike Sport Band"};
    private String[] colors = new String[]{"Silver/White","Black/Cool","Silver/Volt","Black/Volt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        header = (ImageView) findViewById(R.id.header);

        //initial data
        watchList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Watch a = new Watch(brands[i], colors[i], thumbnails[i]);
            watchList.add(a);
        }

        //initial recyclerView
        adapter = new WatchAdapter(this, watchList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        //after 7 second photo load in imageView
        //timer for show phoyo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                header.setImageResource(R.drawable.header_watches);
                //uncomment for remove rectangle overdraw in header
                //progressBar.setVisibility(View.GONE);
            }
        }, 7000);


    }

}
