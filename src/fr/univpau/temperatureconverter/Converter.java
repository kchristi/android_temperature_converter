package fr.univpau.temperatureconverter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Converter extends Activity {
	final double zero_absolu_kelvin=273.15;
	final double zero_absolu_fahrenheit=459.67;
	final double water_freeze_fahrenheit=32;
	final double f_constant_1=(5d/9d);
	final double f_constant_2=1/f_constant_1;
	
	EditText editText_cible_value;
	EditText editText_source_value;
	Spinner spinner_cible_value;
	Spinner spinner_source_value;
	
	public double celsiusToKelvin(double source){
		return source+zero_absolu_kelvin;
	}
	public double celsiusToFahrenheit(double source){
		Log.i("Calcul", "source - zero="+(source-zero_absolu_fahrenheit));
		Log.i("Calcul", "f="+f_constant_1);
		Log.i("Calcul", "f*source - zero="+(f_constant_1*(source-zero_absolu_fahrenheit)));
		return (f_constant_2*source)+water_freeze_fahrenheit;
	}
	public double kelvinToCelsius(double source){
		return source - zero_absolu_kelvin;
	}
	public double kelvinToFahrenheit(double source){
		return (f_constant_2*source)-zero_absolu_fahrenheit;
	}
	public double fahrenheitToKelvin(double source){
		return f_constant_1*(source+zero_absolu_fahrenheit);
	}
	public double fahrenheitToCelsius(double source){
		return f_constant_1*(source -water_freeze_fahrenheit);
	}
	
	public void convertir(View view){
		String uniteSource=spinner_source_value.getSelectedItem().toString();
		String uniteCible=spinner_cible_value.getSelectedItem().toString();

		double tempSource=Double.parseDouble(String.valueOf(editText_source_value.getText()));
		double tempCible=0;
		
		if(uniteSource.equals("Celsius")){
			Log.i("Calcul", "C-Celcius");
			if(uniteCible.equals("Kelvin")){
				Log.i("Calcul", "S-Kelvin");
				tempCible=celsiusToKelvin(tempSource);
			}
			else if(uniteCible.equals("Fahrenheit")){
				Log.i("Calcul", "S-Fahrenheit");
				tempCible=celsiusToFahrenheit(tempSource);
			}
		}
		else if(uniteSource.equals("Kelvin")){
			Log.i("Calcul", "C-Kelvin");
			if(uniteCible.equals("Celsius")){
				Log.i("Calcul", "S-Celsius");
				tempCible=kelvinToCelsius(tempSource);
			}
			else if(uniteCible.equals("Fahrenheit")){
				Log.i("Calcul", "S-Fahrenheit");
				tempCible=kelvinToFahrenheit(tempSource);
			}
		}
		else if(uniteSource.equals("Fahrenheit")){
			Log.i("Calcul", "C-Fahrenheit");
			if(uniteCible.equals("Celsius")){
				Log.i("Calcul", "S-Celsius");
				tempCible=fahrenheitToCelsius(tempSource);
			}
			else if(uniteCible.equals("Kelvin")){
				Log.i("Calcul", "S-Kelvin");
				tempCible=fahrenheitToKelvin(tempSource);
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
