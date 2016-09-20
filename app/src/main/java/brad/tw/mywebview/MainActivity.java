package brad.tw.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webview;
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        webview = new WebView(this);
//        webview.loadUrl("http://www.iii.org.tw");
//        setContentView(webview);

        setContentView(R.layout.activity_main);

        mesg = (TextView)findViewById(R.id.mesg);
        webview = (WebView)findViewById(R.id.webview);
        inputName = (EditText)findViewById(R.id.inputName);
        initWebView();
    }

    private void initWebView(){
        WebViewClient client = new WebViewClient();
        webview.setWebViewClient(client);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        webview.addJavascriptInterface(new BradJS(), "brad");

//        webview.loadUrl("http://www.iii.org.tw");
        webview.loadUrl("file:///android_asset/brad.html");
//        webview.loadUrl("file:///android_asset/imgs/android.gif");
//        String data = "<h1>Brad Big Company</h1>";
//        webview.loadData(data, "text/html;charset=UTF-8",null);


    }


    public class BradJS {
        @JavascriptInterface
        public void showMesg(String webmesg){
            Log.d("brad", webmesg);
        }
    }

    public void b1task(View v){
        //doPrev();
        String name = inputName.getText().toString();
        webview.loadUrl("javascript:test2('" + name +"')");

    }
    public void b2task(View v){
        int x = 3,  y = 4;
        webview.loadUrl("javascript:test3(" + x + "," + y +")");
    }
    public void b3task(View v){
        doReload();
    }

    private void doPrev(){
        webview.goBack();
    }
    private void doNext(){
        webview.goForward();
    }
    private void doReload(){
        webview.reload();
    }

}
