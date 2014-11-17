package com.miguelcr.pasodeparametros;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormularioActivity extends Activity {
	
	EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        
        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
    }
    
    public void enviarNombre(View v) {
    	String nombreIntroducido = editTextNombre.getText().toString();
    	
    	// Lanzamiento de otro Activity (pantalla).
    	Intent i = new Intent(this, MostrarNombreActivity.class);
    	i.putExtra("nombre", nombreIntroducido);
    	i.putExtra("edad", 40);
    	startActivity(i);
    }
}
