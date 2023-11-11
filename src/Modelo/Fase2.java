package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase2 extends Fase {
    // Porta porta;

    public Fase2 (Hero hero) {
        super(hero);

        // porta = new Porta("Porta.png");
        // porta.setPosicao();
        // Desenho.acessoATelaDoJogo().addPersonagem(porta);

        for(int i = 2; i < Consts.RES - 3; i++){
            Estatico brick3 = new Estatico("bricks.png");
            brick3.setPosicao(i, 3);
            Desenho.acessoATelaDoJogo().addPersonagem(brick3);
            Estatico brick5 = new Estatico("bricks.png");
            brick5.setPosicao(i, 5);
            Desenho.acessoATelaDoJogo().addPersonagem(brick5);
        }

        for(int i = 4; i < Consts.RES - 4; i++){
            if(i == Consts.RES/2)
                continue;
            Estatico brick11 = new Estatico("bricks.png");
            brick11.setPosicao(i, 11);
            Desenho.acessoATelaDoJogo().addPersonagem(brick11);
            Estatico brick9 = new Estatico("bricks.png");
            brick9.setPosicao(i, 9);
            Desenho.acessoATelaDoJogo().addPersonagem(brick9);
        }

        for(int j = 7; j < 9; j++){
            Estatico bricktop = new Estatico("bricks.png");
            bricktop.setPosicao(2, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
        }

        ZigueZague zz1 = new ZigueZague("robo.png");
        zz1.setPosicao(8, 7);
        Desenho.acessoATelaDoJogo().addPersonagem(zz1);
    }
}
