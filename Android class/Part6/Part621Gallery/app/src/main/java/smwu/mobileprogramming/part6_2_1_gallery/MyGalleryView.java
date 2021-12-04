package smwu.mobileprogramming.part6_2_1_gallery;

import static smwu.mobileprogramming.part6_2_1_gallery.MainActivity.ivPoster;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyGalleryView extends BaseAdapter {

    Context context;
    Integer[] posterID = { R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5};
    Integer[] posterTitle = {R.string.mov1, R.string.mov2, R.string.mov3, R.string.mov4, R.string.mov5};
    public MyGalleryView(Context c){
        context = c;
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
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new Gallery.LayoutParams(300, 400));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5, 5, 5, 5);
        imageview.setImageResource(posterID[position]);

        final int pos = position;
        imageview.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setImageResource(posterID[pos]);

                // Toast 추가
                Toast toast = new Toast(context.getApplicationContext());
                View toastView = (View) View.inflate(context.getApplicationContext(),
                        R.layout.toast_view, null);
                TextView toastText = (TextView) toastView.findViewById(R.id.textView1);
                toastText.setText(posterTitle[pos]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imageview;
    }
}
