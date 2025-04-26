🎵 GNPlayer – Lightweight Android Music Player (Demo)
A minimalistic, Java-based Android application for local music playback. GNPlayer is designed to demonstrate core media playback functionality using Android’s native libraries without requesting any device permissions or accessing external storage.

📱 Features
🎧 Play/Pause Music: Basic playback controls using Android’s MediaPlayer API.

📍 SeekBar Integration: Real-time progress tracking and seek control for the music.

🔒 No Permissions Required: App doesn’t access user storage or request any runtime permissions.

📂 Static Music Integration: Music file is bundled within the app under res/raw/.

💻 Tech Stack
Language: Java

Platform: Android (API level 21+)

Libraries Used:
Uses Handler and Runnable classes for updating the UI asynchronously during media playback.

android.media.MediaPlayer for audio playback

android.os.Handler for UI thread updates

android.widget.SeekBar, Button, and TextView for UI controls

🚀 Getting Started
1. Clone the Repository
bash
Copy
Edit
git clone https://github.com/experiment-lab/GNPlayer.git
cd GNPlayer
2. Add Your Music File
Place your audio file in:

css
Copy
Edit
app/src/main/res/raw/
Rename the file to:

Copy
Edit
music.mp3
🎵 The filename must be music (e.g., music.mp3 or music.wav) as expected by the app.

3. Build and Run
Open the project in Android Studio, build the project, and run it on an emulator or physical device.
