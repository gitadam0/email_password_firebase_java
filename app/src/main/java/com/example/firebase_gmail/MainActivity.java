package com.example.firebase_gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView email;
    Button logout;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        email=findViewById(R.id.email_user);
        logout=findViewById(R.id.logout);


        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser==null){
            Intent intent=new Intent(MainActivity.this,login.class);
            startActivity(intent);
            finish();
        }

        Toast.makeText(this, currentUser.getEmail().toString(), Toast.LENGTH_SHORT).show();
//        String e=getIntent().getStringExtra("e");

        email.setText(currentUser.getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}