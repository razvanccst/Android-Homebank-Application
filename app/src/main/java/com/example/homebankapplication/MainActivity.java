package com.example.homebankapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private Button mCreateAccount;
    private TextView mError;

    public static Customer currentCustomer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Customer user1 = new Customer("user","pass");
        Customer user2 = new Customer("user2","pass");


        final Homebank homebank = new Homebank();
        homebank.addCustomer(user1);
        homebank.addCustomer(user2);
        homebank.getCredentials().put(user1.getUsername(),user1.getPassword());
        homebank.getCredentials().put(user2.getUsername(),user2.getPassword());

        mUsername = (EditText) findViewById(R.id.etUsername);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mLogin = (Button) findViewById(R.id.loginButton);
        mCreateAccount = (Button) findViewById(R.id.create_account_button);
        mError = (TextView) findViewById(R.id.tv_login_error);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

               if(homebank.getCredentials().containsKey(username)) {
                   if(homebank.getCredentials().get(username).equals(password)){
                        currentCustomer = homebank.login(username,password);

                       mError.setText("Login succesfull");
                   }else{
                       mError.setText("Incorrect password, please try again.");
                   }
               }else{
                   mError.setText("Username does not exist, please create an account.");
               }
            }
        });

    }









}
