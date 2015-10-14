package br.com.bluecoder.calculopoupanca;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText val_ap;
    private EditText val_tax;
    private EditText val_temp;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val_ap = (EditText)findViewById(R.id.editTextAplicacao);
        val_tax = (EditText)findViewById(R.id.editTextValTax);
        val_temp = (EditText)findViewById(R.id.editTextTemp);

        btnCalcular = (Button)findViewById(R.id.buttonCalcular);

        btnCalcular.setOnClickListener(this);
    }

    public void onClick(View v){

        double val1 = Double.parseDouble(val_ap.getText().toString());
        double val2 = Double.parseDouble(val_tax.getText().toString());
        double val3 = Double.parseDouble(val_temp.getText().toString());

        double mont = 0;
        for(int i = 0; i < val3; i++){
            mont = (mont + val1)*((val2/100)+1);
        }
        //double mont = (val1 + val2) * ((val3 / 100)+1);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setMessage("O Montante ao final de " + val3 + " meses é de: " + mont);


        dlg.setNeutralButton("OK", null);
        dlg.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
