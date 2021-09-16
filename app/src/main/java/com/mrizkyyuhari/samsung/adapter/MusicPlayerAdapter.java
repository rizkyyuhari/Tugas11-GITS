package com.mrizkyyuhari.samsung.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.mrizkyyuhari.samsung.R;
import com.mrizkyyuhari.samsung.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayerAdapter extends RecyclerView.Adapter<MusicPlayerAdapter.MusicPlayerHolder> {

   private List<MusicModel> listMusic = new ArrayList<>();
   private Context context;
   private MusicListener mMusicListener;


    public MusicPlayerAdapter(List<MusicModel> listMusic,MusicListener mMusicListener) {
        this.listMusic = listMusic;
        this.mMusicListener = mMusicListener;
    }

    @NonNull
    @Override
    public MusicPlayerAdapter.MusicPlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_music,parent,false);
        return new MusicPlayerHolder(view,mMusicListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicPlayerAdapter.MusicPlayerHolder holder, int position) {
        holder.tvArtis.setText(listMusic.get(position).getArtis());
        holder.tvSong.setText(listMusic.get(position).getSong());

    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class MusicPlayerHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvArtis, tvSong;

        MusicListener musicListener;

        public  MusicPlayerHolder(View view, MusicListener musicListener){
            super(view);
            tvArtis = view.findViewById(R.id.tv_artis);
            tvSong = view.findViewById(R.id.tv_song);

            this.musicListener = musicListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            musicListener.musicClick(getAdapterPosition());
        }
    }
    public interface MusicListener{
        void musicClick(int position);
    }
}
