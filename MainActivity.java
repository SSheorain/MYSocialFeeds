package com.example.sheoran.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    dbHandler DBHandler;
    EditText lnuname,lnpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lnuname=(EditText)findViewById(R.id.lnuname);
        lnpassword=(EditText)findViewById(R.id.lnpassword);
        DBHandler =new dbHandler(this,null,null,1);
    }

    public void LoginClicked(View view)
    {
       Details_Database obj=new Details_Database(lnuname.getText().toString(),lnpassword.getText().toString());
       int res=DBHandler.CheckRecord(obj);
        if(res==1)
        {
            Intent k=new Intent(this,FirstPage.class);
            startActivity(k);
                }
      else
        {
            Toast msg=Toast.makeText(getApplicationContext(),"SINGUP FIRST",Toast.LENGTH_LONG);
            msg.show();
        }
    }

    public void SignupClicked(View view)
    {
        Intent i=new Intent(this,SINGUP.class);
        startActivity(i);
    }
}
