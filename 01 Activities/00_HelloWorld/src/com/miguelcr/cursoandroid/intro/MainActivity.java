package com.miguelcr.cursoandroid.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void abrirActivitySecundario(View v) {
    	//ImageView icono = (ImageView)v;
    	//icono.setImageResource(R.drawable.ic_launcher);
    	
    	Intent i = new Intent(this,SecondaryActivity.class);
    	startActivity(i);
    }
}
