package com.miguelcr.seleccioncontacto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Defino mi requestCode
	private static final int TESTIGO_SELECCION_CONTACTO = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void seleccionContacto(View v) {
		Intent i = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
		startActivityForResult(i, TESTIGO_SELECCION_CONTACTO);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == Activity.RESULT_OK
				&& requestCode == TESTIGO_SELECCION_CONTACTO) {
			Cursor cursor = getContentResolver().query(data.getData(),
					new String[] { Contacts.DISPLAY_NAME }, null, null, null);
			if (cursor.moveToFirst()) { // True if the cursor is not empty
				int columnIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
				String name = cursor.getString(columnIndex);
				Toast.makeText(this, "Has seleccionado a: "+name,
						Toast.LENGTH_LONG).show();
			}

		} else if (resultCode == Activity.RESULT_CANCELED) {
			Toast.makeText(this, "Ha ocurrido algo grave y no es viernes",
					Toast.LENGTH_LONG).show();
		}

	}

}
