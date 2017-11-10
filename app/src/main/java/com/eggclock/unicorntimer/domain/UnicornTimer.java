package com.eggclock.unicorntimer.domain;

import android.os.CountDownTimer;
import java.sql.Timestamp;

public class UnicornTimer {
    private String name;
    private int duration;
    private Timestamp startTime;
    private String picture;

    public UnicornTimer(String name, int duration, Timestamp startTime, String picture) {
        this.name = name;
        this.duration = duration;
        this.startTime = startTime;
        this.picture = picture;
    }

    public void startTimer(){
        new CountDownTimer(this.getDuration(),1000) {
            public void onTick(long millisUntilFinished) {
                System.out.println(millisUntilFinished/1000);
            }

            public void onFinish() {
                System.out.println("finished" + name );
            }
        }.start();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
