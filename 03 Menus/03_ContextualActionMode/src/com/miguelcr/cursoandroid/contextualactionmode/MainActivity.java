package com.miguelcr.cursoandroid.contextualactionmode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	private List<String> listadoSistemas;
	private ActionMode actionMode = null;
	private SparseBooleanArray seleccionados;
	private ArrayAdapter<String> adaptador;
	private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listadoSistemas = new ArrayList<String>();
        listadoSistemas.add("Android");
        listadoSistemas.add("Linux");
        listadoSistemas.add("Windows");
        
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,listadoSistemas);
        setListAdapter(adaptador);
        
        // Cambiar a modo de selección Múltiple
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        
        lista = getListView();
    }


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
			
		if(actionMode==null) {
			actionMode = startActionMode(new ActionModeCallback());
		}
		
		int numeroSeleccionados = l.getCheckedItemCount();
		seleccionados = l.getCheckedItemPositions();
		
		if(numeroSeleccionados==0) {
			actionMode.finish();
		} else {
			String titulo = numeroSeleccionados==1? " seleccionado" :  " seleccionados";
			actionMode.setTitle(String.valueOf(numeroSeleccionados).concat(titulo));
		}
	}
	
	private class ActionModeCallback implements ActionMode.Callback {

	    // Called when the action mode is created; startActionMode() was called
	    @Override
	    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
	        // Inflate a menu resource providing context menu items
	        MenuInflater inflater = mode.getMenuInflater();
	        inflater.inflate(R.menu.context_bar_menu, menu);
	        return true;
	    }

	    // Called each time the action mode is shown. Always called after onCreateActionMode, but
	    // may be called multiple times if the mode is invalidated.
	    @Override
	    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
	        return false; // Return false if nothing is done
	    }

	    // Called when the user selects a contextual menu item
	    @Override
	    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.actionDeleteAll:
	                borrarSeleccionados();
	                mode.finish(); // Action picked, so close the CAB
	                lista.clearChoices();
	                return true;
	            default:
	                return false;
	        }
	    }

	    private void borrarSeleccionados() {
	    	List<String> itemsABorrar = new ArrayList<String>();
	    	
			for (int i = 0; i < listadoSistemas.size(); i++) {
				String itemActual = listadoSistemas.get(i);
				
				// Compruebo si el elemento actual ha sido chequeado
				if(seleccionados.get(i)) {
					itemsABorrar.add(itemActual);
				}
			}
			
			listadoSistemas.removeAll(itemsABorrar);
			adaptador.notifyDataSetChanged();
			
			
		}

		// Called when the user exits the action mode
	    @Override
	    public void onDestroyActionMode(ActionMode mode) {
	        actionMode = null;
	    }
	}
    
    
}
