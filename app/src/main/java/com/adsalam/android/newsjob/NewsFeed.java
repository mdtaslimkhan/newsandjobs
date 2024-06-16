package com.adsalam.android.newsjob;


import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsFeed extends AppCompatActivity {
    WebView webView;


    final Activity activity = this;
    String newsName;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_news_feed);

        // Makes Progress bar Visible
        getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);


        //WebView myWebView = (WebView) findViewById(R.id.webView);
//       myWebView.loadUrl("http://www.prothomalo.com");
     // Url url  = getIntent().getData();
        webView = (WebView) findViewById(R.id.webView);
        if(getIntent().hasExtra("name")){
            url = getIntent().getStringExtra("url");
            newsName = getIntent().getStringExtra("name");
            setTitle(newsName);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");
       // webSettings.setRenderPriority(RenderPriority.HIGH);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);


//
//        WebChromeClient webChromeClient = new WebChromeClient() {
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                result.cancel();
//                return true;
//            }
//
//            @Override
//            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
//                result.cancel();
//                return true;
//            }
//
//            @Override
//            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
//                result.cancel();
//                return true;
//            }
//        };
//
//        webView.setWebChromeClient(webChromeClient);



        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if(progress == 100)
                    setTitle(newsName);
            }
        });

        webView.setWebViewClient(new Callback());
        webView.loadUrl(url);






    }


    private class Callback extends WebViewClient {


        // if found error then show custom text
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            String summary =
                    "<html><head><meta name='viewport' content='width=device-width, height=device-height, initial-scale=1.0, minimum-scale=1.0'></head><body>" +
                            "<h2 style='position:absolute;font-weight:400; color:#000000; top: 50%;left: 50%;transform: translate(-50%, -50%); color:#cccccc'>" +
                            "Please check internet connection...</h2>" +
                            "</body>" +
                            "</html>";
            webView.loadData(summary, "text/html", null);

            Toast.makeText(activity, "" + description, Toast.LENGTH_SHORT)
                    .show();
        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }
    }


    // To handle "Back" key press event for WebView to go back to previous screen.
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
//            webView.goBack();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private boolean isNetworkAvailable() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager
//                .getActiveNetworkInfo();
//        return activeNetworkInfo != null;
//    }

    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }









}



