package com.ovais.office.materialdesigndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fromLogin(View view) {

        Intent intent = new Intent(this, Activity02.class);
        TextInputEditText name, password;
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        intent.putExtra("name", name.getText().toString());
        intent.putExtra("pass", password.getText().toString());
        startActivity(intent);
    }
}
