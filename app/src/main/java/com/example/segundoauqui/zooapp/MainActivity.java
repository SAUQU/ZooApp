package com.example.segundoauqui.zooapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    public WebView webViewHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.lpzoo.org/";
        webViewHome = (WebView) findViewById(R.id.webViewHome);
        if(savedInstanceState == null) {
            webViewHome.loadUrl(url);
        }
        WebSettings webSettings = webViewHome.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewHome.setWebViewClient(new WebViewClient());

        webViewHome.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) view;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });


    }

    public void btnTakeMeBack(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);



    }


}
