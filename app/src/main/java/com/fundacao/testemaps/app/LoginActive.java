package com.fundacao.testemaps.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by leandro on 10/03/14.
 */
public class LoginActive extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        Button b1 = (Button) findViewById(R.id.btFbLogin);

        View.OnClickListener list1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActive.this, MainActivity.class));
            }
        };

        b1.setOnClickListener(list1);


    }

/*
   public void click_btFaceLogin(View view){
       Intent intent = new Intent();
       intent.setClass(LoginActive.this,
               MainActivity.class);

       startActivity(intent);

       finish();
    }
    */
}
