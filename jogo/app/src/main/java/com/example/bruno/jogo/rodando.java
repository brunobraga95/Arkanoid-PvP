package com.example.bruno.jogo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class rodando extends ActionBarActivity implements View.OnTouchListener{

    OurView v;
    static public Bitmap im,fundo,player1,player2,setadireita,setaesquerda,setadireita2,setaesquerda2,bloco,play,setarepetir,sair;
    static public Bitmap arkanoidpvpbranco,arkanoidpvppreto,arkanoidpvpvermelho,sound,nosound,coracao,coracao2;
    static public float x1,y1,x_player1,x_player2,setadireitax,setadireitay,setaesquerdax,setaesquerday,y_player1,tamanho_arkanoidpvpx,tamanho_arkanoidpvpy;
    static public float x2,y2,y_player2,x,y,x1_anterior,y1_anterior;
    static public float setadireitax2,setadireitay2,setaesquerdax2,setaesquerday2,tamanho_play,playx,playy,arkanoidpvpx,arkanoidpvpy,sound_tamanho,soundx,soundy;

    static public float tamanhoseta,tamanho_playerx ,tamanho_playery,tamanho_telax,tamanho_bola,blocox,blocoy,tamanho_blocox,tamanho_blocoy,setarepetirx,setarepetiry,setarepetir_tamanho;
    static public boolean cima = false,direita = false,movimenta_player1_direita,movimenta_player2_direita,bloco_direita = false,comeca = false,repetir=false;
    static public int velocidade_bola = 5,aumenta_velocidade = 0,velocidade_player = 10,velocidade_bloco = 3,cor = 0;
    static public boolean movimenta_player1 = false,movimenta_player2 = false,som = true,animacao=true,iniciliza_variaveis_animacao = true,teste = false,teste2=false,comeca2=false;
    static public float sairx,sairy,animacaologo=-1,animacaoplay=-1,animacaosair=-1,animacaoplayer1,animacaoplayer2,animaseta1,animaseta2;
    static public int vida_player1,vida_player2,fps = 0;
    long startTime;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodando);
        getSupportActionBar().hide();
        v = new OurView(this);
        v.setOnTouchListener(this);
        im = BitmapFactory.decodeResource(getResources(), R.drawable.bola);
        fundo = BitmapFactory.decodeResource(getResources(), R.drawable.fundo);
        player1 = BitmapFactory.decodeResource(getResources(), R.drawable.player);
        player2 = BitmapFactory.decodeResource(getResources(), R.drawable.player2);
        setadireita = BitmapFactory.decodeResource(getResources(), R.drawable.setadireita);
        setaesquerda = BitmapFactory.decodeResource(getResources(), R.drawable.setaesquerda);
        setadireita2 = BitmapFactory.decodeResource(getResources(), R.drawable.setadireita);
        setaesquerda2 = BitmapFactory.decodeResource(getResources(), R.drawable.setaesquerda);
        bloco = BitmapFactory.decodeResource(getResources(), R.drawable.bloco);
        play = BitmapFactory.decodeResource(getResources(),R.drawable.play);
        setarepetir = BitmapFactory.decodeResource(getResources(),R.drawable.setasrepetir);
        sair = BitmapFactory.decodeResource(getResources(),R.drawable.sair);
        arkanoidpvpbranco = BitmapFactory.decodeResource(getResources(),R.drawable.arkanoidpvpbranco);
        arkanoidpvppreto = BitmapFactory.decodeResource(getResources(),R.drawable.arkanoidpvppreto);
        arkanoidpvpvermelho = BitmapFactory.decodeResource(getResources(),R.drawable.arkanoidpvpvermelho);
        coracao = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        coracao2 = BitmapFactory.decodeResource(getResources(),R.drawable.heart2);
        setContentView(v);

    }

    protected void onResume()
    {
        super.onResume();
        v.resume();
    }

    protected void onPause()
    {
        super.onPause();
        v.pause();
    }


    public class OurView extends SurfaceView implements Runnable
    {


        Thread t = null;
        SurfaceHolder holder;
        boolean isItOK = false;



        public OurView(Context context) {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {


            while(isItOK == true)
            {
                Canvas c = holder.lockCanvas();

                if(!holder.getSurface().isValid())
                {
                    continue;
                }

                if(comeca == true)
                {
                    if(comeca2 == false)
                    {
                        if(teste == false) {
                            startTime = System.currentTimeMillis();
                            teste = true;
                        } else {
                            if(teste == true && teste2 == false) {
                                fps++;
                                if(System.currentTimeMillis() - startTime >=1000 )
                                {
                                    comeca2 = true;
                                }

                            }
                        }

                    }




                    if(comeca2 == true) {

                        if(cima == false && direita == true)
                        {

                            y+=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                            x+=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                            if(x+tamanho_bola >= c.getWidth())
                            {
                                direita = false;
                            }else if(y+tamanho_bola >= y_player1 && y+tamanho_bola <=c.getHeight() && x>=x_player1 && x<=x_player1+tamanho_playerx)
                            {

                                aumenta_velocidade++;
                                cima = true;
                                direita = true;
                            }
                            else
                            {
                                if(y+tamanho_bola>= y_player1 && y+tamanho_bola <=c.getHeight() && x>=x_player1-tamanho_bola && x<=x_player1)
                                {

                                    aumenta_velocidade++;
                                    cima = true;
                                    direita = false;
                                }
                                else if(x + tamanho_bola >=blocox && x<=blocox+tamanho_blocox && y+tamanho_bola >= blocoy && y+tamanho_bola <= blocoy+tamanho_blocoy)
                                {
                                    cima = true;
                                }

                            }
                        }
                        else
                        {

                            if(cima == false && direita == false)
                            {
                                y+=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                x-=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                if(x <= 0)
                                {
                                    direita = true;
                                }else if(y+tamanho_bola >= y_player1 && y+tamanho_bola <=c.getHeight() && x>=x_player1-tamanho_bola && x<=x_player1+tamanho_playerx-tamanho_bola)
                                {

                                    aumenta_velocidade++;
                                    cima = true;
                                    direita = false;
                                }
                                else
                                {

                                    if(y+tamanho_bola >= y_player1 && y+tamanho_bola <=c.getHeight() && x>=x_player1+tamanho_playerx-tamanho_bola && x<=x_player1+tamanho_playerx)
                                    {

                                        aumenta_velocidade++;
                                        cima = true;
                                        direita = true;
                                    }
                                    else if(x + tamanho_bola >=blocox && x<=blocox+tamanho_blocox && y+tamanho_bola >= blocoy && y+tamanho_bola <= blocoy+tamanho_blocoy)
                                    {
                                        cima = true;
                                    }

                                }
                            }
                            else
                            {
                                if(cima == true && direita == true)
                                {
                                    y-=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                    x+=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                    if(x+tamanho_bola >= c.getWidth())
                                    {
                                        direita = false;
                                        cima = true;
                                    }else if(y<=tamanho_playery && x >= x_player2 && x<=x_player2+tamanho_playerx)
                                    {

                                        aumenta_velocidade++;
                                        cima = false;
                                        direita = true;
                                    }else
                                    {
                                        if(y<=tamanho_playery && x>=x_player2-tamanho_bola && x<=x_player2)
                                        {

                                            aumenta_velocidade++;
                                            cima = false;
                                            direita = false;
                                        }
                                        else if(x+tamanho_bola >=blocox && x <= blocox+tamanho_blocox && y<=blocoy+tamanho_blocoy && y>=blocoy)
                                        {

                                            cima = false;
                                        }
                                    }
                                }
                                else
                                {
                                    if(cima == true && direita == false)
                                    {
                                        y-=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                        x-=(float)((float)velocidade_bola*((float)c.getHeight()/(float)1000)*((float)60/(float)fps));
                                        if(x <= 0)
                                        {
                                            direita = true;
                                        }else if(y<= y_player2+tamanho_playery && y > 0 && x>=x_player2-tamanho_bola && x<=x_player2+tamanho_playerx-tamanho_bola)
                                        {

                                            aumenta_velocidade++;
                                            cima = false;
                                            direita = false;
                                        }
                                        else
                                        {
                                            if(y<= y_player2+tamanho_playery && y > 0 && x>x_player2+tamanho_playerx-tamanho_bola && x<=x_player2+tamanho_bola+tamanho_playerx)
                                            {

                                                aumenta_velocidade++;
                                                cima = false;
                                                direita = true;
                                            }
                                            else if(x <=blocox+tamanho_blocox && x+tamanho_bola >= blocox && y<=blocoy+tamanho_blocoy && y>=blocoy)
                                            {
                                                cima = false;
                                            }


                                        }

                                    }
                                }
                            }
                        }


                        if(aumenta_velocidade == 2 && velocidade_bola<20)
                        {
                            if(velocidade_player<15)velocidade_player++;
                            aumenta_velocidade = 0;
                            velocidade_bola++;
                        }

                        if(movimenta_player1 == true)
                        {
                            if(movimenta_player1_direita == true && x_player1+tamanho_playerx < tamanho_telax)
                            {
                                x_player1+=velocidade_player;

                           }else
                            {
                                if(x_player1 > 0)
                                {
                                    x_player1-=velocidade_player;
                                }

                            }
                            String aux = "";
                            float t;
                            if(x_player1 + tamanho_playerx/2 > c.getWidth()/2 )
                            {
                                t = (float)((float)(x_player1+(float)tamanho_playerx/(float)2- (float)c.getWidth()/(float)2)/(float)c.getWidth());
                                t = t*10000;
                                int t2 = (int)(t);
                                aux+=t2;

                                float aux3 = Integer.parseInt(aux);
                                float f = ((float)((float)aux3/(float)10000));
                                //x_player2 = (float)c.getWidth()/(float)2 - f*((float)(c.getWidth()))-(float)tamanho_playerx/(float)2;

                            }
                            else
                            {
                                t = (float)((float)c.getWidth()/(float)2 - (float)(x_player1+(float)tamanho_playerx/(float)2))/(float)c.getWidth();
                                t = t*10000;
                                int t2 = (int)(t);
                                aux+=t2;

                                float aux3 = Integer.parseInt(aux);
                                float f = ((float)((float)aux3/(float)10000));
                                //x_player2 = (float)c.getWidth()/(float)2 + f*((float)(c.getWidth()))-(float)tamanho_playerx/(float)2;

                            }

                        }

                        if(movimenta_player2 == true)
                        {
                            if(movimenta_player2_direita == true && x_player2+tamanho_playerx < tamanho_telax)x_player2+=velocidade_player;
                            else if(x_player2>=10)x_player2-=velocidade_player;
                        }

                        if(bloco_direita == false && comeca == true)
                        {
                            if(blocox>0)blocox-=velocidade_bloco;
                            else bloco_direita = true;
                        }
                        else
                        {
                            if(blocox+tamanho_blocox<c.getWidth())blocox+=velocidade_bloco;
                            else bloco_direita =false;
                        }
                        if(y>=c.getHeight())
                        {
                            vida_player1--;
                            velocidade_bola = 5;
                            velocidade_player = 10;
                            x = c.getWidth()/2 - tamanho_bola;
                            if(blocox >=c.getWidth()/2)y = blocoy+tamanho_blocoy+1;
                            else y = blocoy-1;
                            x_player1 = c.getWidth()/2 - tamanho_playerx/2;
                            x_player2 = c.getWidth()/2 - tamanho_playerx/2;
                            if(vida_player1 == 0)
                            {
                                iniciliza_variaveis_animacao = true;
                                animacao=true;
                                comeca = false;
                                repetir = true;
                            }

                        }
                        if(y<=0)
                        {
                            vida_player2--;
                            velocidade_bola = 5;
                            velocidade_player = 10;
                            x = c.getWidth()/2 - tamanho_bola;
                            if(blocox >=c.getWidth()/2)y = blocoy+tamanho_blocoy+1;
                            else y = blocoy-1;
                            x_player1 = c.getWidth()/2 - tamanho_playerx/2;
                            x_player2 = c.getWidth()/2 - tamanho_playerx/2;
                            if(vida_player2 == 0)
                            {
                                iniciliza_variaveis_animacao = true;
                                animacao=true;
                                comeca = false;
                                repetir = true;
                            }

                        }

                        c.drawBitmap(im,x,y,null);
                        c.drawBitmap(fundo,0,0,null);
                        c.drawBitmap(im,x,y,null);
                        c.drawBitmap(player1,x_player1,y_player1,null);
                        c.drawBitmap(player2,x_player2,0,null);
                        c.drawBitmap(setadireita,setadireitax,setadireitay,null);
                        c.drawBitmap(setaesquerda,setaesquerdax,setaesquerday,null);
                        c.drawBitmap(setadireita2,setadireitax2,setadireitay2,null);
                        c.drawBitmap(setaesquerda2,setaesquerdax2,setaesquerday2,null);
                        c.drawBitmap(bloco,blocox,blocoy,null);
                        for(int i=0;i<vida_player1;i++)
                        {
                            c.drawBitmap(coracao,(int)(x_player1+(i*tamanho_playerx)/4),y_player1,null);
                        }
                        for(int i=0;i<vida_player2;i++)
                        {
                            c.drawBitmap(coracao2,(int)(x_player2+(i*tamanho_playerx)/4),0,null);
                        }

                    }


                }
                else
                {

                    iniciliaza_variaveis t = new iniciliaza_variaveis(c.getWidth(),c.getHeight());

                    c.drawBitmap(fundo, 0, 0, null);
                    if(!animacao)
                    {
                        c.drawBitmap(player1,x_player1,y_player1,null);
                        c.drawBitmap(player2,x_player2,0,null);
                        c.drawBitmap(setadireita,setadireitax,setadireitay,null);
                        c.drawBitmap(setaesquerda,setaesquerdax,setaesquerday,null);
                        c.drawBitmap(setadireita2,setadireitax2,setadireitay2,null);
                        c.drawBitmap(setaesquerda2,setaesquerdax2,setaesquerday2,null);
                        c.drawBitmap(sair,sairx,sairy,null);
                        for(int i=0;i<vida_player1;i++)
                        {
                            c.drawBitmap(coracao,(int)(x_player1+(i*tamanho_playerx)/4),y_player1,null);
                        }
                    }
                    else
                    {
                        if(iniciliza_variaveis_animacao)
                        {
                            animacaosair = c.getWidth();
                            animacaoplayer1=-tamanho_playerx;
                            animacaoplayer2=c.getWidth();
                            iniciliza_variaveis_animacao=false;
                            animaseta1 = c.getHeight();
                            animaseta2 = -tamanhoseta;
                        }
                        c.drawBitmap(player1,animacaoplayer1,y_player1,null);
                        c.drawBitmap(player2,animacaoplayer2,0,null);
                        c.drawBitmap(setadireita,setadireitax,animaseta1,null);
                        c.drawBitmap(setaesquerda,setaesquerdax,animaseta1,null);
                        c.drawBitmap(setadireita2,setadireitax2,animaseta2,null);
                        c.drawBitmap(setaesquerda2,setaesquerdax2,animaseta2,null);
                        c.drawBitmap(sair,animacaosair,sairy,null);
                        if(animacaosair>sairx)animacaosair-=20;
                        if(animacaoplayer1<x_player1)animacaoplayer1+=20;
                        if(animacaoplayer2>x_player2)animacaoplayer2-=20;
                        if(animaseta2<setaesquerday)animaseta2+=40;
                        if(animaseta1>setaesquerday2)animaseta1-=40;


                    }


                    if(cor == 0)
                    {
                        arkanoidpvpbranco = Bitmap.createScaledBitmap(arkanoidpvpbranco,(int)tamanho_arkanoidpvpx,(int)tamanho_arkanoidpvpy, true);
                        c.drawBitmap(arkanoidpvpbranco,arkanoidpvpx,arkanoidpvpy,null);
                        cor++;
                    }
                    else
                    {
                        if(cor == 1)
                        {
                            arkanoidpvppreto = Bitmap.createScaledBitmap(arkanoidpvpbranco,(int)tamanho_arkanoidpvpx,(int)tamanho_arkanoidpvpy, true);
                            c.drawBitmap(arkanoidpvppreto,arkanoidpvpx,arkanoidpvpy,null);
                            cor++;

                        }
                        else
                        {
                            arkanoidpvpvermelho = Bitmap.createScaledBitmap(arkanoidpvpvermelho,(int)tamanho_arkanoidpvpx,(int)tamanho_arkanoidpvpy, true);
                            c.drawBitmap(arkanoidpvpvermelho,arkanoidpvpx,arkanoidpvpy,null);
                            cor = 0;
                        }
                    }
                    if(repetir == false)c.drawBitmap(play,playx,playy,null);
                    else
                    {

                        c.drawBitmap(setarepetir,setarepetirx,setarepetiry,null);
                    }

                }


                holder.unlockCanvasAndPost(c);

            }
        }

        public void pause()
        {
            isItOK = false;
            while(true)
            {
                try{
                    t.join();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                break;
            }
            t = null;
        }

        public void resume()
        {
            isItOK = true;
            t = new Thread(this);

            t.start();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rodando, menu);
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(comeca == true) {
            for (int i = 0; i < event.getPointerCount(); i++) {

                x1 = event.getX(i);
                y1 = event.getY(i);

                switch (event.getActionMasked()) {

                    case MotionEvent.ACTION_DOWN:
                        if (x1 >= setadireitax && x1 <= setadireitax + tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = true;
                            movimenta_player1_direita = true;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = true;
                            movimenta_player1_direita = false;
                        }

                        if (x1 >= setadireitax2 && x1 <= setadireitax2 + tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = true;
                            movimenta_player2_direita = true;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = true;
                            movimenta_player2_direita = false;
                        }

                        break;
                    case MotionEvent.ACTION_UP:
                        if (x1 >= setadireitax && x1 <= setadireitax + tamanhoseta && y1 >= setadireitay) {
                            movimenta_player1 = false;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = false;

                        }

                        if (x1 >= setadireitax2 && x1 <= setadireitax2 + tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = false;


                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = false;

                        }

                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        if (x1 >= setadireitax && x1 <= setadireitax + tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = true;
                            movimenta_player1_direita = true;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = true;
                            movimenta_player1_direita = false;
                        }

                        if (x1 >= setadireitax2 && x1 <= setadireitax2 + tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = true;
                            movimenta_player2_direita = true;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = true;
                            movimenta_player2_direita = false;
                        }
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        if (x1 >= setadireitax && x1 <= setadireitax + tamanhoseta && y1 >= setadireitay) {
                            movimenta_player1 = false;

                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay && y1 <= setadireitay + tamanhoseta) {
                            movimenta_player1 = false;

                        }

                        if (x1 >= setadireitax2 && x1 <= setadireitax2 + tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = false;


                        }

                        if (x1 >= 0 && x1 <= tamanhoseta && y1 >= setadireitay2 && y1 <= setadireitay2 + tamanhoseta) {
                            movimenta_player2 = false;

                        }

                        break;


                }
            }
        }
        else
        {
            x1 = event.getX();
            y1 = event.getY();
            if(x1 > playx && x1 < playx+tamanho_play && y1 > playy && y1 < playy+tamanho_play)
            {
                comeca = true;

            }
            else if(x1 > sairx && x1 < sairx+tamanho_play && y1 > sairy && y1 < sairy+tamanho_play)
            {
                System.exit(1);
            }

        }
        return true;
    }


}