package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {

    EditText edit;
    EditText edit1;
    Button add;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        edit = findViewById(R.id.edit);
        edit1 = findViewById(R.id.edit1);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("meditimekeeperDB");

                String name = edit.getText().toString();
                String contact = edit1.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, contact);

                reference.child(contact).setValue(helperClass);

            }
        });

    }
}
