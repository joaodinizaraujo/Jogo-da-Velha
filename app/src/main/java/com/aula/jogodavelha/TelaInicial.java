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

        // chama a tela principal com delay
        handler.postDelayed(this::abrirTelaPrincipal, 3000);
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(TelaInicial.this, MainActivity.class);

        // inicia a tela principal
        startActivity(intent);
        
        finish();
    }
}