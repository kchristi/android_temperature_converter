package fr.univpau.view;

import fr.univpau.temperatureconverter.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import fr.univpau.business.Converter;
import fr.univpau.listener.ConvertButtonListener;;

public class ConverterView extends Activity {
	EditText editText_cible_value;
	EditText editText_source_value;
	Spinner spinner_cible_value;
	Spinner spinner_source_value;
	Button convert_button;
	ConvertButtonListener convert_button_listener;
	
	public void convertir(View view){
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        
        // Allocation de ressources
        editText_cible_value=(EditText) findViewById(R.id.editText_cible);
        editText_cible_value.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editText_source_value=(EditText) findViewById(R.id.editText_source);
        editText_source_value.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        
        spinner_cible_value=(Spinner) findViewById(R.id.spinner_cible);
        spinner_source_value=(Spinner) findViewById(R.id.spinner_source);
        
        convert_button_listener = new ConvertButtonListener(editText_cible_value, editText_source_value, spinner_cible_value, spinner_source_value);
        
        convert_button=(Button) findViewById(R.id.convert_button);
        convert_button.setOnClickListener(convert_button_listener);
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
