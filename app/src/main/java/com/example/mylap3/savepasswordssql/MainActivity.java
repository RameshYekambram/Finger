package com.example.mylap3.savepasswordssql;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button LoginExt,LoginNew;
    DataBaseHelpler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        db = new DataBaseHelpler( this);
        LoginExt = findViewById( R.id.LoginExt );
        LoginNew = findViewById( R.id.LoginNew );

        LoginNew.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NewUser = new Intent( MainActivity.this,Login.class );
                startActivity( NewUser );

            }
        } );

        LoginExt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res= db.getdata();

                if(res.getCount() == 1) {
                    Intent NewUser = new Intent( MainActivity.this, UserDetails.class );
                    startActivity( NewUser );
                    Toast.makeText( MainActivity.this,"Login Successful",Toast.LENGTH_LONG ).show();
                }else{
                    Intent NewUser = new Intent( MainActivity.this, Login.class );
                    startActivity( NewUser );
                    Toast.makeText( MainActivity.this,"Please Login",Toast.LENGTH_LONG ).show();
                }


            }
        } );
    }
}
