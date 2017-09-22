package com.example.alfredosalvador.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final Random generator = new Random();
    List<Pokemon> lista = new ArrayList<>();
    private ImageView imgCharizard, imgCharmander, imgBullbasour,imgUsuario,imgComputer;
    private Button btnJugar, btnResetear;
    TextView txtAtaqueUsuario, txtTipoUsuario, txtTipoComputer,txtAtaqueComputer;

    Pokemon usuario = new Pokemon();
    Pokemon computer = new Pokemon();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBullbasour = (ImageView) findViewById(R.id.idBullbasour);
        imgCharizard = (ImageView) findViewById(R.id.idCharizard);
        imgCharmander = (ImageView) findViewById(R.id.idCharmander);
        btnJugar = (Button) findViewById(R.id.btnJugar);
        btnResetear = (Button) findViewById(R.id.btnResetear);
        imgComputer = (ImageView) findViewById(R.id.imgSistema);
        imgUsuario = (ImageView) findViewById(R.id.imgUsuario);

        txtTipoUsuario = (TextView) findViewById(R.id.tipoUsuario);
        //txtAtaqueUsuario = (TextView) findViewById(R.id.ataqueUsuario);
        txtTipoComputer = (TextView) findViewById(R.id.tipoComputer);
        //txtAtaqueComputer = (TextView) findViewById(R.id.ataqueComputer) ;




        lista.add(new Pokemon(1,"Enredadera","Hierba",600,500,1000,R.drawable.bullbasour));
        lista.add(new Pokemon(2,"Lanza Llamas","Fuego",400,800,1000,R.drawable.charmander));
        lista.add(new Pokemon(3,"Lanza Llamas","Fuego",800,1300,800,R.drawable.charizard));


        imgCharmander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuario = lista.get(1);
                imgUsuario.setImageResource(usuario.getFoto());
                txtTipoUsuario.setText(usuario.getTipo());
                //txtAtaqueUsuario.setText(usuario.getAtaque());
            }
        });

        imgCharizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = lista.get(2);
                imgUsuario.setImageResource(usuario.getFoto());
                txtTipoUsuario.setText(usuario.getTipo());
                //txtAtaqueUsuario.setText(usuario.getAtaque());
            }
        });

        imgBullbasour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = lista.get(0);
                imgUsuario.setImageResource(usuario.getFoto());
                txtTipoUsuario.setText(usuario.getTipo());
                //txtAtaqueUsuario.setText(usuario.getAtaque());
            }
        });

    }


    public void Ganador(Pokemon usuario, Pokemon computer){

        int resUsuario = usuario.getDefensa()+ usuario.getVida();
        int resComputer = computer.getDefensa()+computer.getVida();
        int lifeUser = resUsuario - computer.getAtaque();
        int lifeComputer = resComputer - usuario.getAtaque();

        if (lifeUser > lifeComputer){
            Toast.makeText(this, "Ganaste!!!!", Toast.LENGTH_SHORT).show();
        }else if (lifeUser == lifeComputer){
            Toast.makeText(this, "Esto es un empate", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Perdiste!!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnJugar: Jugar();
                break;
            case R.id.btnResetear: Resetear();
                break;
        }
    }

    private void Resetear() {
        usuario = null;
        computer = null;
        imgUsuario.setImageResource(R.drawable.incognita);
        imgComputer.setImageResource(R.drawable.incognita);
        txtTipoComputer.setText("");
        txtTipoUsuario.setText("");
    }

    private void Jugar() {

        computer=pokeAleatorio();
        if(usuario!=null){
            imgComputer.setImageResource(computer.getFoto());
            txtTipoComputer.setText(computer.getTipo());
            //txtAtaqueComputer.setText(computer.getAtaque());

            //Calcular
            Ganador(usuario,computer);
        }else {
            Toast.makeText(MainActivity.this, "Seleccione un Pokemon", Toast.LENGTH_SHORT).show();
        }
    }

    private Pokemon pokeAleatorio(){
        Pokemon poke_computer = lista.get(generator.nextInt(lista.size()));
        return poke_computer;
    }
}
