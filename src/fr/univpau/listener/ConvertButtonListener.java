package fr.univpau.listener;

import fr.univpau.business.Converter;
import fr.univpau.view.ConverterView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;

public class ConvertButtonListener implements OnClickListener {
	ConverterView converterView;
	EditText editText_cible_value;
	EditText editText_source_value;
	Spinner spinner_cible_value;
	Spinner spinner_source_value;
	
	@Override
	public void onClick(View v) {
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
	
	public ConvertButtonListener(EditText editText_cible_value, EditText editText_source_value,Spinner spinner_cible_value,Spinner spinner_source_value){
		this.editText_cible_value=editText_cible_value;
		this.editText_source_value=editText_source_value;
		this.spinner_cible_value=spinner_cible_value;
		this.spinner_source_value=spinner_source_value;
	}

}
