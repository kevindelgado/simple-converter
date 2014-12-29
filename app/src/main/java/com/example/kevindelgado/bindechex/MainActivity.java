package com.example.kevindelgado.bindechex;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.content.Intent;
import android.widget.EditText;
import android.view.View.OnFocusChangeListener;


public class MainActivity extends ActionBarActivity {
    CustomKeyboard myHexKeyboard;
    CustomKeyboard myBinKeyboard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myBinKeyboard = new CustomKeyboard(this, R.id.keyboardview, R.xml.binkbd );
        myHexKeyboard = new CustomKeyboard(this, R.id.keyboardview, R.xml.hexkbd );


        myHexKeyboard.registerEditText(R.id.hex_message);
        myBinKeyboard.registerEditText(R.id.bin_message);

    }
    public void onBackPressed(){
         //NOTE Trap the back key: when CustomKeyboard is still visible hide it, only when it is invisible, finish activity
        if( myHexKeyboard.isCustomKeyboardVisible() ){
            myHexKeyboard.hideCustomKeyboard();
        }
        //else if( myBinKeyboard.isCustomKeyboardVisible() ){
        //    myBinKeyboard.hideCustomKeyboard();
        //}
        else{
            this.finish();
        }
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

    public void sendMessage(View view){


        int currentFocusId = getWindow().getCurrentFocus().getId();
        if(currentFocusId == 2131230783){               //2131230783
            convertFromBinary(view);
        }
        else if(currentFocusId == 2131230784){          //2131230784
            convertFromDecimal(view);
        }
        else{                                           //2131230785
            convertFromHex(view);
        }
    }

    public void convertFromBinary(View view){
        EditText binEditText = (EditText) findViewById(R.id.bin_message);
        String binMessage = binEditText.getText().toString();
        long binary = Long.parseLong(binMessage, 2);
        String decString = Long.toString(binary);
        String hexString = Long.toHexString(binary);
        EditText decEditText = (EditText) findViewById(R.id.dec_message);
        decEditText.setText(decString);
        EditText hexEditText = (EditText) findViewById(R.id.hex_message);
        hexEditText.setText(hexString);

    }

    public void convertFromDecimal(View view){

         EditText decEditText = (EditText) findViewById(R.id.dec_message);
         String decMessage = decEditText.getText().toString();
         long decimal = Long.parseLong(decMessage);
         String binString = Long.toBinaryString(decimal);
         String hexString = Long.toHexString(decimal);
         EditText binEditText = (EditText) findViewById(R.id.bin_message);
         binEditText.setText(binString);
         EditText hexEditText = (EditText) findViewById(R.id.hex_message);
         hexEditText.setText(hexString);

    }

    public void convertFromHex(View view){
        EditText hexEditText = (EditText) findViewById(R.id.hex_message);
        String hexMessage = hexEditText.getText().toString();
        long hexadecimal = Long.parseLong(hexMessage, 16);
        String binString = Long.toBinaryString(hexadecimal);
        String decString = Long.toString(hexadecimal);
        EditText binEditText = (EditText) findViewById(R.id.bin_message);
        binEditText.setText(binString);
        EditText decEditText = (EditText) findViewById(R.id.dec_message);
        decEditText.setText(decString);

    }

    public void clearMessage(View view){
        EditText et1 = (EditText) findViewById(R.id.hex_message);
        et1.setText("");
        EditText et2 = (EditText) findViewById(R.id.dec_message);
        et2.setText("");
        EditText et3 = (EditText) findViewById(R.id.bin_message);
        et3.setText("");


    }
}
