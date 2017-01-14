package com.example.sheoran.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class SINGUP extends AppCompatActivity {

    EditText uname,email,password,confirm_password;
    CheckBox checkBox;
    dbHandler DBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        uname=(EditText) findViewById(R.id.uname);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.pass);
        confirm_password=(EditText) findViewById(R.id.confirm_pass);
        checkBox=(CheckBox) findViewById(R.id.checkBox);
        DBHandler =new dbHandler(this,null,null,1);

    }

    public void SignupClickedBack(View view)
    {
     if(checkBox.isChecked()) {
      if(confirm_password.getText().toString().equals(password.getText().toString())) {
               Details_Database obj = new Details_Database(confirm_password.getText().toString(), email.getText().toString(), password.getText().toString(), uname.getText().toString());
                DBHandler.AddRecord(obj);
                Intent p = new Intent(this, MainActivity.class);
                startActivity(p);
           }
     }
    }
}
