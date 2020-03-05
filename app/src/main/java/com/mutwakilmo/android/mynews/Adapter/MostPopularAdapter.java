package com.mutwakilmo.android.mynews.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.NYMostPopularResult;
import com.mutwakilmo.android.mynews.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mutwakil Mo🐮🐮🐮 on 04/03/2020
 */
public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.NewsItemViewHolder> {
    private List<NYMostPopularResult> mNYMostPopularResults = new ArrayList<>();
    private Context mContext;

    public MostPopularAdapter(List<NYMostPopularResult> nyMostPopularResults) {
        this.mNYMostPopularResults= nyMostPopularResults;
    }

    @NonNull
    @Override
    public MostPopularAdapter.NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MostPopularAdapter.NewsItemViewHolder holder, int position) {

        NYMostPopularResult nyMostPopularResult = mNYMostPopularResults.get(position);

        holder.dateTextView.setText(nyMostPopularResult.getPublishedDate().substring(0, 10) +"");
        holder.titleTextView.setText(nyMostPopularResult.getTitle() + "");
        holder.sectionTextView.setText(nyMostPopularResult.getSection() +"");

        //Todo subsection
        if (nyMostPopularResult.getMedia().size() > 0 &&  nyMostPopularResult.getMedia().get(0).getMediaMetadata().size()> 0)
            Glide.with(mContext)
                    .load(nyMostPopularResult.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(holder.newsImageView);

    }

    @Override
    public int getItemCount() {
        if (mNYMostPopularResults == null) return 0;
        else return mNYMostPopularResults.size();

    }


    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView sectionTextView;
        TextView dateTextView;
        TextView titleTextView;
        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.img_news);
            sectionTextView = itemView.findViewById(R.id.tv_section);
            dateTextView = itemView.findViewById(R.id.tv_date);
            titleTextView = itemView.findViewById(R.id.tv_title);



        }
    }
}
