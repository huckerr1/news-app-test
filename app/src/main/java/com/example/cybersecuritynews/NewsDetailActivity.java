package com.example.cybersecuritynews;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import android.content.Intent;
import android.net.Uri;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String content = getIntent().getStringExtra("content");
        String url = getIntent().getStringExtra("url");
        String image = getIntent().getStringExtra("image");
        String source = getIntent().getStringExtra("source");
        String date = getIntent().getStringExtra("date");

        TextView titleTextView = findViewById(R.id.detailTitle);
        TextView descriptionTextView = findViewById(R.id.detailDescription);
        TextView contentTextView = findViewById(R.id.detailContent);
        TextView sourceTextView = findViewById(R.id.detailSource);
        TextView dateTextView = findViewById(R.id.detailDate);
        ImageView imageView = findViewById(R.id.detailImage);
        Button readMoreButton = findViewById(R.id.readMoreButton);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
        contentTextView.setText(content != null ? content : "Full content not available");
        sourceTextView.setText("Source: " + source);
        dateTextView.setText("Published: " + date);

        Glide.with(this)
                .load(image)
                .into(imageView);

        readMoreButton.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(url));
            startActivity(browserIntent);
        });
    }
}
