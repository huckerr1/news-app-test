# CyberSecurity News Android App

A real-time cybersecurity news application built with Android that fetches and displays the latest cybersecurity news, hacking alerts, data breaches, and vulnerability reports.

## Features

✅ **Real-time News Feed** - Fetches latest cybersecurity news from NewsAPI
✅ **Pull to Refresh** - Swipe down to refresh the news feed
✅ **News Details** - Tap on any news item to see full details
✅ **External Links** - "Read More" button opens the full article in browser
✅ **Image Loading** - Displays article images with loading and error placeholders
✅ **Beautiful UI** - Material Design with dark color scheme
✅ **Date Formatting** - Displays news publication dates in readable format
✅ **Source Attribution** - Shows the source of each news article

## Project Structure

```
CyberSecurityNews/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/cybersecuritynews/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── NewsDetailActivity.java
│   │   │   │   ├── adapter/
│   │   │   │   │   └── NewsAdapter.java
│   │   │   │   ├── api/
│   │   │   │   │   ├── NewsApiService.java
│   │   │   │   │   └── RetrofitClient.java
│   │   │   │   └── model/
│   │   │   │       ├── Article.java
│   │   │   │       └── NewsResponse.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── item_news.xml
│   │   │   │   │   └── activity_news_detail.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_placeholder.xml
│   │   │   │   │   └── ic_error.xml
│   │   │   │   └── AndroidManifest.xml
│   ├── build.gradle
│   ├── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── gradle.properties
└── README.md
```

## Dependencies

- **AndroidX**: Core Android components
- **Retrofit 2**: REST API client
- **Gson**: JSON serialization/deserialization
- **OkHttp**: HTTP client with logging
- **Glide**: Image loading and caching
- **Material Design**: UI components
- **SwipeRefreshLayout**: Pull-to-refresh functionality

## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Android SDK (minimum API 21)
- Java Development Kit (JDK 11 or higher)

### Installation & Setup

1. **Get a Free API Key from NewsAPI**
   - Visit [https://newsapi.org](https://newsapi.org)
   - Sign up for a free account
   - Copy your API key

2. **Update the API Key**
   - Open `app/build.gradle`
   - Find the line: `buildConfigField "String", "NEWS_API_KEY", "\"YOUR_API_KEY_HERE\""`
   - Replace `9b4d3e0f1a2c3d4e5f6a7b8c9d0e1f2g` with your actual API key

3. **Open Project in Android Studio**
   ```
   - File → Open → Select the CyberSecurityNews folder
   ```

4. **Build the Project**
   ```
   - Build → Make Project (or press Ctrl+F9)
   ```

5. **Run the App**
   - Create an Android Virtual Device (AVD) or connect a real device
   - Run → Run 'app' (or press Shift+F10)

## How It Works

1. **MainActivity** displays a list of cybersecurity news articles
2. **NewsAdapter** binds article data to RecyclerView items
3. **RetrofitClient** manages API connection with NewsAPI
4. **NewsApiService** defines API endpoints
5. Tap any article to see full details in **NewsDetailActivity**
6. Pull down to refresh the news feed
7. Click "Read More" to open the full article in your browser

## API Details

**API Provider**: [NewsAPI.org](https://newsapi.org)

**Endpoint Used**: `/v2/everything`

**Query Terms**:
- cybersecurity
- hacking
- breach
- vulnerability
- data breach
- cyber attack

**Parameters**:
- `q`: Search query (cybersecurity-related terms)
- `sortBy`: publishedAt (latest first)
- `language`: English only
- `pageSize`: 20 articles per request
- `apiKey`: Your NewsAPI key

## Features Explained

### Real-Time Update
The app continuously fetches the latest cybersecurity news articles. Use pull-to-refresh to get the newest updates.

### Article Cards
Each article card shows:
- Preview image
- Title
- Description
- Source name
- Publication date

### News Detail View
Click on any article to see:
- Full-size image
- Complete title
- Source information
- Publication date
- Full description and content
- "Read More" button linking to the original article

## Building and Running

### Via Android Studio
1. Open Android Studio
2. File → Open → Select the project
3. Wait for Gradle sync to complete
4. Click the green Run button

### Via Command Line
```bash
cd CyberSecurityNews
./gradlew assembleDebug
./gradlew installDebug
adb shell am start -n com.example.cybersecuritynews/.MainActivity
```

## Testing the App

1. Launch the app on an emulator or device
2. Wait for the news articles to load (initial load takes 2-3 seconds)
3. Scroll through the articles
4. Pull down to refresh
5. Tap on an article to see details
6. Click "Read More" to view the full article

## Permissions

The app requires these permissions:
- **INTERNET**: To fetch news from the API
- **ACCESS_NETWORK_STATE**: To check internet connectivity

## Troubleshooting

### "Failed to load news" Error
- Check your internet connection
- Verify your API key is correct in `build.gradle`
- Make sure your API key quota hasn't been exceeded on NewsAPI

### Empty News Feed
- API might be rate-limited (free tier has limits)
- Try again in a few minutes
- Check if your API key is valid

### Images Not Loading
- Check internet connection
- Some news sources may have restricted images
- The app shows placeholder for missing images

## API Key Usage Note

The free tier of NewsAPI allows:
- 100 requests per day
- 20 articles per request
- No historical data beyond 30 days

For production use, consider upgrading to a paid plan.

## Future Enhancements

- [ ] Add pagination (load more articles on scroll)
- [ ] Implement search functionality
- [ ] Add category filters
- [ ] Add saved/bookmarked articles
- [ ] Implement dark mode toggle
- [ ] Add push notifications for breaking news
- [ ] Implement caching with Room database
- [ ] Add share functionality

## License

This project is open source and available under the MIT License.

## Support

For issues and questions:
1. Check the troubleshooting section above
2. Verify all API keys and permissions
3. Ensure you're using a compatible Android version (API 21+)

## API Attribution

This app uses the [NewsAPI.org](https://newsapi.org) service to fetch cybersecurity news articles.

---

**Happy News Reading! Stay updated with the latest cybersecurity trends! 🔒**
