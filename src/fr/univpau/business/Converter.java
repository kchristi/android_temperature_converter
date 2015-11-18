package fr.univpau.business;

import android.util.Log;

public class Converter {
	final static double zero_absolu_kelvin=273.15;
	final static double zero_absolu_fahrenheit=459.67;
	final static double water_freeze_fahrenheit=32;
	final static double f_constant_1=(5d/9d);
	final static double f_constant_2=1/f_constant_1;
	
	public static double celsiusToKelvin(double source){
		return source+zero_absolu_kelvin;
	}
	
	public static double  celsiusToFahrenheit(double source){
		Log.i("Calcul", "source - zero="+(source-zero_absolu_fahrenheit));
		Log.i("Calcul", "f="+f_constant_1);
		Log.i("Calcul", "f*source - zero="+(f_constant_1*(source-zero_absolu_fahrenheit)));
		return (f_constant_2*source)+water_freeze_fahrenheit;
	}
	
	public static double kelvinToCelsius(double source){
		return source - zero_absolu_kelvin;
	}
	
	public static double kelvinToFahrenheit(double source){
		return (f_constant_2*source)-zero_absolu_fahrenheit;
	}
	
	public static double fahrenheitToKelvin(double source){
		return f_constant_1*(source+zero_absolu_fahrenheit);
	}
	
	public static double fahrenheitToCelsius(double source){
		return f_constant_1*(source -water_freeze_fahrenheit);
	}
	
}
