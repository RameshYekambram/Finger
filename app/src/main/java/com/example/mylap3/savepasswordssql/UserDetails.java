package com.example.mylap3.savepasswordssql;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserDetails extends AppCompatActivity {

    DataBaseHelpler mydb;
    public TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user_details );
        mydb = new DataBaseHelpler( this );

        user = (TextView) findViewById( R.id.User );
        user.setVisibility( View.GONE );

        Userdata();
    }

    private void Userdata() {

        Cursor res= mydb.getdata();
        //Integer Count= res.getCount();

        if(res.moveToFirst()){
            do {
                String UserName= res.getString( 1 );

                user.setText( UserName );
                user.setVisibility( View.VISIBLE );

            }while (res.moveToNext());
        }
        //Toast.makeText( UserDetails.this,,Toast.LENGTH_LONG ).show();
    }
}
