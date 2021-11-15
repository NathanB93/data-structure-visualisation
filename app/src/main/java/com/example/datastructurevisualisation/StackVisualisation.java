package com.example.datastructurevisualisation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class StackVisualisation extends AppCompatActivity implements View.OnClickListener {

    private int size;
    private int top = -1;
    Button push, pop, peek, clear;
    TextView val1, val2, val3, val4, val5, textTop, textSize;
    EditText editValue;
    TextView[] stack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_visualisation);


        push = findViewById(R.id.button_push);
        pop = findViewById(R.id.button_pop);
        peek = findViewById(R.id.button_peek_stack);
        clear = findViewById(R.id.button_clear_stack);

        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        val3 = findViewById(R.id.val3);
        val4 = findViewById(R.id.val4);
        val5 = findViewById(R.id.val5);

        textTop = findViewById(R.id.textTop);
        textSize = findViewById(R.id.textSize);

        editValue = findViewById(R.id.editValue);

        push.setOnClickListener(this);
        pop.setOnClickListener(this);
        peek.setOnClickListener(this);
        clear.setOnClickListener(this);

        stack = new TextView[]{val1, val2, val3, val4, val5};

        setTextTop();
        setTextSize();



    }

    /**
     * Getter method for stack size.
     * @return the number of elements in the stack.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Getter method for the top of stack.
     * @return The index of top element in stack.
     */
    public int getTop() {
        return this.top;
    }

    /**
     * Setter method for the stack size.
     * @param size The number of elements in stack.
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * Setter method for the stack size
     * @param top The index of top element in stack.
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Setter method for displaying stack top
     * in upper left corner of app screen
     */
    public void setTextTop() {
        String top = String.valueOf(getTop());
        this.textTop.setText(top);
    }
    /**
     * Setter method for displaying stack size
     * in upper left corner of app screen
     */
    public void setTextSize() {
        String size = String.valueOf(getSize());
        this.textSize.setText(size);
    }

    /**
     * Checks if the stack is empty.
     * @return Boolean value of whether or not stack
     * is empty.
     */
    public boolean isEmpty() {

        return top < 0;
    }
    /**
     * Checks if the stack is full.
     * @return Boolean value of whether or not stack
     * is full.
     */
    public boolean isFull() {

        return size > 4;
    }
    /**
     * The on click method for the Onclicklistner implemented by MainActivity
     * class, implements a switch with a case to handle the event for
     * whichever of the buttons(Push, Pop, Peek and Clear)) was
     * clicked.
     * @param v the view which has been clicked by
     *          user (one of the 4 buttons).
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Adds user inputted value to the top of stack
            case R.id.button_push:
                if (editValue.getText().length()== 0){
                    editValue.setError("Value must contain at least one character");
                }
                else if(!isFull()) {
                    (stack[getSize()]).setText(editValue.getText().toString());
                    setSize(getSize() + 1);
                    setTop(getTop() + 1);
                } else {
                    makeText(this, "The stack is full!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Removes and returns the top element from the stack
            case R.id.button_pop:
                if (editValue.getText().length()== 0) {
                    editValue.setError("Value must contain at least one character");
                } else if (isEmpty()){
                    makeText(this, "The stack is empty!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    makeText(this, ((stack[getTop()]).getText().toString()),
                            Toast.LENGTH_SHORT).show();
                    stack[getTop()].setText("");
                    setSize(getSize() - 1);
                    setTop(getTop() - 1);
                }
                break;
            // Returns the top element of stack without removing it
            case R.id.button_peek_stack:
                if (!isEmpty()){
                    makeText(this, (stack[getTop()].getText().toString()),
                            Toast.LENGTH_SHORT).show();
                } else {
                    makeText(this, "Stack is empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Clears all elements fromm the stack
            case R.id.button_clear_stack:
                if (!isEmpty()) {
                    for(TextView val:stack) {
                        val.setText("");
                    }
                    setTop(-1);
                    setSize(0);

                } else {
                    makeText(this, "Stack is already empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        setTextTop();
        setTextSize();
    }
}