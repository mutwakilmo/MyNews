package com.mutwakilmo.android.mynews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mutwakilmo.android.mynews.NewYorkTimesWebViewActivity;
import com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResultsItem;
import com.mutwakilmo.android.mynews.R;

import java.util.List;

/**
 * Created by Mutwakil Mo🐮🐮🐮 on 04/03/2020
 */
public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.NewsItemViewHolder> {
    private List<TopStoriesResultsItem> topStoriesResultsItems;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void view (OnItemClickListener listener) {
        mListener = listener;
    }

    public TopStoriesAdapter(List<TopStoriesResultsItem> topStoriesResultsItems) {
        this.topStoriesResultsItems = topStoriesResultsItems;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder holder, int position) {
        TopStoriesResultsItem topStoriesResultsItem = topStoriesResultsItems.get(position);

        // lets create the animation for the whole card
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
        holder.dateTextView.setText(topStoriesResultsItem.getPublishedDate().substring(0, 10) + ""); // 20/01/2019
        if (topStoriesResultsItem.getSubsection() != null && !topStoriesResultsItem.getSubsection().isEmpty())
            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + " > " + topStoriesResultsItem.getSubsection());
        else

            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + "");
            holder.titleTextView.setText(topStoriesResultsItem.getTitle() + "");

        if (topStoriesResultsItem.getMultimedia().size() > 0)
            Glide.with(mContext)
                    .load(topStoriesResultsItem.getMultimedia().get(0).getUrl())
                    .fallback(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.newsImageView);
        // -------------------------------------------------------------------------------------
        //    View.OnClickListener() can be replace with lambada
        // -------------------------------------------------------------------------------------
        holder.container.setOnClickListener(view -> {
            Intent myIntent = new Intent(mContext, NewYorkTimesWebViewActivity.class);
            myIntent.putExtra("websiteUrl", topStoriesResultsItem.getUrl());
            mContext.startActivity(myIntent);

            //    viewHolder.relativeLayout.setBackgroundColor(R.color.colorPrimaryDark);
        });
    }

    @Override
    public int getItemCount() {
        if (topStoriesResultsItems == null) return 0;
        else return topStoriesResultsItems.size();
    }

    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView sectionTextView;
        TextView dateTextView;
        TextView titleTextView;
        RelativeLayout container;

        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            newsImageView = itemView.findViewById(R.id.img_news);
            sectionTextView = itemView.findViewById(R.id.tv_section);
            dateTextView = itemView.findViewById(R.id.tv_date);
            titleTextView = itemView.findViewById(R.id.tv_title);



            itemView.setOnClickListener(view -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) ;
                    {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}