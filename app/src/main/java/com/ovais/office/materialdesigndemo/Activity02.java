package com.ovais.office.materialdesigndemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Activity02 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.menu);
        DrawerLayout drawerLayout = findViewById(R.id.myDrawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.Nav_View_Open,
                R.string.Nav_View_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void headsetClicked(View view) {
        Snackbar snackbar = Snackbar.make(view, "Headset Clicked", Snackbar.LENGTH_LONG);
        snackbar.setDuration(3000);
        snackbar.setAction("Go Back", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent intent = new Intent(Activity02.this, MainActivity.class);
                startActivity(intent);
            }
        });
        snackbar.show();

    }

    public void radioClicked(View view) {
        Snackbar snackbar = Snackbar.make(view, "Radio Clicked", Snackbar.LENGTH_LONG);
        snackbar.show();
        snackbar.setAction("Click to go back", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity02.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void getUsersData(View view) {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("pass");
        Snackbar userData = Snackbar.make(view, "User Details Are: Name:" + name + " Password: " + password, Snackbar.LENGTH_LONG);
        userData.setDuration(6000);
        userData.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
        userData.show();

    }

    public void setActionOnFloatingButton(final View view) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this)
                .setTitle("Alert Dialog")
                .setPositiveButton("Start Snack Bar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar snackbar = Snackbar.make(view, "This is a snackbar", 2000);
                        snackbar.show();
                    }
                })
                .setNegativeButton("Dismiss", null)
                .setMessage("Floating Button Clicked!!!");

        builder.show();

    }

    public void nextActivity(View view) {
        Intent intent = new Intent(Activity02.this, Activity03.class);
        startActivity(intent);
    }
}
