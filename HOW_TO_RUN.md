# 🚀 Run the App - Step by Step

## Copy & Paste These Commands (One at a Time)

### Step 1: Navigate to Project
```bash
cd /home/chetan/testing-vscode/CyberSecurityNews
```

### Step 2: Build the APK (Takes 2-3 minutes)
```bash
chmod +x gradlew
./gradlew assembleDebug
```

✅ **Success**: Look for message like: `BUILD SUCCESSFUL`
❌ **Error?** Check internet connection or scroll to troubleshooting

---

## After build succeeds, choose ONE option:

---

## 📱 OPTION A: Run on Physical Android Phone
**Requirements**: Android phone + USB cable + USB Debugging enabled

```bash
# 1. Connect phone via USB
# 2. Enable USB Debugging on phone:
#    Settings → Developer Options → USB Debugging (ON)

# 3. Verify connection
adb devices

# 4. Install app
adb install app/build/outputs/apk/debug/app-debug.apk

# 5. Launch app
adb shell am start -n com.example.cybersecuritynews/.MainActivity

# 6. View app logs (optional)
adb logcat
```

---

## 🌐 OPTION B: Run on Online Emulator (No Installation)
**Requirements**: Internet browser only

```bash
# APK location:
ls -lh app/build/outputs/apk/debug/app-debug.apk

# Then upload to one of these services:
```

**Option B1: Appetize.io (Recommended - Free & Easy)**
1. Visit: https://appetize.io/
2. Upload: `app/build/outputs/apk/debug/app-debug.apk`
3. Click "Open"
4. App runs in browser instantly

**Option B2: BrowserStack (More Devices)**
1. Visit: https://browserstack.com/app-live
2. Upload APK
3. Test on real Android devices
4. Free tier: 100 minutes/month

**Option B3: LambdaTest**
1. Visit: https://lambdatest.com/mobile-app-testing
2. Upload and test
3. Free trial available

---

## ✅ What You'll See When It Works

```
Building...
BUILD SUCCESSFUL in 2m 34s
52 actionable tasks: 52 executed

✅ App ready at: CyberSecurityNews/app/build/outputs/apk/debug/app-debug.apk
```

Then on device/emulator:
- App launches with purple header "Cyber Security News"
- Loading indicator appears
- News articles load after 2-3 seconds
- Scroll to see more articles
- Tap any article for details

---

## ⚠️ Troubleshooting

### Error: "gradlew: command not found"
```bash
cd /home/chetan/testing-vscode/CyberSecurityNews
./gradlew assembleDebug
```
Make sure you're IN the project folder!

### Error: "JAVA_HOME not set"
```bash
# On Linux:
sudo apt-get install default-jdk
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

# Then try build again
./gradlew assembleDebug
```

### Error: "Failed to load news"
- Check internet connection
- Verify API key in `app/build.gradle`
- API quota (free tier: 100 requests/day)

### Build takes very long (>5 mins)
- First build takes longer (downloading deps)
- Subsequent builds are faster
- Check internet speed

### "No such file or directory: gradlew"
```bash
# Make sure you're in project root
cd /home/chetan/testing-vscode/CyberSecurityNews

# Check if gradlew exists
ls -la gradlew

# If not, it will be created during build
./gradlew assembleDebug
```

---

## 📊 Quick Reference

| Step | Command | Time |
|------|---------|------|
| Build APK | `./gradlew assembleDebug` | 2-3 min |
| Install (Phone) | `adb install app/build...` | 30 sec |
| Launch | `adb shell am start...` | 5 sec |
| Upload (Online) | Upload to Appetize.io | 1 min |

---

## 🔍 Check Build Status

```bash
# After running build, check if APK was created:
ls -lh app/build/outputs/apk/debug/app-debug.apk

# Should show:
# -rw-r--r-- ... app-debug.apk (size ~3-5 MB)
```

---

## 📱 RECOMMENDED FOR YOU

Since you want testing only + no Android Studio:

**Pick ONE:**

1. **📱 Physical Phone** (Best)
   - Most realistic
   - Fastest
   - Just need USB cable

2. **🌐 Online Emulator** (Easiest)
   - Zero setup
   - Works in browser
   - Appetize.io recommended

---

## 💡 Next Action

**Copy and run this (takes 3 minutes):**
```bash
cd /home/chetan/testing-vscode/CyberSecurityNews
./gradlew assembleDebug
```

Then tell me:
- ✅ "Build successful" → We'll install on device/emulator
- ❌ "Got error" → Tell me the error message

**Let's go!** 🚀
