package com.example.bottom_sheet;

import android.os.Bundle;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout layout1, layout2, layout3;
    BottomSheetDialog bottomSheetDialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.text);
        createBottomSheet();
    }

    public void createBottomSheet(){
        if(bottomSheetDialog == null){
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null);
            layout1 = view.findViewById(R.id.layout1);
            layout2 = view.findViewById(R.id.layout2);
            layout3 = view.findViewById(R.id.layout3);

            layout1.setOnClickListener(this);
            layout2.setOnClickListener(this);
            layout3.setOnClickListener(this);

            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(view);
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

    public void showDialog(View view) {
        bottomSheetDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout1:
                bottomSheetDialog.dismiss();
                textView.setText("Clicked card 1");
                break;
            case R.id.layout2:
                bottomSheetDialog.dismiss();
                textView.setText("Clicked card 2");
                break;
            case R.id.layout3:
                bottomSheetDialog.dismiss();
                textView.setText("Clicked card 3");
                break;
        }
    }
}
