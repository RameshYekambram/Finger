package com.example.mylap3.savepasswordssql;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DataBaseHelpler db;
    public static EditText Name,Password;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        db = new DataBaseHelpler( this );
        Name = (EditText) findViewById( R.id.name );
        Password = (EditText) findViewById( R.id.password );
        login = (Button) findViewById( R.id.login );

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor delete=db.getdata();
                if (delete.moveToFirst()){
                    do {
                        String id =delete.getString( 0 );
                        db.delete( id );
                    }while (delete.moveToNext());
                }
                String user = Name.getText().toString();
                boolean inserted = db.insert( Name.getText().toString() );

                if (inserted == true) {

                    Intent activity = new Intent( Login.this, UserDetails.class );
                    startActivity( activity );
                    Toast.makeText( Login.this, "User Login Successful", Toast.LENGTH_LONG ).show();
                }else{
                    Toast.makeText( Login.this, "User Login UnSuccessful", Toast.LENGTH_LONG ).show();
                }
            }
        } );

    }
}
