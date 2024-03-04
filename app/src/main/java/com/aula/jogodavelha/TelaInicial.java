package com.aula.jogodavelha;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TelaInicial extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Handler handler = new Handler();
        handler.postDelayed(this::abrirSegundaTelas, 3000);
    }

    private void abrirSegundaTelas() {
        Intent intent = new Intent(TelaInicial.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}