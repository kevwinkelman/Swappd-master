package com.swappd.android;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.button;

public class RegisterActivity extends AppCompatActivity {

    private Button registerBtn;

    private EditText emailField;
    private EditText passwordField;
    private EditText repeatPasswordField;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = (Button) findViewById(R.id.registerButton);

        emailField = (EditText) findViewById(R.id.emailField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        repeatPasswordField = (EditText) findViewById(R.id.confPassField);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailValidator(emailField) &&
                    passwordValidator(passwordField.getText().toString(), repeatPasswordField.getText().toString())) {

                } else {

                }
            }
        });

    }

    public static boolean emailValidator(EditText emailField) {
        String emailStr = emailField.getText().toString();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        if (matcher.find()) {
            // Check if from cpp.edu
            if (emailStr.split("@")[1].toUpperCase().equals("CPP.EDU")) {
                return true;
            }
        }
        emailField.setBackgroundColor(Color.RED);
        return false;
    }

    private static boolean passwordValidator(String password, String repeatPassword) {
        if (password.equals(repeatPassword)) {
            return true;
        }
        return false;
    }
}
