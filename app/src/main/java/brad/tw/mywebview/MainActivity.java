package brad.tw.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webview = new WebView(this);
        webview.loadUrl("http://www.iii.org.tw");
        setContentView(webview);

//        setContentView(R.layout.activity_main);

//        mesg = (TextView)findViewById(R.id.mesg);
//        webview = (WebView)findViewById(R.id.webview);
        initWebView();
    }

    private void initWebView(){

    }
}
