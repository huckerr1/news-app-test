package com.example.cybersecuritynews;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.cybersecuritynews.adapter.NewsAdapter;
import com.example.cybersecuritynews.api.NewsApiService;
import com.example.cybersecuritynews.api.RetrofitClient;
import com.example.cybersecuritynews.model.NewsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsApiService apiService;
    private int currentPage = 1;
    private static final int PAGE_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        setupRecyclerView();
        setupSwipeRefresh();

        apiService = RetrofitClient.getNewsApiService();
        loadCyberSecurityNews();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(null, this);
        recyclerView.setAdapter(adapter);
    }

    private void setupSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            currentPage = 1;
            loadCyberSecurityNews();
        });
    }

    private void loadCyberSecurityNews() {
        progressBar.setVisibility(View.VISIBLE);
        
        // Using a generic cybersecurity query
        Call<NewsResponse> call = apiService.getCyberSecurityNews(
                "cybersecurity OR hacking OR breach OR vulnerability",
                "publishedAt",
                "en",
                PAGE_SIZE,
                currentPage,
                BuildConfig.NEWS_API_KEY
        );

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);

                if (response.isSuccessful() && response.body() != null) {
                    NewsResponse newsResponse = response.body();
                    if (newsResponse.getArticles() != null && !newsResponse.getArticles().isEmpty()) {
                        adapter.updateArticles(newsResponse.getArticles());
                    } else {
                        Toast.makeText(MainActivity.this, "No news found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load news", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
