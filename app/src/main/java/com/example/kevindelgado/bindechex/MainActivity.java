package com.example.kevindelgado.bindechex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {


    public void sendMessage(View view){
        EditText decEditText = (EditText) findViewById(R.id.dec_message);
        String decMessage = decEditText.getText().toString();
        int decimal = Integer.parseInt(decMessage);
        String binString = Integer.toBinaryString(decimal);
        String hexString = Integer.toHexString(decimal);
        EditText binEditText = (EditText) findViewById(R.id.bin_message);
        binEditText.setText(binString);
        EditText hexEditText = (EditText) findViewById(R.id.hex_message);
        hexEditText.setText(hexString);
    }

    public void clearMessage(View view){
        EditText et1 = (EditText) findViewById(R.id.hex_message);
        et1.setText("");
        EditText et2 = (EditText) findViewById(R.id.dec_message);
        et2.setText("");
        EditText et3 = (EditText) findViewById(R.id.bin_message);
        et3.setText("");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
