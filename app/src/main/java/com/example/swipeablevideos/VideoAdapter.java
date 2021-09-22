package com.example.swipeablevideos;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<VideoItem> videoItemList;

    public VideoAdapter(List<VideoItem> videoItemList) {
        this.videoItemList = videoItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoItem videoItem = videoItemList.get(position);
        String videoUrl = videoItem.videoUrl;
        String videoTitle = videoItem.videoTitle;
        String videoDesc = videoItem.videoDescription;

        holder.videoView.setVideoPath(videoUrl);
        holder.textVideoTitle.setText(videoTitle);
        holder.textVideoDescription.setText(videoDesc);

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.progressVideo.setVisibility(View.GONE);
                mediaPlayer.start();

                float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                float screenRatio = holder.videoView.getWidth() / (float) holder.videoView.getHeight();
                float scale = videoRatio / screenRatio;
                if (scale >= 1f) {
                    holder.videoView.setScaleX(scale);
                } else {
                    holder.videoView.setScaleY(1f / scale);
                }
            }
        });
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private VideoView videoView;
        private ProgressBar progressVideo;
        private TextView textVideoTitle, textVideoDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            progressVideo = itemView.findViewById(R.id.progressVideo);
            textVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription = itemView.findViewById(R.id.textVideoDescription);

        }
    }
}
