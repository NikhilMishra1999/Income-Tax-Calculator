package com.example.nikhil.incometax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent i = getIntent();
        final String p = i.getStringExtra("totaltax");
        TextView textView = (TextView)findViewById(R.id.tax);
        textView.setText(p);

        final String r = i.getStringExtra("taxable");
        TextView textView2 = (TextView)findViewById(R.id.taxinc);
        textView2.setText(r);

        Button b = (Button)findViewById(R.id.share);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String TAX = "*Taxable Income* = "+r+"\n"+"*Tax to be paid* = "+p;
                i.putExtra(Intent.EXTRA_TEXT,TAX);
                startActivity(Intent.createChooser(i,"Share Using"));
            }
        });

    }
}
