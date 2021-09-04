package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class download extends AppCompatActivity {
    private WebView webView = null;
    Toolbar toolbar;
    ImageButton back;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        this.webView = (WebView) findViewById(R.id.webView);
        // toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
       // setSupportActionBar(toolbar);


        // Display application icon in the toolbar
      //  getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.app_icon);
     //   getSupportActionBar().setDisplayUseLogoEnabled(true);

        // assigning ID of textView2 to a variable
        back =  findViewById(R.id.backmain);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);

        webView.loadUrl("https://pagalfree.com");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed(){
                finish();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }


}