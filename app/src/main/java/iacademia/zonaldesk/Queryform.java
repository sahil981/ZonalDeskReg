package iacademia.zonaldesk;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Queryform extends AppCompatActivity {
    EditText name;
    EditText no;
    EditText address;
    EditText pincode;
    EditText query;
    Button submit;
    DatabaseReference db;
    String user_name;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queryform);
        name= (EditText) findViewById(R.id.persone_name);
        no= (EditText) findViewById(R.id.field_phone_number);
        address= (EditText) findViewById(R.id.address);
        pincode= (EditText) findViewById(R.id.pincode);
        query= (EditText) findViewById(R.id.edit_query);
        submit= (Button) findViewById(R.id.query_submit);
        sharedPreferences=getSharedPreferences("u_n",MODE_PRIVATE);
        user_name=sharedPreferences.getString("username",null);
        db= FirebaseDatabase.getInstance().getReference("query");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });



    }
    public void add(){
        final String n=name.getText().toString().trim();
        final String number=no.getText().toString().trim();
        final String addr=address.getText().toString().trim();
        final String pin=pincode.getText().toString().trim();
        final String q=query.getText().toString().trim();
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_name)){

                    long r=dataSnapshot.getChildrenCount()+1;
                    existadd(r,n,number,addr,pin,q);

                }
                else {
                    adddata(n,number,addr,pin,q);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void adddata(String n, String number, String addr, String pin, String query) {
        queryadddb q=new queryadddb(user_name,n,number,addr,pin,query);
        db.child(user_name).child("1").setValue(q);
        


    }

    private void existadd(long r, String n, String number, String addr, String pin, String query) {
        queryadddb q=new queryadddb(user_name,n,number,addr,pin,query);
        db.child(user_name).child(""+r).setValue(q);

    }

}
