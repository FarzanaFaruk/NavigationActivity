package com.example.mynavactivity.ui;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mynavactivity.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;
import java.util.List;

public class Gyroscope_Data extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<Member> calclist;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope__data);


        databaseReference = FirebaseDatabase.getInstance().getReference("GyroscopeData");


        customAdapter= new CustomAdapter(Gyroscope_Data.this,calclist);

       listView = findViewById(R.id.ListViewid);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                calclist.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Member calc=dataSnapshot1.getValue(Member.class);
                    calclist.add(calc);

                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

}
