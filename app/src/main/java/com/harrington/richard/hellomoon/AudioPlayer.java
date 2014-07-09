package com.harrington.richard.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer player;

    public void stop() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void play(Context c) {

        if (player == null) {
            player = MediaPlayer.create(c, R.raw.one_small_step);
        }

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });

        player.start();
    }

}
