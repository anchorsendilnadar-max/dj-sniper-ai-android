package com.djsniper.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private static final String APP_URL =
            "https://dj-sniper-ai.onrender.com";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);

        webView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        webView.setBackgroundColor(Color.BLACK);

        WebSettings settings = webView.getSettings();

        // JavaScript
        settings.setJavaScriptEnabled(true);

        // Mobile screen fit
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        // Storage
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);

        // Media
        settings.setMediaPlaybackRequiresUserGesture(false);

        // Disable zoom controls
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);

        // WebView clients
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        // Scrollbars
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        // Show app
        setContentView(webView);

        // Load DJ SNIPER AI
        webView.loadUrl(APP_URL);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }

        super.onDestroy();
    }
}
