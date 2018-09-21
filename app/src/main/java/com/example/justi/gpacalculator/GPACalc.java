package com.example.justi.gpacalculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GPACalc extends AppCompatActivity {

    TextView GradeDisplay;
    EditText GradeOne;
    EditText GradeTwo;
    EditText GradeThree;
    EditText GradeFour;
    EditText GradeFive;
    Button CalculateButton;
    ConstraintLayout CurrentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalc);

        GradeDisplay=(TextView) findViewById(R.id.tvC6);
        GradeOne=(EditText) findViewById(R.id.ed1);
        GradeTwo=(EditText) findViewById(R.id.ed2);
        GradeThree=(EditText) findViewById(R.id.ed3);
        GradeFour=(EditText) findViewById(R.id.ed4);
        GradeFive=(EditText) findViewById(R.id.ed5);
        CalculateButton=(Button) findViewById(R.id.btCalculate);
        CurrentLayout=(ConstraintLayout) findViewById(R.id.applayout);
    }
    private boolean doubleCheck(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException n) {
            return false;
        }

    }
    private boolean inputCheck(EditText Grade){
        if(doubleCheck(Grade.getText().toString().trim())){
            return true;
        }else{
            Grade.setText("");
            Grade.setHint("Please enter a valid number");
            Grade.setHintTextColor(getResources().getColor(R.color.colorError));
            return false;
        }
    }

    public void calculate(View view) {
        if (CalculateButton.getText().toString().equals("Compute GPA")){
            if (inputCheck(GradeOne) && inputCheck(GradeTwo) && inputCheck(GradeThree) && inputCheck(GradeFour) && inputCheck(GradeFive)) {
                double GPA = (Double.parseDouble(GradeOne.getText().toString().trim()) + Double.parseDouble(GradeTwo.getText().toString().trim())
                        + Double.parseDouble(GradeThree.getText().toString().trim()) + Double.parseDouble(GradeFour.getText().toString().trim())
                        + Double.parseDouble(GradeFive.getText().toString().trim())) / 5.0;
                GradeDisplay.setText("Your GPA is " + GPA);
                CalculateButton.setText("Clear Form");
                if (GPA > 80.0) {
                    CurrentLayout.setBackgroundColor(getResources().getColor(R.color.Green));

                } else if (GPA > 60.0) {
                    CurrentLayout.setBackgroundColor(getResources().getColor(R.color.Yellow));
                } else {
                    CurrentLayout.setBackgroundColor(getResources().getColor(R.color.Red));
                }
            } else {
                GradeDisplay.setText("Invalid Input, Please input correct values");
            }
        }else{
            GradeOne.setHint("Enter grade for course one");
            GradeOne.setText("");
            GradeOne.setHintTextColor(getResources().getColor(R.color.hintColor));
            GradeTwo.setHint("Enter grade for course two");
            GradeTwo.setText("");
            GradeTwo.setHintTextColor(getResources().getColor(R.color.hintColor));
            GradeThree.setHint("Enter grade for course three");
            GradeThree.setText("");
            GradeThree.setHintTextColor(getResources().getColor(R.color.hintColor));
            GradeFour.setHint("Enter grade for course four");
            GradeFour.setText("");
            GradeFour.setHintTextColor(getResources().getColor(R.color.hintColor));
            GradeFive.setHint("Enter grade for course five");
            GradeFive.setText("");
            GradeFive.setHintTextColor(getResources().getColor(R.color.hintColor));
            CalculateButton.setText("Compute GPA");
            GradeDisplay.setText("Your grade will appear here!");
            CurrentLayout.setBackgroundColor(getResources().getColor(R.color.White));
        }
    }

}
