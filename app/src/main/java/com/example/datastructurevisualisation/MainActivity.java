package com.example.datastructurevisualisation;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button stack = (Button)findViewById(R.id.button_stack);
        Button queue = (Button)findViewById(R.id.button_queue);
        Button arrayList = (Button)findViewById(R.id.button_array_list);

        stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StackVisualisation.class));
            }
        });

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QueueVisualisation.class));
            }
        });

        arrayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArrayListVisualisation.class));
            }
        });


    }

}