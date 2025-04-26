# 🎵 GNPlayer – Lightweight Android Music Player (Demo)

A minimalistic, Java-based Android application for local music playback. GNPlayer is designed to **demonstrate core media playback functionality** using Android’s native libraries without requesting any device permissions or accessing external storage.

## 📱 Features

- 🎧 **Play/Pause Music**: Basic playback controls using Android’s `MediaPlayer` API.
- 📍 **SeekBar Integration**: Real-time progress tracking and seek control for the music.
- 🔒 **No Permissions Required**: App doesn’t access user storage or request any runtime permissions.
- 📂 **Static Music Integration**: Music file is bundled within the app under `res/raw/`.

## 💻 Tech Stack

- **Language**: Java
- **Platform**: Android (API level 21+)
- **Libraries Used**:
  -  Uses Handler and Runnable classes for updating the UI asynchronously during media playback.
  - `android.media.MediaPlayer` for audio playback
  - `android.os.Handler` for UI thread updates
  - `android.widget.SeekBar`, `Button`, and `TextView` for UI controls

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/experiment-lab/GNPlayer.git
cd GNPlayer
