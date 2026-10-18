package br.edu.fatecjahu.imcapp;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;

public class ResultadoActivity extends AppCompatActivity {

    private float peso;
    private float altura;
    private double imc;
    private String classificacao;
    private boolean precisaFazerRegime;
    private TextView txtAltura;
    private TextView txtPeso;
    private TextView txtImc;
    private TextView txtClassificacao;
    private TextView txtRecomendacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        txtImc = findViewById(R.id.txtImc);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        txtRecomendacao = findViewById(R.id.txtRecomendacao);

        Bundle meusDadosIMC = getIntent().getBundleExtra("meusDadosIMC");

        if (meusDadosIMC == null) {
            Toast.makeText(this, "Não foi possível receber os dados do IMC.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        peso = meusDadosIMC.getFloat("peso");
        altura = meusDadosIMC.getFloat("altura");

        imc = calcularIMC(peso, altura);
        classificacao = classificarIMC(imc);
        precisaFazerRegime = imc >= 25.0;

        mostrarResultado();
    }

    public double calcularIMC(float peso, float altura) {
        return peso / (altura * altura);
    }

    public String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25.0) {
            return "Peso normal";
        } else if (imc < 30.0) {
            return "Sobrepeso";
        } else if (imc < 35.0) {
            return "Obesidade Grau I";
        } else if (imc < 40.0) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III";
        }
    }

    private void mostrarResultado() {
        Locale brasil = new Locale("pt", "BR");

        txtAltura.setText(String.format(brasil, "Altura: %.2f m", altura));
        txtPeso.setText(String.format(brasil, "Peso: %.2f kg", peso));
        txtImc.setText(String.format(brasil, "Seu IMC é: %.2f", imc));
        txtClassificacao.setText("Classificação: " + classificacao);

        if (precisaFazerRegime) {
            txtRecomendacao.setText("Sim é necessário fazer regime.");
            txtRecomendacao.setBackgroundColor(getColor(R.color.vermelho_regime));
        } else {
            txtRecomendacao.setText("Não precisa fazer regime.");
            txtRecomendacao.setBackgroundColor(getColor(R.color.verde_sem_regime));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
