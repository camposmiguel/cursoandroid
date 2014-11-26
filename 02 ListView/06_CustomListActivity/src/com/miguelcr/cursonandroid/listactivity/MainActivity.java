package com.miguelcr.cursonandroid.listactivity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	// 1. Listado de elementos
	List<SistemaOperativo> listadoSistemasOperativos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listadoSistemasOperativos = new ArrayList<SistemaOperativo>();
        listadoSistemasOperativos.add(new SistemaOperativo("Android", 2007, R.drawable.ic_android));
        listadoSistemasOperativos.add(new SistemaOperativo("Windows", 1980, R.drawable.ic_windows));
        listadoSistemasOperativos.add(new SistemaOperativo("MACOS", 1979, R.drawable.ic_mac ));
        listadoSistemasOperativos.add(new SistemaOperativo("Linux", 1950, R.drawable.ic_linux));
        
                
        SistemaOperativoAdapter adaptador = new SistemaOperativoAdapter(this, R.layout.list_item_sistema_operativo, listadoSistemasOperativos);
        
        setListAdapter(adaptador);
        
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	// TODO Auto-generated method stub
    	super.onListItemClick(l, v, position, id);
    	Toast.makeText(this, "Has seleccionado: "+listadoSistemasOperativos.get(position).getNombre(), Toast.LENGTH_LONG).show();
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.options_menu_ssoo, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.actionAdd:
	            Intent i = new Intent(this, AddActivity.class);
	            startActivity(i);
	            
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}