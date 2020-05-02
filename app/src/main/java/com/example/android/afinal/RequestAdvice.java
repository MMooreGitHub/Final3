package com.example.android.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RequestAdvice extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userReference;

    EditText nameField;
    EditText issueField;
    EditText goalField;
    EditText descriptionField;
    RadioGroup radgroup;
    String gender="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_advice);

        nameField = (EditText) findViewById(R.id.name_edit_field);
        issueField = (EditText) findViewById(R.id.issue_edit_field);
        goalField =(EditText) findViewById(R.id.goal_edit_field);
        descriptionField = (EditText) findViewById(R.id.description_edit_field);
        radgroup = (RadioGroup)findViewById(R.id.radioGroup);

        userReference = database.getReference("TrainingAdvice");

        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton r = (RadioButton)findViewById(checkedId);
                gender = r.getText().toString();
            }
        });
    }


    public void sendToFirebase(View view) {
        String name = nameField.getText().toString();
        String issue = issueField.getText().toString();
        String goal = goalField.getText().toString();
        String description = descriptionField.getText().toString();
        CoachAdvice coachAdvice = new CoachAdvice(name,issue,goal,description,gender);
        userReference.push().setValue(coachAdvice);
        Toast.makeText(RequestAdvice.this,"Submission Successful!", Toast.LENGTH_SHORT).show();
        nameField.getText().clear();
        issueField.getText().clear();
        goalField.getText().clear();
        descriptionField.getText().clear();
    }
}
