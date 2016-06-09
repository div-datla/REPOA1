package seclass.gatech.edu.converter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private EditText inputValue;
    private EditText outputResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerFrom = (Spinner)findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner)findViewById(R.id.spinnerTo);
        inputValue = (EditText) findViewById(R.id.inputValue);
        outputResult = (EditText) findViewById(R.id.outputResult);

    }

    public void whenClicked(View view) {
        HashMap<String,Double> outputMap = null;
        String value = inputValue.getText().toString();
        DecimalFormat formatValue = new DecimalFormat("#.####");


        if (view.getId()==R.id.buttonConvert || view.getId()==R.id.buttonRndConvert ) {

            if (value.length() > 0) {
                switch (spinnerFrom.getSelectedItem().toString()) {
                    case ("Stones"):
                        outputMap = FromStones(value);
                        break;
                    case ("Pounds"):
                        outputMap = FromPounds(value);
                        break;
                    case ("Ounces"):
                        outputMap = FromOunces(value);
                        break;
                    case ("Grains"):
                        outputMap = FromGrains(value);
                        break;
                    case ("Metric tons"):
                        outputMap = FromMetricTons(value);
                        break;
                    case ("Kilograms"):
                        outputMap = FromKilograms(value);
                        break;
                    case ("Grams"):
                        outputMap = FromGrams(value);
                        break;
                    case ("Milligrams"):
                        outputMap = FromMilligrams(value);
                        break;

                }
                if (view.getId()==R.id.buttonConvert) {
                    switch (spinnerTo.getSelectedItem().toString()) {
                        case ("Stones"):
                            outputResult.setText(formatValue.format(outputMap.get("Stones")));
                            break;
                        case ("Pounds"):
                            outputResult.setText(formatValue.format(outputMap.get("Pounds")));
                            break;
                        case ("Ounces"):
                            outputResult.setText(formatValue.format(outputMap.get("Ounces")));
                            break;
                        case ("Grains"):
                            outputResult.setText(formatValue.format(outputMap.get("Grains")));
                            break;
                        case ("Metric tons"):
                            outputResult.setText(formatValue.format(outputMap.get("Metric tons")));
                            break;
                        case ("Kilograms"):
                            outputResult.setText(formatValue.format(outputMap.get("Kilograms")));
                            break;
                        case ("Grams"):
                            outputResult.setText(formatValue.format(outputMap.get("Grams")));
                            break;
                        case ("Milligrams"):
                            outputResult.setText(formatValue.format(outputMap.get("Milligrams")));
                            break;
                    }
                }
                else if (view.getId()==R.id.buttonRndConvert) {
                    Random random    = new Random();
                    List<String> keys      = new ArrayList<String>(outputMap.keySet());
                    String       randomKey = keys.get( random.nextInt(keys.size()) );
                    double       randomValue     = outputMap.get(randomKey);
                    spinnerTo.setSelection(((ArrayAdapter)spinnerTo.getAdapter()).getPosition(randomKey));
                    outputResult.setText(formatValue.format(randomValue));
                }

            } else {
                Context context = getApplicationContext();
                CharSequence text = "Enter Input Weight";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }


        else if (view.getId()==R.id.buttonReset) {
                inputValue.setText("");
                outputResult.setText("");
                spinnerFrom.setSelection(0);
                spinnerTo.setSelection(0);

        }
    }

    private HashMap<String,Double> FromStones(String inputWeight){
        HashMap<String,Double> fromStonesMap= new HashMap<String , Double>();
        double toPounds = Double.parseDouble(inputWeight) * 14;
        double toOunces = Double.parseDouble(inputWeight) * 224;
        double toGrains = Double.parseDouble(inputWeight) * 98000;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/157.473044;
        double toKilograms = Double.parseDouble(inputWeight) * 6.35029;
        double toGrams = Double.parseDouble(inputWeight) * 6350.29318;
        double toMilligrams = Double.parseDouble(inputWeight) * 6350293.18;

        fromStonesMap.put("Stones",Double.parseDouble(inputWeight));
        fromStonesMap.put("Pounds",toPounds);
        fromStonesMap.put("Ounces",toOunces);
        fromStonesMap.put("Grains",toGrains);
        fromStonesMap.put("Metric tons",toMetricTons);
        fromStonesMap.put("Kilograms",toKilograms);
        fromStonesMap.put("Grams",toGrams);
        fromStonesMap.put("Milligrams",toMilligrams);

        return fromStonesMap;
    }

    private HashMap<String,Double> FromPounds(String inputWeight){
        HashMap<String,Double> fromPoundsMap= new HashMap<String , Double>();
        double toStones = Double.parseDouble(inputWeight) * 1/ 14;
        double toOunces = Double.parseDouble(inputWeight) * 16;
        double toGrains = Double.parseDouble(inputWeight) * 7000;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/2204.622621;
        double toKilograms = Double.parseDouble(inputWeight) * 1/2.204622;
        double toGrams = Double.parseDouble(inputWeight) * 453.5923;
        double toMilligrams = Double.parseDouble(inputWeight) * 453592.37;

        fromPoundsMap.put("Pounds",Double.parseDouble(inputWeight));
        fromPoundsMap.put("Stones",toStones);
        fromPoundsMap.put("Ounces",toOunces);
        fromPoundsMap.put("Grains",toGrains);
        fromPoundsMap.put("Metric tons",toMetricTons);
        fromPoundsMap.put("Kilograms",toKilograms);
        fromPoundsMap.put("Grams",toGrams);
        fromPoundsMap.put("Milligrams",toMilligrams);

        return fromPoundsMap;
    }

    private HashMap<String,Double> FromOunces(String inputWeight){    //Change
        HashMap<String,Double> fromOuncesMap= new HashMap<String , Double>();

        double toStones = Double.parseDouble(inputWeight) * 1/ 224;
        double toPounds = Double.parseDouble(inputWeight) * 1/16;
        double toGrains = Double.parseDouble(inputWeight) * 437.5;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/35273.96194;
        double toKilograms = Double.parseDouble(inputWeight) * 1/35.2739;
        double toGrams = Double.parseDouble(inputWeight) * 28.3495;
        double toMilligrams = Double.parseDouble(inputWeight) * 28349.5231;

        fromOuncesMap.put("Ounces",Double.parseDouble(inputWeight));
        fromOuncesMap.put("Stones",toStones);
        fromOuncesMap.put("Pounds",toPounds);
        fromOuncesMap.put("Grains",toGrains);
        fromOuncesMap.put("Metric tons",toMetricTons);
        fromOuncesMap.put("Kilograms",toKilograms);
        fromOuncesMap.put("Grams",toGrams);
        fromOuncesMap.put("Milligrams",toMilligrams);
        return fromOuncesMap;
    }

    private HashMap<String,Double> FromGrains(String inputWeight){
        HashMap<String,Double> fromGrainsMap= new HashMap<String , Double>();
        double toStones = Double.parseDouble(inputWeight)* 1 /98000;
        double toPounds = Double.parseDouble(inputWeight) * 1/7000;
        double toOunces = Double.parseDouble(inputWeight) * 1/437.5;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/15432358.3583;
        double toKilograms = Double.parseDouble(inputWeight) * 1/15432.358;
        double toGrams = Double.parseDouble(inputWeight) * 1/15.43235;
        double toMilligrams = Double.parseDouble(inputWeight) * 64.79891;

        fromGrainsMap.put("Grains",Double.parseDouble(inputWeight));
        fromGrainsMap.put("Stones",toStones);
        fromGrainsMap.put("Pounds",toPounds);
        fromGrainsMap.put("Ounce",toOunces);
        fromGrainsMap.put("Metric tons",toMetricTons);
        fromGrainsMap.put("Kilograms",toKilograms);
        fromGrainsMap.put("Grams",toGrams);
        fromGrainsMap.put("Milligrams",toMilligrams);

        return fromGrainsMap;
    }

    private HashMap<String,Double> FromMetricTons(String inputWeight){
        HashMap<String,Double> fromMetricTonsMap= new HashMap<String , Double>();

        double toStones = Double.parseDouble(inputWeight) * 157.47304;
        double toPounds = Double.parseDouble(inputWeight) * 2204.62622;
        double toOunces = Double.parseDouble(inputWeight) * 35273.96194;
        double toGrains = Double.parseDouble(inputWeight) * 15432358.3583;
        double toKilograms = Double.parseDouble(inputWeight) * 1000;
        double toGrams = Double.parseDouble(inputWeight) * 1000000;
        double toMilligrams = Double.parseDouble(inputWeight) * 1000000000;

        fromMetricTonsMap.put("Metric tons",Double.parseDouble(inputWeight));
        fromMetricTonsMap.put("Stones",toStones);
        fromMetricTonsMap.put("Pounds",toPounds);
        fromMetricTonsMap.put("Ounces",toOunces);
        fromMetricTonsMap.put("Grains",toGrains);
        fromMetricTonsMap.put("Kilograms",toKilograms);
        fromMetricTonsMap.put("Grams",toGrams);
        fromMetricTonsMap.put("Milligrams",toMilligrams);

        return fromMetricTonsMap;
    }

    private HashMap<String,Double> FromKilograms(String inputWeight){
        HashMap<String,Double> fromKilogramsMap= new HashMap<String , Double>();

        double toStones = Double.parseDouble(inputWeight) * 1 / 6.35029;
        double toPounds = Double.parseDouble(inputWeight) * 2.204622;
        double toOunces = Double.parseDouble(inputWeight) * 35.2739;
        double toGrains = Double.parseDouble(inputWeight) * 15432.358;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/ 1000;
        double toGrams = Double.parseDouble(inputWeight) * 1000;
        double toMilligrams = Double.parseDouble(inputWeight) * 1000000;

        fromKilogramsMap.put("Kilograms",Double.parseDouble(inputWeight));
        fromKilogramsMap.put("Stones",toStones);
        fromKilogramsMap.put("Pounds",toPounds);
        fromKilogramsMap.put("Ounces",toOunces);
        fromKilogramsMap.put("Grains",toGrains);
        fromKilogramsMap.put("Metric tons",toMetricTons);
        fromKilogramsMap.put("Grams",toGrams);
        fromKilogramsMap.put("Milligrams",toMilligrams);

        return fromKilogramsMap;
    }

    private HashMap<String,Double> FromGrams(String inputWeight){
        HashMap<String,Double> fromGramsMap= new HashMap<String , Double>();

        double toStones = Double.parseDouble(inputWeight) * 1/6350.29318;
        double toPounds = Double.parseDouble(inputWeight) * 1/453.5923;
        double toOunces = Double.parseDouble(inputWeight) * 1/ 28.3495;
        double toGrains = Double.parseDouble(inputWeight) * 15.43235;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/1000000;
        double toKilograms = Double.parseDouble(inputWeight) * 1/1000;
        double toMilligrams = Double.parseDouble(inputWeight) * 1000;

        fromGramsMap.put("Grams",Double.parseDouble(inputWeight));
        fromGramsMap.put("Stones",toStones);
        fromGramsMap.put("Pounds",toPounds);
        fromGramsMap.put("Ounces",toOunces);
        fromGramsMap.put("Grains",toGrains);
        fromGramsMap.put("Metric tons",toMetricTons);
        fromGramsMap.put("Kilograms",toKilograms);
        fromGramsMap.put("Milligrams",toMilligrams);

        return fromGramsMap;
    }

    private HashMap<String,Double> FromMilligrams(String inputWeight){
        HashMap<String,Double> fromMilligramsMap= new HashMap<String , Double>();

        double toStones = Double.parseDouble(inputWeight) * 1/ 6350293.18;
        double toPounds = Double.parseDouble(inputWeight) * 1/ 453592.37;
        double toOunces = Double.parseDouble(inputWeight) * 1/28349.5231;
        double toGrains = Double.parseDouble(inputWeight) * 1/64.79891;
        double toMetricTons = Double.parseDouble(inputWeight) * 1/1000000000;
        double toKilograms = Double.parseDouble(inputWeight) * 1/1000000;
        double toGrams = Double.parseDouble(inputWeight) * 1/1000;

        fromMilligramsMap.put("Milligrams",Double.parseDouble(inputWeight));
        fromMilligramsMap.put("Stones",toStones);
        fromMilligramsMap.put("Pounds",toPounds);
        fromMilligramsMap.put("Ounces",toOunces);
        fromMilligramsMap.put("Grains",toGrains);
        fromMilligramsMap.put("Metric tons",toMetricTons);
        fromMilligramsMap.put("Kilograms",toKilograms);
        fromMilligramsMap.put("Grams",toGrams);

        return fromMilligramsMap;
    }
}
