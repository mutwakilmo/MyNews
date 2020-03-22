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
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.mutwakilmo.android.mynews.Activities.NewYorkTimesWebViewActivity;
import com.mutwakilmo.android.mynews.Models.New_York_Times_Top_Stories.TopStoriesResultsItem;
import com.mutwakilmo.android.mynews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public void view(OnItemClickListener listener) {
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
        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        holder.dateTextView.setText(topStoriesResultsItem.getPublishedDate().substring(0, 10) + "");
        if (topStoriesResultsItem.getSubsection() != null && !topStoriesResultsItem.getSubsection().isEmpty())
            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + " > " + topStoriesResultsItem.getSubsection());
        else

            holder.sectionTextView.setText(topStoriesResultsItem.getSection() + "");
        holder.titleTextView.setText(topStoriesResultsItem.getTitle() + "");

        if (topStoriesResultsItem.getMultimedia() != null &&topStoriesResultsItem.getMultimedia().size() > 0)
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

        });
    }

    @Override
    public int getItemCount() {
        if (topStoriesResultsItems == null) return 0;
        else return topStoriesResultsItems.size();
    }

    public class NewsItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_news)
        KenBurnsView newsImageView;
        @BindView(R.id.tv_section)
        TextView sectionTextView;
        @BindView(R.id.tv_date)
        TextView dateTextView;
        @BindView(R.id.tv_title)
        TextView titleTextView;
        @BindView(R.id.imageView5)
        ImageView imageView5;
        @BindView(R.id.container)
        RelativeLayout container;


        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // //Initialize ButterKnife
            ButterKnife.bind(this, itemView);

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