package com.example.grocerydeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();



    }

    public void showShops_OnClick(View view) {
        Intent intent = new Intent(MainActivity.this, LocalShopsActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        mAuth.signOut();

        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, LoginRegisterActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Logging out failed!", Toast.LENGTH_SHORT).show();
        }
    }
}