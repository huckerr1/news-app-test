#!/bin/bash
# Build script for CyberSecurityNews Android App

echo "Building CyberSecurityNews Android App..."
echo ""

# Check if gradle wrapper exists
if [ ! -f "gradlew" ]; then
    echo "❌ Gradle wrapper not found. Please ensure you're in the project root."
    exit 1
fi

# Make gradle wrapper executable
chmod +x gradlew

# Build the app
echo "🔨 Building app..."
./gradlew build

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Build successful!"
    echo ""
    echo "APK Location: app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "To install on device:"
    echo "  ./gradlew installDebug"
    echo ""
    echo "To run on emulator:"
    echo "  ./gradlew installDebug"
    echo "  adb shell am start -n com.example.cybersecuritynews/.MainActivity"
else
    echo ""
    echo "❌ Build failed!"
    exit 1
fi
