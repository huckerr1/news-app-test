#!/bin/bash

# Enhanced build script for CyberSecurityNews
# This script handles Gradle setup automatically

PROJECT_DIR="/home/chetan/testing-vscode/CyberSecurityNews"
cd "$PROJECT_DIR" || exit 1

echo "🔨 Building CyberSecurityNews Android App..."
echo "==========================================="
echo ""

# Step 1: Check Java
echo "✅ Checking Java..."
if ! command -v java &> /dev/null; then
    echo "❌ Java not found. Install Java 11 or higher"
    exit 1
fi
java -version
echo ""

# Step 2: Check/Setup Gradle
echo "✅ Checking Gradle..."
GRADLE_CMD=""

# Try local gradle-local first
if [ -d "gradle-local/bin" ]; then
    echo "   Using local Gradle (gradle-local)"
    GRADLE_CMD="./gradle-local/bin/gradle"
elif command -v gradle &> /dev/null; then
    echo "   Using system Gradle"
    GRADLE_CMD="gradle"
else
    echo "⏳ Gradle not found. Setting up..."
    if [ ! -d "gradle-local" ]; then
        echo "   Downloading Gradle 7.4.2... (this may take 1-2 minutes)"
        wget -q https://services.gradle.org/distributions/gradle-7.4.2-bin.zip -O gradle-temp.zip
        unzip -q gradle-temp.zip
        mv gradle-7.4.2 gradle-local
        rm gradle-temp.zip
        echo "   ✅ Gradle ready"
    fi
    GRADLE_CMD="./gradle-local/bin/gradle"
fi

echo ""

# Step 3: Build APK
echo "🏗️  Building APK..."
echo "   This will take 2-3 minutes on first build..."
echo ""

$GRADLE_CMD assembleDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "=============================================="
    echo "✅ BUILD SUCCESSFUL!"
    echo "=============================================="
    echo ""
    echo "📱 APK Location:"
    APK_PATH="$PROJECT_DIR/app/build/outputs/apk/debug/app-debug.apk"
    ls -lh "$APK_PATH"
    echo ""
    echo "📋 Next Steps:"
    echo ""
    echo "📱 OPTION A: Install on Physical Android Phone"
    echo "   1. Connect phone via USB"
    echo "   2. Enable USB Debugging (Settings → Developer Options)"
    echo "   3. Run: adb install $APK_PATH"
    echo "   4. Run: adb shell am start -n com.example.cybersecuritynews/.MainActivity"
    echo ""
    echo "🌐 OPTION B: Upload to Online Emulator (Easiest)"
    echo "   1. Visit: https://appetize.io/"
    echo "   2. Upload: $APK_PATH"
    echo "   3. Click Open and test in browser"
    echo ""
else
    echo ""
    echo "❌ BUILD FAILED"
    echo "Please check the errors above"
    exit 1
fi
