package com.example.reader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt_display_counter;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_display_counter =(TextView)findViewById(R.id.txt_display);
        LoadData();

    }

    public void btn_action(View view) {

        counter++;
        txt_display_counter.setText(String.valueOf(counter));

    }

    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putInt("counterValue",counter);
        editor.apply();
    }

    public void LoadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("saveCounter",MODE_PRIVATE);

        counter =sharedPreferences.getInt("counterValue",MODE_PRIVATE);
        txt_display_counter.setText(String.valueOf(counter));
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveData();
    }
}
