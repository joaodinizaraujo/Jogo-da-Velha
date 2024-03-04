package com.aula.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int jogada;
    private char[][] jogo;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogo = new char[3][3];
        jogada = 0;
        handler = new Handler();
    }
    public boolean verificarVitoria(){
        for(int i = 0; i < jogo.length; i++){
            if((jogo[i][0] == jogo[i][1] && jogo[i][1] == jogo[i][2] && (jogo[i][0] == 'x' || jogo[i][0] == 'o')) ||
                (jogo[0][i] == jogo[1][i] && jogo[1][i] == jogo[2][i] && (jogo[0][i] == 'x' || jogo[0][i] == 'o')) ){
                return true;
            }
        }
        return ((jogo[0][0] == jogo[1][1] && jogo[1][1] == jogo[2][2]) && (jogo[0][0] == 'x' || jogo[0][0] == 'o'))
                || ((jogo[0][2] == jogo[1][1] && jogo[1][1] == jogo[2][0]) && (jogo[0][2] == 'x' || jogo[0][2] == 'o'));
    }

    public void limparJogo(){
        jogo = new char[3][3];
        jogada = 0;
        ((ImageView) findViewById(R.id.a00)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a01)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a02)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a10)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a11)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a12)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a20)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a21)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((ImageView) findViewById(R.id.a22)).setImageDrawable(new ColorDrawable(Color.TRANSPARENT));
        ((TextView) findViewById(R.id.resultado)).setText(" ");
    }

    public void colocarJogada(View view) {
        ImageView posicao = (ImageView) view;
        String id = view.getResources().getResourceEntryName(posicao.getId()).replace("a", "");
        int i;
        int j;
        if(!id.contains("b")){
            i = Integer.parseInt(String.valueOf(id.charAt(0)));
            j = Integer.parseInt(String.valueOf(id.charAt(1)));
        }else{
            return;
        }
        if(jogo[i][j] == '\u0000'){
            if(jogada % 2 == 0) {
                posicao.setImageResource(R.drawable.x);
                jogo[i][j] = 'x';
            }else{
                posicao.setImageResource(R.drawable.o);
                jogo[i][j] = 'o';
            }
            jogada++;
            if(verificarVitoria()){
                ((TextView) findViewById(R.id.resultado)).setText("Vitória!!!!");
                jogada = 9;
            } else if (jogada == 9) {
                ((TextView) findViewById(R.id.resultado)).setText("Empate...");
            }
            if(jogada == 9){
                handler.postDelayed(() -> {
                    ((TextView) findViewById(R.id.resultado)).setText("Reiniciando!!");
                    handler.postDelayed(this::limparJogo, 2000
                    );
                }, 2000);
            }
        }
    }
}