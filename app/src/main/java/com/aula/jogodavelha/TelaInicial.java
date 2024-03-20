package com.aula.jogodavelha;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class TelaInicial extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Handler handler = new Handler();

        image = findViewById(R.id.imagemAvatar);
        Glide.with(this).load("https://upload.wikimedia.org/wikipedia/commons/a/ae/Tic_Tac_Toe.gif").into(image);

        // chama a tela principal com delay
        handler.postDelayed(this::abrirTelaPrincipal, 7000);
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(TelaInicial.this, Menu.class);

        // inicia a tela principal
        startActivity(intent);
        
        finish();
    }
}