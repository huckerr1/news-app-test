#!/bin/bash
# Run script for CyberSecurityNews Android App

echo "CyberSecurityNews - Android App Launcher"
echo "========================================"
echo ""

# Check if gradlew exists
if [ ! -f "gradlew" ]; then
    echo "❌ Gradle wrapper not found. Please ensure you're in the project root."
    exit 1
fi

chmod +x gradlew

echo "Building and installing app..."
./gradlew installDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ App installed successfully!"
    echo ""
    echo "🚀 Launching app..."
    adb shell am start -n com.example.cybersecuritynews/.MainActivity
    echo ""
    echo "📱 App is now running on your device/emulator!"
else
    echo ""
    echo "❌ Installation failed!"
    exit 1
fi
