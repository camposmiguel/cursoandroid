package com.miguelcr.pasodeparametros;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MostrarNombreActivity extends Activity {
	
	TextView infoUsuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar_nombre);
		
		Bundle extras = getIntent().getExtras();
		
		String paramNombre = extras.getString("nombre");
		int paramEdad = extras.getInt("edad");
		
		infoUsuario = (TextView) findViewById(R.id.infoUsuario);
		infoUsuario.setText("Nombre: "+paramNombre+" / Edad: "+paramEdad);
		
	}
}
