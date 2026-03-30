package com.example.cybersecuritynews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.cybersecuritynews.R;
import com.example.cybersecuritynews.NewsDetailActivity;
import com.example.cybersecuritynews.databinding.ItemNewsBinding;
import com.example.cybersecuritynews.model.Article;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<Article> articles;
    private Context context;

    public NewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void updateArticles(List<Article> newArticles) {
        this.articles = newArticles;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding binding;

        public NewsViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Article article) {
            binding.titleTextView.setText(article.getTitle());
            binding.descriptionTextView.setText(article.getDescription() != null ? article.getDescription() : "No description available");
            
            if (article.getSource() != null) {
                binding.sourceTextView.setText("Source: " + article.getSource().getName());
            }

            String publishedDate = formatDate(article.getPublishedAt());
            binding.dateTextView.setText("Published: " + publishedDate);

            Glide.with(context)
                    .load(article.getUrlToImage())
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_error)
                    .into(binding.imageView);

            binding.getRoot().setOnClickListener(v -> {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("title", article.getTitle());
                intent.putExtra("description", article.getDescription());
                intent.putExtra("content", article.getContent());
                intent.putExtra("url", article.getUrl());
                intent.putExtra("image", article.getUrlToImage());
                intent.putExtra("source", article.getSource() != null ? article.getSource().getName() : "");
                intent.putExtra("date", article.getPublishedAt());
                context.startActivity(intent);
            });
        }

        private String formatDate(String dateString) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
                Date date = inputFormat.parse(dateString);
                SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
                return outputFormat.format(date);
            } catch (Exception e) {
                return dateString;
            }
        }
    }
}
