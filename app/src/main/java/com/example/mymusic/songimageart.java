package com.example.mymusic;

import android.graphics.Bitmap;

public class songimageart {

    private Bitmap bp;
    private String path;

    public songimageart(Bitmap bp, String path) {
        this.bp = bp;
        this.path = path;
    }

    public String getpath() {
        return path;
    }

    public Bitmap getbp() {
        return bp;
    }

}
