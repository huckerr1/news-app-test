# QUICK START GUIDE

## ⚡ 3 Steps to Run the App

### Step 1: Get Your Free API Key
1. Go to https://newsapi.org
2. Sign up (free account)
3. Copy your API key from the dashboard

### Step 2: Add API Key to Project
1. Open `app/build.gradle`
2. Find this line:
   ```
   buildConfigField "String", "NEWS_API_KEY", "\"9b4d3e0f1a2c3d4e5f6a7b8c9d0e1f2g\""
   ```
3. Replace the API key with yours:
   ```
   buildConfigField "String", "NEWS_API_KEY", "\"YOUR_ACTUAL_API_KEY_HERE\""
   ```
4. Save the file

### Step 3: Run the App
1. Open Android Studio
2. File → Open → Select the CyberSecurityNews folder
3. Wait for Gradle sync
4. Click Run (green play button) or press Shift+F10
5. Select Android Emulator or connected device
6. Wait ~20 seconds for first load

## 📱 What You'll See

- List of latest cybersecurity news articles
- Pull down to refresh for latest updates
- Tap any article to read full details
- Click "Read More" to open article in browser

## 🛠️ Important Files

- **MainActivity.java** - Main news feed screen
- **NewsDetailActivity.java** - Full article detail view
- **NewsAdapter.java** - RecyclerView adapter for articles
- **RetrofitClient.java** - API connection setup
- **app/build.gradle** - Dependencies and API key (⭐ EDIT THIS)

## 💡 Tips

- First load takes 2-3 seconds
- Pull to refresh anytime for latest news
- Free API tier: 100 requests/day, 20 articles per request
- Internet connection required

## ⚠️ Common Issues

**"Failed to load news"**
→ Check your internet and API key

**"Empty feed"**
→ Your API might be rate-limited (wait a few mins)

**"Images not showing"**
→ Normal - some sources restrict images

## 📚 Learn More

See README.md for complete documentation
