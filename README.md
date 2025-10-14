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

**POST API Endpoint:**

# PdfParserApp

Minimal Android Studio project (Kotlin) that demonstrates:
- A single button "Upload & Parse"
- File picker to select PDF files
- Uploads selected PDF as multipart to:
  https://ingest.ngnext.tech/nlm/api/parseDocument?renderFormat=all
- Appends server response to a scrollable TextView

Open this folder in Android Studio and let it sync Gradle. You might need to set `local.properties` with your SDK path or let Android Studio configure it automatically.
