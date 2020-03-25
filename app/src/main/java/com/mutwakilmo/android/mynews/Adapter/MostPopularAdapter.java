
package com.mutwakilmo.android.mynews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.mutwakilmo.android.mynews.Models.New_York_Times_Most_Popular.NYMostPopularResult;
import com.mutwakilmo.android.mynews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mutwakil Mo🐮🐮🐮 on 04/03/2020
 */
public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.NewsItemViewHolder> {
    private List<NYMostPopularResult> nyMostPopularResults;
    private Context mContext;


    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void view(OnItemClickListener listener) {
        mListener = listener;
    }

    public MostPopularAdapter(List<NYMostPopularResult> nyMostPopularResults) {
        this.nyMostPopularResults = nyMostPopularResults;
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

        NYMostPopularResult nyMostPopularResult = nyMostPopularResults.get(position);

        // -------------------------------------------------------------------------------------
        //    A ViewHolder (RecyclerView.ViewHolder): Used to visually represent an element in the data list
        //     in the RecyclerView (a line).
        // -------------------------------------------------------------------------------------

        holder.container.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        holder.dateTextView.setText(nyMostPopularResult.getPublishedDate().substring(0, 10) + "");
        holder.titleTextView.setText(nyMostPopularResult.getTitle() + "");
        holder.sectionTextView.setText(nyMostPopularResult.getSection() + "");


        // -------------------------------------------------------------------------------------
        //    View.OnClickListener() can be replace with lambada
        // -------------------------------------------------------------------------------------


        holder.container.setOnClickListener(view -> {
            Intent myIntent = new Intent(mContext, NewYorkTimesWebViewActivity.class);
            myIntent.putExtra("websiteUrl", nyMostPopularResult.getUrl());
            mContext.startActivity(myIntent);
            //    viewHolder.relativeLayout.setBackgroundColor(R.color.colorPrimaryDark);
        });


        // -------------------------------------------------------------------------------------
        //     Glide. This library will retrieve the image from a URL in the background on its own,
        //     then display it in an ImageView that you've specified.
        // -------------------------------------------------------------------------------------

        if (nyMostPopularResult.getMedia().size() > 0 && nyMostPopularResult.getMedia().get(0).getMediaMetadata().size() > 0)
            Glide.with(mContext)
                    .load(nyMostPopularResult.getMedia().get(0).getMediaMetadata().get(0).getUrl())
                    .fallback(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.newsImageView);

    }

    @Override
    public int getItemCount() {
        if (nyMostPopularResults == null) return 0;
        else return nyMostPopularResults.size();

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
                Log.e("TAG", "Position : ");
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