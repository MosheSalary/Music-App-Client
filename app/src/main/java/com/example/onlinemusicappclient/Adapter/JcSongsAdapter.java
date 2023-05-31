package com.example.onlinemusicappclient.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.onlinemusicappclient.Model.GetSongs;
import com.example.onlinemusicappclient.Model.Utility;
import com.example.onlinemusicappclient.R;

import java.util.List;

public class JcSongsAdapter extends RecyclerView.Adapter<JcSongsAdapter.SongsAdapterViewHolder> {
    private int selectedPosition;
    private Context context;
    private List<GetSongs> arrayListSongs;
    private RecycleItemClickListener listener;

    public JcSongsAdapter(Context context, List<GetSongs> arrayListSongs, RecycleItemClickListener listener) {
        this.context = context;
        this.arrayListSongs = arrayListSongs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SongsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.songs_row, parent, false);
        return new SongsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapterViewHolder holder, int position) {
        GetSongs song = arrayListSongs.get(position);

        if (song != null) {
            if (selectedPosition == position) {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
                holder.iv_play_active.setVisibility(View.VISIBLE);
            } else {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
                holder.iv_play_active.setVisibility(View.INVISIBLE);
            }
        }

        holder.tv_title.setText(song.getSongTitle());
        holder.tv_artist.setText(song.getArtist());
        String duration = Utility.convertDuration(Long.parseLong(song.getSongDuration()));
        holder.tv_duration.setText(duration);

        holder.bind(song, listener);
    }

    @Override
    public int getItemCount() {
        return arrayListSongs.size();
    }

    public class SongsAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_artist, tv_duration;
        private ImageView iv_play_active;

        public SongsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_artist = itemView.findViewById(R.id.tv_artist);
            tv_duration = itemView.findViewById(R.id.tv_duration);
            iv_play_active = itemView.findViewById(R.id.iv_player_active);
        }

        public void bind(GetSongs song, RecycleItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickListener(song, getAdapterPosition());
                }
            });
        }
    }

    public interface RecycleItemClickListener {
        void onClickListener(GetSongs song, int position);
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }
}
