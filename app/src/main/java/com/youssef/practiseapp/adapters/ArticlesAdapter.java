package com.youssef.practiseapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.youssef.practiseapp.R;
import com.youssef.practiseapp.repository.model.ResultsItem;

import java.util.List;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.CustomViewHolder> {

    private List<ResultsItem> dataList;
    private Context context;

    public ArticlesAdapter(Context context, List<ResultsItem> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        TextView txtAuthor;
        TextView txtPublishedDate;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.txtTitle);
            txtAuthor = mView.findViewById(R.id.txtAuthor);
            txtPublishedDate = mView.findViewById(R.id.txtPublishedDate);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtAuthor.setText(dataList.get(position).getByline());
        holder.txtPublishedDate.setText(dataList.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
