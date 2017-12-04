package com.example.lurenman.myframeworkone.module.news.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lurenman.myframeworkone.R;
import com.example.lurenman.myframeworkone.base.BaseActivity;
import com.example.lurenman.myframeworkone.base.BasePresenter;

/**
 * @author: baiyang.
 * Created on 2017/12/4.
 */

public class NewsWebViewActivity extends BaseActivity {

    private ImageView iv_back;
    private WebView mWvContent;
    private ProgressBar mPbLoading;
    private String webViewUrl;
    private TextView tv_title;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_newswebview);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        mWvContent = (WebView) findViewById(R.id.wv_content);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        tv_title = (TextView) findViewById(R.id.tv_title);
    }

    @Override
    protected void initVariables() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            webViewUrl = bundle.getString("webViewUrl");
            mWvContent.loadUrl(webViewUrl);
        }
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        WebSettings settings = mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);


        mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mPbLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mPbLoading.setVisibility(View.GONE);
            }
        });

        mWvContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tv_title.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mPbLoading.setProgress(newProgress);
            }
        });

        mWvContent.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWvContent.canGoBack()) {  //表示按返回键
                        mWvContent.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsWebViewActivity.this.finish();
            }
        });
    }
}
