package com.moustick.weirdox.db.room;

public class Sound {

    private String title;
    private String audio;

    public Sound(String title, String audio) {
        this.title = title;
        this.audio = audio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

}
