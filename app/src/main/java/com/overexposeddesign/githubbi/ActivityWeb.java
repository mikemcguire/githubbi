package com.overexposeddesign.githubbi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.overexposeddesign.githubbi.clients.WebClient;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        String url = b.getString("url");

        WebView webView = (WebView) findViewById(R.id.webViewer);
        webView.setWebViewClient(new WebClient());
        webView.loadUrl(url);

    }

}
