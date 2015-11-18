package fr.univpau.view;

import fr.univpau.temperatureconverter.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import fr.univpau.business.Converter;

public class ConverterView extends Activity {
	EditText editText_cible_value;
	EditText editText_source_value;
	Spinner spinner_cible_value;
	Spinner spinner_source_value;
	
	
	public void convertir(View view){
		String uniteSource=spinner_source_value.getSelectedItem().toString();
		String uniteCible=spinner_cible_value.getSelectedItem().toString();

		double tempSource=Double.parseDouble(String.valueOf(editText_source_value.getText()));
		double tempCible=0;
		
		if(uniteSource.equals("Celsius")){
			Log.i("Calcul", "C-Celcius");
			if(uniteCible.equals("Kelvin")){
				Log.i("Calcul", "S-Kelvin");
				tempCible=Converter.celsiusToKelvin(tempSource);
			}
			else if(uniteCible.equals("Fahrenheit")){
				Log.i("Calcul", "S-Fahrenheit");
				tempCible=Converter.celsiusToFahrenheit(tempSource);
			}
		}
		else if(uniteSource.equals("Kelvin")){
			Log.i("Calcul", "C-Kelvin");
			if(uniteCible.equals("Celsius")){
				Log.i("Calcul", "S-Celsius");
				tempCible=Converter.kelvinToCelsius(tempSource);
			}
			else if(uniteCible.equals("Fahrenheit")){
				Log.i("Calcul", "S-Fahrenheit");
				tempCible=Converter.kelvinToFahrenheit(tempSource);
			}
		}
		else if(uniteSource.equals("Fahrenheit")){
			Log.i("Calcul", "C-Fahrenheit");
			if(uniteCible.equals("Celsius")){
				Log.i("Calcul", "S-Celsius");
				tempCible=Converter.fahrenheitToCelsius(tempSource);
			}
			else if(uniteCible.equals("Kelvin")){
				Log.i("Calcul", "S-Kelvin");
				tempCible=Converter.fahrenheitToKelvin(tempSource);
			}
		}
		
		editText_cible_value.setText(String.valueOf(tempCible));
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        
        // Allocation de ressources
        editText_cible_value=(EditText) findViewById(R.id.editText_cible);
        editText_source_value=(EditText) findViewById(R.id.editText_source);
        
        spinner_cible_value=(Spinner) findViewById(R.id.spinner_cible);
        spinner_source_value=(Spinner) findViewById(R.id.spinner_source);
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
