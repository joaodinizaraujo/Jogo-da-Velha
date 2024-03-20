package com.aula.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void lancarAmigo(View view) {
        Bundle dados = new Bundle();
        dados.putInt("tipo", 0);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(dados);
        startActivity(intent);
    }

    public void lancarAndroid(View view) {
        Bundle dados = new Bundle();
        dados.putInt("tipo", 1);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(dados);
        startActivity(intent);
    }

    public void lancarGPT(View view) {
        Bundle dados = new Bundle();
        dados.putInt("tipo", 2);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(dados);
        startActivity(intent);
    }
}