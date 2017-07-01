package iacademia.zonaldesk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

import iacademia.zonaldesk.Fragments.NewRequestFragment;

public class RegisterActivity extends AppCompatActivity {

    Button registerButton;
    EditText editText;
    DatabaseReference mRef;
    EditText ausername,password,address,pincode,email,state;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
      editText= (EditText) findViewById(R.id.user_name);
        registerButton = (Button)findViewById(R.id.registration_submit);
       registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef = FirebaseDatabase.getInstance().getReference("Users");
                ausername = (EditText)findViewById(R.id.user_name);
                password =(EditText)findViewById(R.id.password);
                address =(EditText)findViewById(R.id.address);
                pincode = (EditText)findViewById(R.id.pincode);
                email = (EditText)findViewById(R.id.email);
                state =(EditText)findViewById(R.id.state);
                register = (Button)findViewById(R.id.registration_submit);
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        register();
                    }
                });
                String e=editText.getText().toString().trim();

                SharedPreferences.Editor editor=getSharedPreferences("u_n",MODE_PRIVATE).edit();
                editor.putString("username",e);
                editor.commit();





           }
           public void register(){
               final String mUsername = ausername.getText().toString().trim();
               final String mPassword = password.getText().toString().trim();
               final String mAddress = address.getText().toString().trim();
               final String mPincode = pincode.getText().toString().trim();
               final String mEmail = email.getText().toString().trim();
               final String mState = state.getText().toString().trim();
               mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.hasChild(mUsername)){
                           Toast.makeText(RegisterActivity.this, "Username " + mUsername + "Already exists", Toast.LENGTH_LONG).show();
                       }


                         else {
                           addDetails(mUsername,mPassword,mAddress,mPincode,mEmail,mState);
                       }
                   }

                   @Override
                   public void onCancelled(DatabaseError databaseError) {

                   }
               });



        /*String res="";
                try {
                    res=updateUser();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(res.equals("null[]")){
                    SharedPreferences p= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    p.edit().putBoolean("VERIFICATION_STATUS",true).apply();
                    Intent s = new Intent(RegisterActivity.this,HomeActivity.class);
                    startActivity(s);
                }else{
                    Toast.makeText(getBaseContext(),"Registration Failed"+res,Toast.LENGTH_LONG).show();
                }*/

            }
            public void addDetails(String mU,String mPs,String mA,String mP,String mE,String mS){
                Registerationdb rg = new Registerationdb(mU,mPs,mE,mA,mP,mS);
                mRef.child(mU).setValue(rg);
                Intent i = new Intent(RegisterActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });

    }


   /* private String updateUser() throws ExecutionException, InterruptedException {
        EditText name = (EditText) findViewById(R.id.user_name);
        String _name=name.getText().toString();
        EditText password = (EditText) findViewById(R.id.password);
        String _password=password.getText().toString();
        EditText email = (EditText) findViewById(R.id.email);
        String _email=email.getText().toString();
        EditText locality = (EditText) findViewById(R.id.address);
        String _locality=locality.getText().toString();
        EditText pincode = (EditText) findViewById(R.id.pincode);
        String _pincode=pincode.getText().toString();
        EditText state = (EditText) findViewById(R.id.state);
        String _state=state.getText().toString();
        SharedPreferences p= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String _phone = p.getString("Phone","");

        String query="{\"type\":\"insert\",\"into\":\"user\",\"columns\":\"name,mobile_no,email,password,address,pincode,state,country \",\"values\":\""+"'"+_name+"'"+","+"'"+_phone+"'"+","+"'"+_email+"'"+","+"'"+_password+"'"+","+"'"+_locality+"'"+","+_pincode+","+"'"+_state+"'"+","+"'"+"India"+"'"+"\"}";

        String res=new PostTask().execute(query).get();

        return res;
    }*/
}
