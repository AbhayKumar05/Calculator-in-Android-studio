package com.example.mycalendra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonadd, buttonsub, buttonmult, buttondiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd = findViewById(R.id.btn_add);
        buttonsub = findViewById(R.id.btn_sub);
        buttonmult = findViewById(R.id.btn_mult);
        buttondiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonadd.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttonmult.setOnClickListener(this);
        buttondiv.setOnClickListener(this);

    }

    public int getInFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            // Corrected the toast syntax
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }


    @Override
    public void onClick(View view) {
        num1 = getInFromEditText(editTextN1);
        num2 = getInFromEditText(editTextN2);

        String operation = view.getTag().toString(); // Retrieve the operation from the clicked button's tag

        switch (operation) {
            case "add":
                textView.setText("Answer = " + (num1 + num2));
                break;

            case "sub":
                textView.setText("Answer = " + (num1 - num2));
                break;

            case "mult":
                textView.setText("Answer = " + (num1 * num2));
                break;

            case "div":
                if (num2 != 0) {
                    textView.setText("Answer = " + ((float) num1 / num2));
                } else {
                    textView.setText("Answer = Infinity");
                }
                break;
        }
    }
}
    // This is the orignal code from the video but it had some errors.
/*   @Override
    public void onClick(View view) {
        num1 = getInFromEditText(editTextN1);
        num2 = getInFromEditText(editTextN2);
        switch (view.getId()){
            case R.id.btn_add:
                textview.setText("Answer = " + (num1 + num2));
                break;

            case R.id.btn_sub:
                textview.setText("Answer = " + (num1 - num2));
                break;

            case R.id.btn_mult:
                textview.setText("Answer = " + (num1 * num2));
                break;

            case R.id.btn_div:
                if (num2 != 0) {
                    textview.setText("Answer = " + ((float) num1 / (float) num2));
                } else {
                    textview.setText("Answer = Infinity"); // or any other appropriate message
                }
                break;

        }
        // if (editTextN1.getText().toString().equals("")){
        //    Toast.makeText(context this, text "Enter Number", Toast.LENGTH_SHORT.show());
    }
}
*/
