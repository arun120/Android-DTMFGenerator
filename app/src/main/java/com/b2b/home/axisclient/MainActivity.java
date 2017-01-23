package com.b2b.home.axisclient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor edit=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUp=(Button) findViewById(R.id.signUp);
        final EditText number= (EditText) findViewById(R.id.number);
        final EditText password=(EditText) findViewById(R.id.password);
        final EditText confirm= (EditText) findViewById(R.id.confirm);
        sharedPreferences= getSharedPreferences("Data", Context.MODE_PRIVATE);
        edit=sharedPreferences.edit();
        if(sharedPreferences.getString("Password",null)!=null&&sharedPreferences.getString("Account",null)!=null){
            Intent i=new Intent(MainActivity.this,Authenticate.class);
            startActivity(i);
            finish();
        }

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(confirm.getText().toString())){
                    edit.putString("Number",number.getText().toString());
                    edit.putString("Password",confirm.getText().toString());
                    edit.commit();
                    Intent i=new Intent(MainActivity.this,selectAccount.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
