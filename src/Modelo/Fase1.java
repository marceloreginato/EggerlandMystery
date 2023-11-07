package Modelo;
import Auxiliar.Consts;

public class Fase1 extends Fase {
    
    public Fase1(){
        // hero.setPosicao(1, 1);
        // fase.add(hero);

        for(int i = 2; i < Consts.RES - 3; i++){
            Estatico brick3 = new Estatico("bricks.png");
            brick3.setPosicao(i, 3);
            fase.add(brick3);
            Estatico brick5 = new Estatico("bricks.png");
            brick5.setPosicao(i, 5);
            fase.add(brick5);
        }

        for(int i = 4; i < Consts.RES - 4; i++){
            if(i == Consts.RES/2)
                continue;
            Estatico brick11 = new Estatico("bricks.png");
            brick11.setPosicao(i, 11);
            fase.add(brick11);
            Estatico brick9 = new Estatico("bricks.png");
            brick9.setPosicao(i, 9);
            fase.add(brick9);
        }

        for(int j = 7; j < 9; j++){
            Estatico bricktop = new Estatico("bricks.png");
            bricktop.setPosicao(2, j);
            fase.add(bricktop);
        }   
    }
}
