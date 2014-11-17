package com.miguelcr.cursoandroid.mycustombrowser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MiguelBrowserActivity extends Activity {
	
	WebView navegador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_miguel_browser);
		
		Uri datos = getIntent().getData();
		String urlSolicitada = datos.toString();
		
		navegador = (WebView) findViewById(R.id.webViewNavegador);
		
		// Compruebo si la URL solicitada es vacía
		if(urlSolicitada.equals("")) {
			navegador.loadUrl("http://www.google.es");
		} else {
			navegador.loadUrl(urlSolicitada);
		}
	}
}
