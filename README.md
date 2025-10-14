![Kotlin](https://img.shields.io/badge/Language-Kotlin-blueviolet)
![Android](https://img.shields.io/badge/Platform-Android-brightgreen)
![License](https://img.shields.io/badge/License-MIT-lightgrey)


# 📄 PdfParserApp

A clean and simple **Android (Kotlin)** app that allows users to **upload and parse text-based PDF files** using an API.  
Each new parsed result is appended to the output — so you can scroll and view all uploaded file responses in one screen.

---

## 🚀 Features

✅ Upload & parse PDF files  
✅ Append new output without clearing old data  
✅ Scrollable results view  
✅ Safe for multiple uploads — no crashes  
✅ Simple, lightweight, and fast  

---

## 🧩 API Information

[**POST API Endpoint:**](https://ingest.ngnext.tech/nlm/api/parseDocument?renderFormat=all)

The app uploads your selected PDF file and displays the parsed text response directly on-screen.

---

## 🧱 Tech Stack

| Category | Technology |
|-----------|-------------|
| Language | Kotlin |
| UI | XML + ViewBinding |
| Network | Retrofit + OkHttp |
| Async | Kotlin Coroutines |
| Min SDK | 24 |
| Target SDK | 35 |

---

## 📂 Project Structure

PdfParserApp/
│
├── app/
│   ├── src/main/java/com/example/pdfparser/
│   │   ├── MainActivity.kt
│   │   ├── ApiService.kt
│   │   └── ApiClient.kt
│   │
│   ├── res/layout/activity_main.xml
│   ├── res/values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   │
│   └── AndroidManifest.xml
│
├── build.gradle
├── settings.gradle
└── README.md
