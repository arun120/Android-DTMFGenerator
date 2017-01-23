package com.b2b.home.axisclient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class selectAccount extends AppCompatActivity {
    SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor edit=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account);
        ListView account = (ListView) findViewById(R.id.accountList);
        final List<String> accountDetails=new ArrayList<String>();
        accountDetails.add("IDBI00001234501");
        accountDetails.add("HDFC00001234501");
        accountDetails.add("AXIS00001234501");
        sharedPreferences= getSharedPreferences("Data", Context.MODE_PRIVATE);
        edit=sharedPreferences.edit();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,accountDetails);
        account.setAdapter(adapter);

        account.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Clicked",String.valueOf(position));
                edit.putString("Account",accountDetails.get(position));
                edit.commit();

                Intent i=new Intent(selectAccount.this,Payment.class);
                startActivity(i);
                finish();
            }
        });


    }
}
