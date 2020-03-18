package com.mutwakilmo.android.mynews;

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

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.mutwakilmo.android.mynews.Activities.NewYorkTimesWebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mutwakil Mo on
 */
@SuppressWarnings("ALL")
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public MyAdapter(List<ListItem> listItems, Context context) {
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
        viewHolder.sectionTextView.setText(listItem.getSection());


        viewHolder.titleTextView.setText(listItem.getDesc());
        viewHolder.dateTextView.setText(listItem.getDate());
        Picasso.get().load(listItem.getUrlImage()).into(viewHolder.newsImageView);


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
