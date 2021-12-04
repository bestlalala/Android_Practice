package com.example.part3_4_1_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    // 1st 삽입
    TextView objTV;
    LinearLayout objMV;

    // 1st 삽입 for SubMenu1
    // Group No.
    public static final int ID_GROUP_TEXT_COLOR = 1;
    public static final int ID_GROUP_TEXT_STYLE = 2;
    public static final int ID_GROUP_TEXT_SIZE = 3;
    public static final int ID_GROUP_REX1 = 4;
    public static final int ID_GROUP_REX2 = 5;

    // Text Color Item No.
    public static final int ID_COLOR_RED = 11;
    public static final int ID_COLOR_GREEN = 12;
    public static final int ID_COLOR_BLUE = 13;
    public static final int ID_COLOR_YELLOW = 14;
    public static final int ID_COLOR_WHITE = 15;

    //Text Style Item No.
    public static final int ID_TEXT_NORMAL = 21;
    public static final int ID_TEXT_BOLD = 22;
    public static final int ID_TEXT_ITALIC = 23;

    //Test Size Item No.
    public static final int ID_TEXTSIZE_10P = 31;
    public static final int ID_TEXTSIZE_18P = 32;
    public static final int ID_TEXTSIZE_24P = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2nd 삽입
        objTV = (TextView) findViewById(R.id.textView1);
        objMV = (LinearLayout) findViewById(R.id.mainLayout);

        // Context Menu를 동작시키기 위한 objTV 등록
        registerForContextMenu(objTV); // Context menu 제공

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Code Change and Insert for SubMenu
        //MenuItem miTextColor = menu.add("Text Color");
        //MenuItem miTextStyle = menu.add("Text Style");
        //MenuItem miTextSize = menu.add("Text Size");

        SubMenu smTextColor = menu.addSubMenu("Text Color");
        SubMenu smTextStyle = menu.addSubMenu("Text Style");
        SubMenu smTextSize = menu.addSubMenu("Text Size");

        smTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_RED, 1, "Red");
        smTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_GREEN, 2, "Green");
        smTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_BLUE, 3, "Blue");

        smTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_NORMAL, 1, "Normal").setChecked(true);
        smTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_BOLD, 2, "Bold");
        smTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_ITALIC, 3, "Italic");
        smTextStyle.setGroupCheckable(ID_GROUP_TEXT_SIZE, true, true);

        smTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_10P, 1, "10pt");
        smTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_18P, 2, "18pt");
        smTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_24P, 3, "24pt");


        SubMenu etc = menu.addSubMenu("Etc");

        SubMenu smREX1 = etc.addSubMenu("REX1");
        smREX1.setIcon(R.drawable.rex1);

        SubMenu smREX2 = etc.addSubMenu("REX2");
        smREX2.setIcon(R.drawable.rex2);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTV.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTV.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTV.setTextColor(Color.BLUE);
                return true;
            case ID_TEXT_NORMAL:
                objTV.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                item.setChecked(true);
                return true;
            case ID_TEXT_BOLD:
                objTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                item.setChecked(true);
                return true;
            case ID_TEXT_ITALIC:
                objTV.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                item.setChecked(true);
                return true;
            case ID_TEXTSIZE_10P:
                objTV.setTextSize(10);
                return true;
            case ID_TEXTSIZE_18P:
                objTV.setTextSize(18);
                return true;
            case ID_TEXTSIZE_24P:
                objTV.setTextSize(24);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        SubMenu smTextBackgroundColor = menu.addSubMenu("Text Background");

        smTextBackgroundColor.add(Menu.NONE, ID_COLOR_RED, Menu.NONE, "RED");
        smTextBackgroundColor.add(Menu.NONE, ID_COLOR_GREEN, Menu.NONE, "Green");
        smTextBackgroundColor.add(Menu.NONE, ID_COLOR_BLUE, Menu.NONE, "Blue");

        SubMenu smLayoutBackgroundColor = menu.addSubMenu("Layout Background");

        smLayoutBackgroundColor.add(Menu.NONE, ID_COLOR_YELLOW, Menu.NONE, "Yellow");
        smLayoutBackgroundColor.add(Menu.NONE, ID_COLOR_WHITE, Menu.NONE, "White");

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTV.setBackgroundColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTV.setBackgroundColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTV.setBackgroundColor(Color.BLUE);
                return true;
            case ID_COLOR_YELLOW:
                objMV.setBackgroundColor(Color.YELLOW);
                return true;
            case ID_COLOR_WHITE:
                objMV.setBackgroundColor(Color.WHITE);
        }
        return super.onContextItemSelected(item);
    }
}