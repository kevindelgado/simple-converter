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

    int curFocus = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText decEditText = (EditText) findViewById(R.id.dec_message);
        decEditText.setOnFocusChangeListener(myEditTextFocus);

        EditText binEditText = (EditText) findViewById(R.id.bin_message);
        binEditText.setOnFocusChangeListener(myEditTextFocus);

        EditText hexEditText = (EditText) findViewById(R.id.hex_message);
        hexEditText.setOnFocusChangeListener(myEditTextFocus);
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

    private OnFocusChangeListener myEditTextFocus = new OnFocusChangeListener(){
        public void onFocusChange(View view, boolean gainFocus){
            if (gainFocus){
                int newFocus = getNewFocus(view);
                curFocus = newFocus;
            }
        };
        public int getNewFocus(View view){
            int id = view.getId();

            switch (id){
                case R.id.bin_message:
                    return 0;
                case R.id.dec_message:
                    return 1;
                case R.id.hex_message:
                    return 2;
                default:
                    return -1;
            }
        };
    };

    public void sendMessage(View view){

        if(curFocus == 0){
            convertFromBinary(view);
        }
        else if(curFocus == 1){
            convertFromDecimal(view);
        }
        else{
            convertFromHex(view);
        }
     /**
        switch (curFocus){
            case 0:
                convertFromBinary(view);
            case 1:
                convertFromDecimal(view);
            case 2:
                convertFromHex(view);
            default:
                clearMessage(view);
        }
      **/
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
        /**
        EditText et1 = (EditText) findViewById(R.id.hex_message);
        et1.setText("bin");
        EditText et2 = (EditText) findViewById(R.id.dec_message);
        et2.setText("bin");
        EditText et3 = (EditText) findViewById(R.id.bin_message);
        et3.setText("bin");
         **/
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
        /**
        EditText et1 = (EditText) findViewById(R.id.hex_message);
        et1.setText("hex");
        EditText et2 = (EditText) findViewById(R.id.dec_message);
        et2.setText("hex");
        EditText et3 = (EditText) findViewById(R.id.bin_message);
        et3.setText("hex");
         **/
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
