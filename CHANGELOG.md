# Changelog

## Version 1.0 - Initial Release (2026-03-30)

### Features Added
- ✅ Real-time cybersecurity news feed
- ✅ NewsAPI integration for fetching articles
- ✅ RecyclerView with card-based UI
- ✅ Pull-to-refresh functionality
- ✅ Article detail screen with full content
- ✅ "Read More" button to open articles in browser
- ✅ Image loading with Glide
- ✅ Material Design UI
- ✅ Date formatting for article publication times
- ✅ Source attribution for each article

### Technical Stack
- Android SDK (API 21-33)
- Java 11
- Retrofit 2 for REST API calls
- Gson for JSON parsing
- Glide for image loading
- AndroidX libraries
- Material Design Components

### API Used
- NewsAPI.org for cybersecurity news

### Project Structure
- Clean architecture with separate layers (API, Model, Adapter, UI)
- MVVM-ready structure for future enhancements
- View Binding enabled for type-safe views

### Known Limitations
- Free API tier: 100 requests/day
- No offline caching (Room database can be added)
- No pagination (can be added later)
- No user authentication

### Future Enhancements
- [ ] Pagination for infinite scroll
- [ ] Search functionality
- [ ] Category/topic filters
- [ ] Save/bookmark articles (Room database)
- [ ] Dark mode toggle
- [ ] Push notifications for breaking news
- [ ] User accounts and preferences
- [ ] Share functionality

### Build & Run
- Minimum API Level: 21 (Android 5.0)
- Target API Level: 33 (Android 13)
- Build Tool: Gradle 7.4.2

---

For detailed information, see README.md
