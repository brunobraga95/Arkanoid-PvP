package com.example.bruno.jogo;

import android.graphics.Bitmap;

/**
 * Created by bruno on 25/02/15.
 */
public class iniciliaza_variaveis {
    public iniciliaza_variaveis(int Width, int Height) {
        rodando.vida_player1 = 4;
        rodando.vida_player2 = 4;
        rodando.velocidade_player = 10;
        rodando.velocidade_bola = 5;
        rodando.blocox = Width/2 - rodando.tamanho_blocox/2;
        rodando.blocoy = Height/2-rodando.tamanho_blocoy/2;
        rodando.tamanho_playerx = Width/10;
        rodando.tamanho_playerx*=4;
        rodando.tamanho_playery = Height/15;
        rodando.y_player1 = Height-rodando.tamanho_playery;
        rodando.x_player1 = Width/2 - rodando.tamanho_playerx/2;
        rodando.x_player2 = rodando.x_player1;

        rodando.setadireitax = Width - rodando.tamanhoseta;
        rodando.setadireitay = Height*8/10;

        rodando.setaesquerdax = 0;
        rodando.setaesquerday = Height*8/10;

        rodando.setadireitax2 = Width - rodando.tamanhoseta;
        rodando.setadireitay2 = Height/12;

        rodando.setaesquerdax2 = 0;
        rodando.setaesquerday2 = Height/12;

        rodando.tamanho_bola = Width/10;

        rodando.tamanho_blocox = Width*2/5;
        rodando.tamanho_blocoy = Width/15;

        rodando.tamanho_play = Width/4;
        rodando.playx = Width/2 - rodando.tamanho_play/2;
        rodando.playy = Height/2 - rodando.tamanho_play - Height/30;

        rodando.y_player2 = 0;

        rodando.x = Width/2 -rodando.tamanho_bola/2;
        rodando.y = Height/2 - rodando.tamanho_bola/2;

        rodando.setarepetir_tamanho = Width/4;
        rodando.setarepetirx = Width/2 - rodando.setarepetir_tamanho/2;
        rodando.setarepetiry = Height/2 - rodando.setarepetir_tamanho + Height/30;


        rodando.sairx= Width/2 - rodando.tamanho_play/2;
        rodando.sairy = Height/2 + Height/30;

        rodando.tamanho_arkanoidpvpx = Width*9/10;
        rodando.tamanho_arkanoidpvpy = Height/2;
        rodando.arkanoidpvpx = Width-rodando.tamanho_arkanoidpvpx;
        rodando.arkanoidpvpy = Height/10;

        rodando.tamanhoseta = Height/9;
        rodando.tamanho_telax = Width;
        rodando.im = Bitmap.createScaledBitmap(rodando.im, Width / 10, Width / 10, true);
        rodando.fundo = Bitmap.createScaledBitmap(rodando.fundo,Width, Height, true);
        rodando.player1 = Bitmap.createScaledBitmap(rodando.player1,(int)rodando.tamanho_playerx,(int)rodando.tamanho_playery, true);
        rodando.player2 = Bitmap.createScaledBitmap(rodando.player2,(int)rodando.tamanho_playerx,(int)rodando.tamanho_playery, true);
        rodando.setadireita = Bitmap.createScaledBitmap(rodando.setadireita,(int)rodando.tamanhoseta,(int)rodando.tamanhoseta, true);
        rodando.setaesquerda = Bitmap.createScaledBitmap(rodando.setaesquerda,(int)rodando.tamanhoseta,(int)rodando.tamanhoseta, true);
        rodando.play = Bitmap.createScaledBitmap(rodando.play,(int)rodando.tamanho_play,(int)rodando.tamanho_play, true);
        rodando.bloco = Bitmap.createScaledBitmap(rodando.bloco,(int)rodando.tamanho_blocox,(int)rodando.tamanho_blocoy, true);
        rodando.sair = Bitmap.createScaledBitmap(rodando.sair,(int)rodando.setarepetir_tamanho,(int)rodando.setarepetir_tamanho, true);
        rodando.coracao= Bitmap.createScaledBitmap(rodando.coracao,(int)(rodando.tamanho_playerx/5),(int)(rodando.tamanho_playery*9)/10, true);
        rodando.coracao2 = Bitmap.createScaledBitmap(rodando.coracao2,(int)(rodando.tamanho_playerx/5),(int)(rodando.tamanho_playery*9)/10, true);
        rodando.setadireita2 = Bitmap.createScaledBitmap(rodando.setadireita2,(int)rodando.tamanhoseta,(int)rodando.tamanhoseta, true);
        rodando.setaesquerda2 = Bitmap.createScaledBitmap(rodando.setaesquerda2,(int)rodando.tamanhoseta,(int)rodando.tamanhoseta, true);
        rodando.setarepetir = Bitmap.createScaledBitmap(rodando.setarepetir,(int)rodando.setarepetir_tamanho,(int)rodando.setarepetir_tamanho, true);



    }


}
