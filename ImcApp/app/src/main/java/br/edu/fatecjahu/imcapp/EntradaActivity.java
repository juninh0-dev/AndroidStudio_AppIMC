package br.edu.fatecjahu.imcapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EntradaActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entrada);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular() {
        String pesoTexto = edtPeso.getText().toString().trim();
        String alturaTexto = edtAltura.getText().toString().trim();

        if (pesoTexto.isEmpty() || alturaTexto.isEmpty()) {
            Toast.makeText(
                    this,
                    "Preencha o peso e a altura.",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        float peso = Float.parseFloat(pesoTexto.replace(",", "."));
        float altura = Float.parseFloat(alturaTexto.replace(",", "."));

        if (peso <= 0 || altura <= 0) {
            Toast.makeText(
                    this,
                    "Peso e altura devem ser maiores que zero.",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        Intent intent = new Intent(EntradaActivity.this, ResultadoActivity.class);

        Bundle meusDadosIMC = new Bundle();
        meusDadosIMC.putFloat("peso", peso);
        meusDadosIMC.putFloat("altura", altura);

        intent.putExtra("meusDadosIMC", meusDadosIMC);
        startActivity(intent);
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Sair do aplicativo")
                .setMessage("Deseja sair do aplicativo?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }
}
