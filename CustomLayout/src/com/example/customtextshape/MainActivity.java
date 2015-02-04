package com.example.customtextshape;

import java.util.Random;



import com.example.customeLayout.CustomLayout;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       CustomLayout cl = (CustomLayout)this.findViewById(R.id.cl);
        
        String msg = "My Name *1 is Tanim reja... i live hear.. i am android *2 application developer *3 ";
        int count=0;
        for(int j=0;j<msg.length();j++)
        {        
        	if (msg.charAt(j) == '*'){
        		count++;
        	}
        }
       
        String [] m = msg.split("\\*");
        String name="tt";
        for (int i=0; i<m.length; i++){
        	      	
        	View v = View.inflate(MainActivity.this, R.layout.custom_text_shape, null);
            View normalView=View.inflate(MainActivity.this, R.layout.normal_textshspe, null);
            TextView txt1 = (TextView)normalView.findViewById(R.id.txt1);
            TextView txt2 = (TextView)v.findViewById(R.id.txtShape);  
            
        	cl.addView(normalView);
        	String c="0";
        	if (i>0){
        	 c = ""+i;
        	 name=	m[i].replace(c, "");
        	 m[i]=name;
        	}        	
        	txt1.setText(m[i]);
        	
        	if(i!=m.length-1)
        	{
        		cl.addView(v);
        		txt2.setText(c);   
        	}
       
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
