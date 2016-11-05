package com.android.weatherapp;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new WeatherFragment()).commit();
        }
    }

    @Override

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
         if (id == R.id.change_city){
             showInputDialog();
         }
        return false;
    }
    private void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change City");
        final EditText input = new EditText(this);
        input.setText(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                changeCity(input.getText().toString());
            }
        });
    builder.show();
    }
    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        wf.changeCity(city);
        new CityPreference(this).setCity(city);
        }
    }

