package com.example.swipeablevideos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 videosViewPager;
    private List<VideoItem> videoItemList;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videosViewPager = findViewById(R.id.videosViewPager);

        videoItemList = new ArrayList<>();

        videoItemList.add(new VideoItem("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4", "Party", "Enjoy!!!"));
        videoItemList.add(new VideoItem("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4", "Chill", "Enjoy!!!"));
        videoItemList.add(new VideoItem("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4", "Party", "Enjoy!!!"));
        videoItemList.add(new VideoItem("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4", "Chill", "Enjoy!!!"));
        videoItemList.add(new VideoItem("https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4", "Party", "Enjoy!!!"));


        videoAdapter = new VideoAdapter(videoItemList);
        videosViewPager.setAdapter(videoAdapter);

    }
}