package com.example.mymusic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientImpl extends WebViewClient {
    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;

    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.indexOf("pagalfree.com") > -1 ) return false;
     //   www.pagalworld.pw
        //pagalfree.com
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

}
