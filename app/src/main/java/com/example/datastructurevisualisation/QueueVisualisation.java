package com.example.datastructurevisualisation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

/**
 * QueueVisualisation class creates a Queue visualisation. Allowing the user to
 * call standard Queue methods via a GUI
 * to understand how they work.
 *
 * @Author Nathan Brown
 * @Version 05/03/21
 */
public class QueueVisualisation extends AppCompatActivity implements View.OnClickListener {

    private int front;
    private int rear;
    private int size;
    Button enqueue, dequeue, peek, clear;
    TextView val1, val2, val3, val4, val5, textFront, textRear, textSize;
    EditText editValue;
    TextView[] queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_visualisation);

        enqueue = findViewById(R.id.button_enqueue);
        dequeue = findViewById(R.id.button_dequeue);
        peek = findViewById(R.id.button_peek);
        clear = findViewById(R.id.button_clear);

        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        val3 = findViewById(R.id.val3);
        val4 = findViewById(R.id.val4);
        val5 = findViewById(R.id.val5);
        textFront = findViewById(R.id.textFront);
        textRear = findViewById(R.id.textRear);
        textSize = findViewById(R.id.textSize);

        editValue = findViewById(R.id.editValue);

        queue = new TextView[]{val1, val2, val3, val4, val5};

        enqueue.setOnClickListener(this);
        dequeue.setOnClickListener(this);
        peek.setOnClickListener(this);
        clear.setOnClickListener(this);

        this.setAttributes();



    }

    /**
     * Displays the queue attributes front rear and
     * size to be displayed by the TextViews in top left
     * of app screen(textFront, textRear, textSize)
     */
    public void setAttributes(){

        String front = String.valueOf(getFront());
        String rear = String.valueOf(getRear());
        String size = String.valueOf(getSize());
        textFront.setText(front);
        textRear.setText(rear);
        textSize.setText(size);
    }

    /**
     * Getter method for size.
     * @return number of elements currently in
     * the queue.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Getter method for front.
     * @return index of the queue front.
     */
    public int getFront() {
        return this.front;
    }
    /**
     * Getter method for rear.
     * @return index of the queue rear.
     */
    public int getRear() {
        return this.rear;
    }

    /**
     * Setter method for the queue size.
     * @param size The number of elements contained in
     *             the queue.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Setter method for the queue front.
     * @param front The index value of queue front.
     */
    public void setFront(int front) {
        this.front = front;
    }

    /**
     * Setter method for the queue rear.
     * @param rear The index value of queue rear.
     */
    public void setRear(int rear) {
        this.rear = rear;
    }

    /**
     * Checks if the queue is currently empty
     * @return Boolean value of whether the queue
     * is empty
     */
    public boolean isEmpty() {

        return (getSize()==0);
    }
    /**
     * Checks if the queue is currently full
     * @return Boolean value of whether the queue
     * is full
     */
    public boolean isFull() {

        return (getSize()==5);
    }

    /**
     * The on click method for the Onclicklistner implemented by MainActivity
     * class, implements a switch with a case to handle the event for
     * whichever of the buttons(Enqueue, Dequeue, Clear, Peek, Set)) was
     * clicked.
     * @param v the view which has been clicked by
     *          user (one of the 4 buttons).
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Adds user inputted value to rear of queue
            case R.id.button_enqueue:
                if ((editValue.getText().length()==0)) {

                    editValue.setError("Value must not be empty");

                } else if (!isFull()) {

                    (queue[getRear()]).setText(editValue.getText().toString());
                    setRear((getRear() + 1)%5);
                    setSize(getSize() + 1);
                    makeText(this, "True",
                            Toast.LENGTH_SHORT).show();

                } else {

                    makeText(this, "The queue is full!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Removes and returns element from front of queue
            case R.id.button_dequeue:
                if ((editValue.getText().length()==0)) {

                    editValue.setError("Value must not be empty");

                } else if (!isEmpty()) {

                    makeText(this, (queue[getFront()]).getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    queue[getFront()].setText("");

                    setFront((getFront() + 1)%5);
                    setSize(getSize() - 1);

                } else {

                    makeText(this, "The queue is empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Returns the front value from queue without removing
            case R.id.button_peek:
                if (!isEmpty()) {
                    makeText(this, (queue[getFront()]).getText().toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    makeText(this, "The queue is empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            // Clears all elements from the queue
            case R.id.button_clear:
                if (!isEmpty()) {
                    for (TextView val:queue) {
                        val.setText("");
                        setFront(0);
                        setRear(0);
                        setSize(0);
                    }
                } else {
                    makeText(this, "The queue is already empty!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        setAttributes();
    }
}