package com.example.datastructurevisualisation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

/**
 * MainActivity class creates an ArrayList visualisation. Allowing the user to
 * call standard ArrayList methods via a GUI
 * to understand how they work.
 *
 * @Author Nathan Brown
 * @Version 05/03/21
 */
public class ArrayListVisualisation extends AppCompatActivity implements View.OnClickListener {


    Button remove, add, get, size, set, clear;
    TextView val1, val2, val3, val4, val5, val6, val7, val8, val9, val10;
    EditText editValue, editIndex;

    //Holds GUI TextViews for easy manipulation
    TextView[] values;

    //ArrayList to be visualised
    ArrayList<String> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list_visualisation);

        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        val3 = findViewById(R.id.val3);
        val4 = findViewById(R.id.val4);
        val5 = findViewById(R.id.val5);
        val6 = findViewById(R.id.val6);
        val7 = findViewById(R.id.val7);
        val8 = findViewById(R.id.val8);
        val9 = findViewById(R.id.val9);
        val10 = findViewById(R.id.val10);

        remove = findViewById(R.id.button_remove);
        add = findViewById(R.id.button_add);
        get = findViewById(R.id.button_get);
        size = findViewById(R.id.button_size_array);
        set = findViewById(R.id.button_set);
        clear = findViewById(R.id.button_clear_array);

        editValue = findViewById(R.id.editValue);
        editIndex = findViewById(R.id.editIndex);

        values = new TextView[]{val1, val2, val3, val4, val5, val6, val7, val8, val9, val10};


        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        get.setOnClickListener(this);
        set.setOnClickListener(this);
        size.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    /**
     * Gets the size of the visualised ArrayList.
     * @return number of elements in array.
     */
    public int size() {

        return this.array.size();
    }

    /**
     * Clears all the values of the ArrayList visualisation
     * then updates them to the current array values.
     */
    public void updateValues() {

        for(TextView val:values) {
            val.setText("");
        }
        int count = 0;
        while(count < size()) {
            values[count].setText(array.get(count));
            count++;
        }
    }


    /**
     * Gets the user inputted index value and casts it to an
     * integer.
     * @return user inputted index value as integer.
     */
    public int getIndex() {

        int index = Integer.parseInt(editIndex.getText().toString());
        return index;

    }


    /**
     * The on click method for the Onclicklistner implemented by this
     * class, implements a switch with a case to handle the event for
     * whichever of the buttons(Add, Remove, Size, Clear, Get, Set)) was
     * clicked.
     * @param v the view which has been clicked by
     *          user (one of the 6 buttons).
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            // Adds user inputted value
            case R.id.button_add:
                if ((editValue.getText().length()==0)) {
                    editValue.setError("Value cannot be empty");
                }
                else if(array.size() < 10) {
                    array.add(editValue.getText().toString());
                }
                break;
            // Removes the value from a user inputted index
            case R.id.button_remove:
                if ((editIndex.getText().length()==0)) {
                    editIndex.setError("Index cannot be empty");
                }
                else if ((-1 < getIndex()) & (getIndex() < size())){
                    array.remove(getIndex());
                } else {

                    makeText(this, "Index does not exist",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            //Returns the value at user inputted index without
            // removing from array
            case R.id.button_get:
                if ((editIndex.getText().length()==0)) {

                    editIndex.setError("Index cannot be empty");

                } else if ((-1 < getIndex()) & (getIndex() < size())){

                    makeText(this, values[getIndex()].getText().toString(),
                            Toast.LENGTH_SHORT).show();

                } else{
                    makeText(this, "Index does not exist",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            //Sets given array index to user inputted value
            case R.id.button_set:
                if ((editIndex.getText().length()==0)) {

                    editIndex.setError("Index cannot be empty");

                } else if ((editValue.getText().length()==0)) {

                    editValue.setError("Value cannot be empty");

                } else if ((-1 < getIndex()) & (getIndex() < size())) {

                    array.set(getIndex(), (editValue.getText().toString()));

                } else {
                    makeText(this, "Index does not exist",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Displays the ArrayList size
            case R.id.button_size_array:
                makeText(this, ("Size: " + size()),
                        Toast.LENGTH_SHORT).show();
                break;
            // Clears the ArrayList and the visualisation
            case R.id.button_clear_array:
                if (!(size()==0)) {
                    array.clear();
                } else{
                    makeText(this, "The array is already empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        updateValues();

    }
}