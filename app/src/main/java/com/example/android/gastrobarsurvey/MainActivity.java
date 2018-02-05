package com.example.android.gastrobarsurvey;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isFirstTimeCustomer = false;
    boolean checked_q1 = false;
    boolean frequent_customer = false;
    boolean checked_q2 = false;
    boolean checked_q3 = false;
    boolean spinner_check = false;
    String customerName = "";
    String other_visit_frequency = "";
    String waiter1 = "";
    String waiter2 = "";
    String fav_bev_type = "";
    String favorite_beverage = "";
    boolean recommendFriend = false;
    boolean recommendFamily = false;
    boolean recommendCoworker = false;
    boolean recommendNoOne = false;
    boolean recommendOther = false;
    String other_recommendations = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.welcome_activity);

    }

    /**
     * The methods called when the button "Proceed" is pressed
     */

    public void beginTheSurvey(View view) {
        setContentView (R.layout.first_surveyactivity);

    }

    /**
     * the methods called when the button "Next" is pressed for passing from the first_surveyActivity to the second_surveyActivity
     */
    public void SurveySecond(View view) {


        // Get user's name
        EditText nameField = (EditText) findViewById (R.id.customer_name);
        Editable nameEditable = nameField.getText ();
        customerName = nameEditable.toString ();


        // Figure out if the user is first time here
        CheckBox FirstTimeCustomer_CheckBox = (CheckBox) findViewById (R.id.checkbox_first_time);
        isFirstTimeCustomer = FirstTimeCustomer_CheckBox.isChecked ();


        if (customerName.matches ("")) {
            Toast.makeText (this, R.string.name_insert, Toast.LENGTH_SHORT).show ();
        } else {

            if (isFirstTimeCustomer)
                setContentView (R.layout.third_surveyactivity);

            else
                setContentView (R.layout.second_surveyactivity);
        }
    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the first_surveyActivity to the welcome_Activity
     */
    public void backToWelcome(View view) {
        setContentView (R.layout.welcome_activity);

    }

    /**
     * The method is called when you press the Radio Buttons on second_surveyactivity.
     */

    public void check_q1(View view) {
        // Is the button now checked?
        checked_q1 = ((RadioButton) view).isChecked ();

        // Check which radio button was clicked
        switch (view.getId ()) {
            case R.id.optionA_q1:
                if (checked_q1)
                    frequent_customer = true;
                break;
            case (R.id.optionB_q1):
                if (checked_q1)
                    frequent_customer = true;
                break;

        }
    }

    /**
     * the methods called when the button "Next" is pressed for passing from the second_surveyActivity to the third_surveyActivity
     */
    public void surveyThird(View view) {
        // Get user's addition for visit_frequency
        EditText nameField = (EditText) findViewById (R.id.customer_comment_howOften);
        Editable nameEditable = nameField.getText ();
        other_visit_frequency = nameEditable.toString ();

        if (checked_q1)
            setContentView (R.layout.third_surveyactivity);
        else
            Toast.makeText (this, R.string.if_no_action, Toast.LENGTH_SHORT).show ();

    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the second_surveyActivity to the first_surveyActivity
     */
    public void backToFirst(View view) {
        setContentView (R.layout.first_surveyactivity);

    }

    /**
     * The method is called when you press the Radio Buttons on third_surveyactivity.
     */

    /* RadioGroup group_q2*/
    public void check_q2(View view) {
        // Is the button now checked?
        checked_q2 = ((RadioButton) view).isChecked ();

        // Check which radio button was clicked
        switch (view.getId ()) {
            case R.id.optionA_q2:
                if (checked_q2)
                    waiter1 = getString (R.string.ans1_q2);
                break;
            case (R.id.optionB_q2):
                if (checked_q2)
                    waiter1 = getString (R.string.ans2_q2);
                break;
            case (R.id.optionC_q2):
                if (checked_q2)
                    waiter1 = getString (R.string.ans3_q2);
                break;

        }
    }


    /* RadioGroup group_q2*/
    public void check_q3(View view) {
        // Is the button now checked?
        checked_q3 = ((RadioButton) view).isChecked ();

        // Check which radio button was clicked
        switch (view.getId ()) {
            case R.id.optionA_q3:
                if (checked_q3)
                    waiter2 = getString (R.string.ans1_q2);
                break;
            case (R.id.optionB_q3):
                if (checked_q3)
                    waiter2 = getString (R.string.ans2_q2);
                break;
            case (R.id.optionC_q2):
                if (checked_q3)
                    waiter2 = getString (R.string.ans3_q2);
                break;

        }
    }

    /**
     * the methods called when the button "Next" is pressed for passing from the third_surveyActivity to the forth_surveyActivity
     */
    public void surveyForth(View view) {
        if ((checked_q2) && (checked_q3)) {
            setContentView (R.layout.forth_surveyactivity);

            Spinner spinnerBev = (Spinner) findViewById (R.id.bev_spinner);


            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource (this,
                    R.array.allBev_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
            spinnerBev.setAdapter (adapter);


        } else
            Toast.makeText (this, R.string.if_no_action, Toast.LENGTH_SHORT).show ();

    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the third_surveyActivity to the second_surveyActivity
     * For the FirstTimeCustomer it is from the third_surveyActivity to first_surveyActivity
     */
    public void backToSecond(View view) {
        if (isFirstTimeCustomer)
            setContentView (R.layout.first_surveyactivity);
        else
            setContentView (R.layout.second_surveyactivity);

    }

    /**
     * the methods called when the button "Next" is pressed for passing from the forth_surveyActivity to the fifth_surveyActivity
     */
    public void surveyFifth(View view) {

        // Get favorite beverage's name
        EditText nameField = (EditText) findViewById (R.id.favorite_bev);
        Editable nameEditable = nameField.getText ();
        favorite_beverage = nameEditable.toString ();


        Spinner spinnerBev = (Spinner) findViewById (R.id.bev_spinner);
        fav_bev_type = spinnerBev.getSelectedItem ().toString ();

        if ((fav_bev_type.matches (getString (R.string.pleaseChooseString))))
            Toast.makeText (this, R.string.if_no_action, Toast.LENGTH_SHORT).show ();
        else
            setContentView (R.layout.fifth_surveyactivity);


    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the forth_surveyActivity to the third_surveyActivity
     */
    public void backToThird(View view) {
        setContentView (R.layout.third_surveyactivity);
        checked_q2 = false;
        checked_q3 = false;

    }

    /**
     * the methods called when the button "Next" is pressed for passing from the fifth_surveyActivity to the last_surveyActivity
     */
    public void surveyLast(View view) {

        // Recommendations checkboxes

        CheckBox rec1_CheckBox = (CheckBox) findViewById (R.id.ans1_q5);
        recommendFriend = rec1_CheckBox.isChecked ();


        CheckBox rec2_CheckBox = (CheckBox) findViewById (R.id.ans2_q5);
        recommendFamily = rec2_CheckBox.isChecked ();


        CheckBox rec3_CheckBox = (CheckBox) findViewById (R.id.ans3_q5);
        recommendCoworker = rec3_CheckBox.isChecked ();


        CheckBox rec4_CheckBox = (CheckBox) findViewById (R.id.ans4_q5);
        recommendNoOne = rec4_CheckBox.isChecked ();


        CheckBox rec5_CheckBox = (CheckBox) findViewById (R.id.ans5_q5);
        recommendOther = rec5_CheckBox.isChecked ();


        // Get additional information regarding other recommendations

        EditText nameField = (EditText) findViewById (R.id.other_recommendations);
        Editable nameEditable = nameField.getText ();
        other_recommendations = nameEditable.toString ();

        //If one of the boxes is checked - to to the next activity

        if (recommendFriend || recommendFamily || recommendCoworker || recommendNoOne || recommendOther) {
            setContentView (R.layout.last_surveyactivity);

        } else
            Toast.makeText (this, R.string.if_no_action, Toast.LENGTH_SHORT).show ();

    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the fifth_surveyActivity to the forth_surveyActivity
     */
    public void backToForth(View view) {
        setContentView (R.layout.forth_surveyactivity);
        spinner_check = false;

        Spinner spinnerBev = (Spinner) findViewById (R.id.bev_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource (this,
                R.array.allBev_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerBev.setAdapter (adapter);

    }


    /**
     * the methods called when the button "Next" is pressed for passing from the last_surveyActivity to the final_greeting
     */
    public void surveyFinal(View view) {
        boolean trial_check = true;
        if (trial_check) {
            setContentView (R.layout.final_greeting);
        } else
            Toast.makeText (this, R.string.if_no_action, Toast.LENGTH_SHORT).show ();

    }

    /**
     * The method is called when the button "Previous" is pressed for passing from the last_surveyActivity to the fifth_surveyActivity
     */
    public void backToFifth(View view) {
        setContentView (R.layout.fifth_surveyactivity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void mail_submission(View view) {

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData (Uri.parse ("mailto:roodenko@gmail.com"));
        intent.putExtra (Intent.EXTRA_SUBJECT, "Gastrobar+1 Survey results for " + customerName);
        intent.putExtra (Intent.EXTRA_TEXT, final_text ());

        if (intent.resolveActivity (getPackageManager ()) != null) {
            startActivity (intent);
        }
    }

    private String final_text() {
        String finalSurveySummary = getString (R.string.mail_header);
        finalSurveySummary += getString (R.string.summary1) + customerName;
        finalSurveySummary += getString (R.string.summary2) + isFirstTimeCustomer;
        finalSurveySummary += getString (R.string.summary3) + frequent_customer;
        finalSurveySummary += getString (R.string.summary4) + other_visit_frequency;
        finalSurveySummary += getString (R.string.summary5) + waiter1;
        finalSurveySummary += getString (R.string.summary6) + waiter2;
        finalSurveySummary += getString (R.string.summary7) + fav_bev_type;
        finalSurveySummary += getString (R.string.summary8) + favorite_beverage;
        finalSurveySummary += getString (R.string.summary9) + recommendFriend + "," + recommendFamily + "," + recommendCoworker + "," + recommendNoOne + "," + recommendOther;
        finalSurveySummary += getString (R.string.summary10) + other_recommendations;

        return finalSurveySummary;
    }
}
