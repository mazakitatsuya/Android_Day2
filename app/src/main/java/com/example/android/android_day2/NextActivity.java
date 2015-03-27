package com.example.android.android_day2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;


public class NextActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        TextView tv = (TextView) findViewById(R.id.textView);

        //intentでデータを受け渡し
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        //テキストをセット
        tv.setText(title);

        //ionで画像データを取ってくる
        Ion.with(iv)
                .smartSize(true)
                .placeholder(R.drawable.thumb_noimage)
                .error(R.drawable.thumb_noimage)
                .load(url);

        //actionbarに戻るボタンを表示する
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setHomeButtonEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
