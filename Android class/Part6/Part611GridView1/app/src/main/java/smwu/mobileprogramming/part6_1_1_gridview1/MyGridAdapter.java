package smwu.mobileprogramming.part6_1_1_gridview1;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyGridAdapter extends BaseAdapter {
    Context context;
    View dialogView;

    Integer[] posterID = { R.drawable.mov1, R.drawable.mov2, R.drawable.mov3, R.drawable.mov4, R.drawable.mov5};
    Integer[] posterTitle = {R.string.mov1, R.string.mov2, R.string.mov3, R.string.mov4, R.string.mov5};

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 650));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 10, 10);

        imageView.setImageResource(posterID[i]);

        final int pos = i;
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = dialogView.findViewById(R.id.imageViewForPoster);
                ivPoster.setImageResource(posterID[pos]);
//                dlg.setTitle("큰 포스터");
//                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setTitle(posterTitle[pos]);
                dlg.setIcon(posterID[pos]);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
        return imageView;
    }

    public MyGridAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount(){
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
