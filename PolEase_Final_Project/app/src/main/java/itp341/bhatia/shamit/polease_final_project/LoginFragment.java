package itp341.bhatia.shamit.polease_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import itp341.bhatia.shamit.polease_final_project.model.User;

/**
 * Created by Shamit on 12/4/17.
 */

public class LoginFragment extends Fragment{

    // References to widgets
    EditText editUsername;
    EditText editPassword;
    Button loginBtn;

    // Reference to firebase database
    private DatabaseReference userDatabase;

    public LoginFragment() {
        // Required empty default constructor
    }

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment f = new LoginFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        // point to root directory of database
        userDatabase = FirebaseDatabase.getInstance().getReference();
        // initialize different widgets
        editUsername = v.findViewById(R.id.edit_text_username);
        editPassword = v.findViewById(R.id.edit_text_password);
        loginBtn = v.findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get username/password info from edit text fields
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                if (username.equals("") || password.equals("")){
                    Toast.makeText(getActivity(), "Please enter a username and password", Toast.LENGTH_LONG).show();
                }else{
                    // Make user object
                    User mUser = new User(username, password);

                    // Save to firebase
                    // create child - will be a user object
                    userDatabase.child(mUser.toString()).setValue(mUser);

                    // Launch intent to go to ListActivity
                    Intent i = new Intent(getActivity(), ListActivity.class);
                    i.putExtra("userTag",mUser);
                    startActivityForResult(i, 0);

                }
            }
        });

        /*userDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren() ){
                    User user = snapshot.getValue(User.class);
                    if (editUsername.getText().toString().equals(user.getUsername())){
                        Toast.makeText(getActivity(), "That username already exists!", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            editUsername.setText("");
            editPassword.setText("");
        }
    }
}
