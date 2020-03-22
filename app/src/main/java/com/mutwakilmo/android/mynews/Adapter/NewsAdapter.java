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
import com.mutwakilmo.android.mynews.Activities.NewYorkTimesWebViewActivity;
import com.mutwakilmo.android.mynews.Utils.ListItem;
import com.mutwakilmo.android.mynews.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mutwakil Mo on Search Adapter
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public NewsAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final ListItem listItem = listItems.get(i);

        viewHolder.container.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));
        // viewHolder.textViewSection.setText(listItem.getSection());
        // viewHolder.textViewSubsection.setText(listItem.getSubsection());
            viewHolder.titleTextView.setText(listItem.getDesc() +"");
            viewHolder.dateTextView.setText(listItem.getDate() );

//            if (listItem.getSection()!= null && listItem.getSection().equals("")) {
//                viewHolder.sectionTextView.setText(listItem.getSection());
//                if (listItem.getSubsection() != null && listItem.getSubsection().equals("")){
//                    viewHolder.sectionTextView.setText(listItem.getSection() + "->" + listItem.getSubsection());
//
//                }
//            }

            Glide.with(context)
                    .load("https://static01.nyt.com/" + listItem.getUrlImage())
                    .fallback(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(viewHolder.newsImageView);





        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, NewYorkTimesWebViewActivity.class);
                myIntent.putExtra("websiteUrl", listItem.getUrlWebsite());
                context.startActivity(myIntent);
                //    viewHolder.relativeLayout.setBackgroundColor(R.color.colorPrimaryDark);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_news)
        ImageView newsImageView;
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


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);


            ButterKnife.bind(this, itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) ;
                        {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

}
