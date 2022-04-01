package com.example.appdevproject

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Binder
import android.os.IBinder
import android.widget.Toast


class AudioService : Service() {

    private var iBinder: IBinder = AudioServiceBinder()

    override fun onBind(intent: Intent): IBinder {
        return iBinder
    }

    override fun onStart(intent: Intent?, startId: Int) {
        Toast.makeText(this, "Audio service started",
            Toast.LENGTH_LONG).show()
    }

}

class AudioServiceBinder : Binder() {
    val service: AudioServiceBinder
        get() = this@AudioServiceBinder

    val soundPool: SoundPool = SoundPool.Builder()
        .setMaxStreams(20)
        .setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        ).build()
}