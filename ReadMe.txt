# FinTrack - Kotlin Android Budget App

## Overview

**FinTrack** is a lightweight Kotlin Android application designed to help users:

* Track daily expenses
* Set monthly minimum and maximum budget goals
* Monitor spending per category
* Get visual and statistical feedback on budget habits
* Add wallet details and receive spending notifications
* Gain gamified rewards for staying consistent

---

## Features

### 1. **User Authentication**

* Register and login using username/password
* All data linked to specific user

### 2. **Categories**

* Create custom budget categories (e.g. Groceries, Transport)

### 3. **Expense Entry**

* Add date, time range, description, category, and optional photo
* Store and retrieve from local SQLite DB

### 4. **Goals**

* Set monthly minimum and maximum spending targets
* Display progress visually on dashboard/graph

### 5. **Expense History**

* Filter entries by custom date range
* View details and attached image (if provided)

### 6. **Category Breakdown & Graphs**

* View total spent per category
* Display spending vs. budget goals with line chart using MPAndroidChart

### 7. **Wallet Management**

* Add/delete cards (dummy fields only: cardholder, number, expiry)

### 8. **Notifications & Gamification**

* Rewards and badges for:

  * Hitting spending goals
  * Logging daily
* Budget reminders and alerts (local notifications)

---

## Tech Stack

* **Language:** Kotlin
* **Architecture:** MVVM + Repository
* **Database:** Room (SQLite abstraction)
* **Image Storage:** Internal Storage
* **Chart Library:** MPAndroidChart
* **Navigation:** Intent-based (or Navigation Component if preferred)

---

## Permissions

In `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.CAMERA"/>
```

---

## Notes

* All data is stored **offline** using Room.
* Minimal UI ensures responsiveness on low-end phones.
* Crashes are handled with input validation and try-catch blocks.
* App includes a simple reward system (local only).

---

## To Run

1. Clone or download project.
2. Open in **Android Studio**.
3. Press **Run** or build APK.

---

## Dependencies

Add in `build.gradle` (Module):

```gradle
implementation 'androidx.room:room-runtime:2.6.1'
kapt 'androidx.room:room-compiler:2.6.1'
implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.7.0'
```

---
