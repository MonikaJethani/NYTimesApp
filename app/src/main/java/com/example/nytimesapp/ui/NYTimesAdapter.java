package com.example.nytimesapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesapp.R;
import com.example.nytimesapp.model.Article;

import java.util.List;

public class NYTimesAdapter extends RecyclerView.Adapter<NYTimesAdapter.NYTimesViewHolder> {

    List<Article> articleList;

    NYTimesAdapter(List<Article> articles) {
        articleList = articles;
    }

    @NonNull
    @Override
    public NYTimesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layout_article_view, parent, false);

        // Return a new holder instance
        NYTimesViewHolder viewHolder = new NYTimesViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NYTimesViewHolder holder, int position) {
        // Get the data model based on position
        Article article = articleList.get(position);

        holder.title.setText(article.getTitle());
        holder.date.setText(article.getDatePublished());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NYTimesViewHolder extends RecyclerView.ViewHolder {

        TextView title, date;

        public NYTimesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);

        }
    }
}
