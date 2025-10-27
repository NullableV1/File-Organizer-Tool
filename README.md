# 🗂️ File Organizer

**File Organizer** is a simple **Java** tool that helps you **organize files** in a given directory based on their type (images, videos, documents, archives, etc.).

Instead of having random files scattered across your **Downloads** folder or desktop, this tool automatically moves each file into a categorized subfolder.

---

##  How It Works

When you run the tool and provide a directory path, it scans all files in that folder  
and moves each file into the appropriate subfolder based on its extension (e.g., `Images`, `Videos`, `Documents`, etc.).

Notes:
- The tool **does not support all extensions yet**, only the most common ones.
- You **must provide a directory path** as an argument when running the program.

---
## 📦 Supported File Categories

| Category | Example Extensions | Destination Folder |
|-----------|--------------------|--------------------|
| Images | `.jpg`, `.jpeg`, `.png`, `.gif` | `Images` |
| Videos | `.mp4`, `.mkv`, `.mov` | `Videos` |
| Audio | `.mp3`, `.wav`, `.flac` | `Music` |
| Documents | `.pdf`, `.docx`, `.txt` | `Documents` |
| Archives | `.zip`, `.rar`, `.7z` | `Archives` |
And More .....
---
## 🚀 How to Install
Open a terminal in the tool’s directory and run:
```bash
makepkg -si
```
