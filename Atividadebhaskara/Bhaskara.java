package com.blogspot.rafaelneves17.bhaskara1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Bhaskara extends AppCompatActivity implements View.OnClickListener{

    private AdView adView;

    private EditText edtvalor1;
    private EditText edtvalor2;
    private EditText edtvalor3;

    private Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhaskara);

        adView =(AdView) findViewById(R.id.adBanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        edtvalor1 = (EditText) findViewById(R.id.edtvalor1);
        edtvalor2 = (EditText) findViewById(R.id.edtvalor2);
        edtvalor3 = (EditText) findViewById(R.id.edtvalor3);
        btncalcular = (Button) findViewById(R.id.btncalcular);

        btncalcular.setOnClickListener(this);


    }

    public void onClick(View v) {


        String v1 = edtvalor1.getText().toString();
        String v2 = edtvalor2.getText().toString();
        String v3 = edtvalor3.getText().toString();

        if (v1.trim().isEmpty() || v2.trim().isEmpty()  || v3.trim().isEmpty()) {


            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Há dados em branco :");
            dlg.setNeutralButton("OK", null);
            dlg.show();


        } else {
            double valor1 = Double.parseDouble(edtvalor1.getText().toString());
            double valor2 = Double.parseDouble(edtvalor2.getText().toString());
            double valor3 = Double.parseDouble(edtvalor3.getText().toString());

            if(valor1==0){
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("ERRO: VALOR DE 'A' TEM QUE SER DIFERENTE DE 0");
                dlg.setNeutralButton("OK", null);
                dlg.show();



            }
            else {
                double x1,x2,xa ,xb;
                double DELTA;
                DELTA = ((Math.pow(valor2,2))-(4*(valor1*valor3)));
                if(DELTA<0){

                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("ERROR: Δ menor que 0 \nΔ=-b²-4.a.c \nΔ="+(Math.pow(valor2,2))+"-4.("+valor1+").("+valor3+")\nΔ=" +DELTA);


                    dlg.setNeutralButton("OK", null);
                    dlg.show();


                }
                else{
                    x1=( ((-valor2)+(Math.sqrt(DELTA))) / (2*valor1) );
                    xa=((-valor2)+(Math.sqrt(DELTA)));

                    x2=( ((-valor2)-(Math.sqrt(DELTA))) / (2*valor1) );
                    xb=((-valor2)-(Math.sqrt(DELTA)));



                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setMessage("Δ=(-b)² -4.a.c \nΔ=("+(Math.pow(valor2,2))+")(-4.("+valor1+").("+valor3+"))\nΔ="+DELTA+"\n\n\n X= -b ±√Δ / 2.(a) \n X=("+ -valor2 +  " ± √ " + DELTA +") / 2.("+valor1+")\n X=("+valor1+" ± "+Math.sqrt(DELTA)+")/"+2*valor1+"\n\n X1 = "+xa+"/"+2*valor1+"\n X1="+x1+"\n\n X2="+xb+"/"+2*valor1+"\n X2="+x2);
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
            }
        }
    }




    @Override
    public void onPause() {

        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume (){
        super.onResume();
        if(adView !=null){
            adView.resume();
        }
    }
    @Override
    public void onDestroy(){
        if(adView!=null){
            adView.destroy();
        }
        super.onDestroy();

    }



}
