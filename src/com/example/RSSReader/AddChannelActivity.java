package com.example.RSSReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddChannelActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addchannel);
        EditText link = (EditText) findViewById(R.id.editText1);
        link.setText(getIntent().getExtras().getString("link"));
        EditText name = (EditText) findViewById(R.id.editText);
        name.setText(getIntent().getExtras().getString("name"));
    }

    public void onAddSaveListener(View view){
        EditText link = (EditText) findViewById(R.id.editText1);
        String channelLink = link.getText().toString();
        EditText name = (EditText) findViewById(R.id.editText);
        String channelName = name.getText().toString();
        ChannelDataBaseHelper dataBaseHelper = new ChannelDataBaseHelper(getApplicationContext());
        dataBaseHelper.pushChannel(channelName, channelLink, null, null);
        finish();
        Intent intent = new Intent(this, ChannelList.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, ChannelList.class);
        startActivity(intent);
    }
}