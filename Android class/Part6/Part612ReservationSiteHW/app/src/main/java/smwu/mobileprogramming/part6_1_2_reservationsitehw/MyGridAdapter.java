package smwu.mobileprogramming.part6_1_2_reservationsitehw;

import android.app.AlertDialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MyGridAdapter extends BaseAdapter {
    Context context;
    View dialogView;
    Button button1, button2;
    TextView textView;
    WebView webView;

    final Integer[] posterID = {R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5,
            R.drawable.mov6, R.drawable.mov7, R.drawable.mov8};

    Integer[] movie_title = {R.string.mov1_title, R.string.mov2_title, R.string.mov3_title, R.string.mov4_title,
    R.string.mov5_title, R.string.mov6_title, R.string.mov7_title, R.string.mov7_title, R.string.mov8_title};

    Integer[] movie_info = {R.string.mov1_info, R.string.mov2_info, R.string.mov3_info, R.string.mov4_info,
            R.string.mov5_info, R.string.mov6_info, R.string.mov7_info, R.string.mov7_info, R.string.mov8_info};

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 650));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 10, 10);

        imageView.setImageResource(posterID[i]);

        final int pos = i;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(context, R.layout.movie_info, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = dialogView.findViewById(R.id.moviePoster);
                ivPoster.setImageResource(posterID[pos]);

                TextView movieTitle = dialogView.findViewById(R.id.movieTitle);
                movieTitle.setText(movie_title[pos]);
                TextView movieInfo = dialogView.findViewById(R.id.movieInfo);
                movieInfo.setText(movie_info[pos]);
                movieInfo.setMovementMethod(new ScrollingMovementMethod());

                textView = dialogView.findViewById(R.id.teaser_mov);

                webView = dialogView.findViewById(R.id.webView);

                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());

                button1 = dialogView.findViewById(R.id.teaserBtn);
                button1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        String title = context.getString(movie_title[pos]);
                        textView.setText(title+" 예고편");
                        String teaserUrl = "https://www.youtube.com/results?search_query=영화+"+ title+"+예고편";
                       webView.loadUrl(teaserUrl);
                    }
                });

                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }

        });

        return imageView;
    }

    private class ViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public MyGridAdapter(Context c){
        context=c;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
