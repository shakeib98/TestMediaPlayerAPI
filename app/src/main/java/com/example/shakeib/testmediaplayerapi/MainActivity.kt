package com.example.shakeib.testmediaplayerapi

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var media = MediaPlayer.create(this,R.raw.btsdna )


        val playButton = findViewById(R.id.play_button) as Button

        playButton.setOnClickListener {
            media.start()
        }

        val pauseButton = findViewById<Button>(R.id.pause_button)

        pauseButton.setOnClickListener {
            media.pause()
        }

        val stopButton = findViewById<Button>(R.id.stop_button)

        stopButton.setOnClickListener {
            media.stop()
            media = MediaPlayer.create(this,R.raw.btsdna )
        }

        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        val volUpButton = findViewById<Button>(R.id.vol_up_button)
        volUpButton.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND)

        }

        val volDownButton = findViewById<Button>(R.id.vol_down_button)
        volDownButton.setOnClickListener {
            audioManager.adjustVolume(AudioManager.ADJUST_LOWER,AudioManager.FLAG_PLAY_SOUND)

        }

    }
}
