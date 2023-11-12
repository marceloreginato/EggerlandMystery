package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase2 extends Fase {
    public Fase2 (Hero hero) {
        super(hero);
        hero.setPosicao(3, 9);
        porta.setPosicao(Consts.RES - 4, 9);

        for(int i = 2; i < Consts.RES - 4; i++){
            Estatico brick2 = new Estatico("bricks.png");
            brick2.setPosicao(i, 2);
            Desenho.acessoATelaDoJogo().addPersonagem(brick2);
            Estatico brick4 = new Estatico("bricks.png");
            brick4.setPosicao(i, 4);
            Desenho.acessoATelaDoJogo().addPersonagem(brick4);
            Estatico brick6 = new Estatico("bricks.png");
            brick6.setPosicao(i, 6);
            Desenho.acessoATelaDoJogo().addPersonagem(brick6);
        }

        for(int i = 2; i < Consts.RES - 4; i++){
            if(i == Consts.RES/2)
                continue;
            Estatico brick8 = new Estatico("bricks.png");
            brick8.setPosicao(i, 8);
            Desenho.acessoATelaDoJogo().addPersonagem(brick8);
            Estatico brick10 = new Estatico("bricks.png");
            brick10.setPosicao(i, 10);
            Desenho.acessoATelaDoJogo().addPersonagem(brick10);
        }

        for(int j = 7; j < 9; j++){
            Estatico bricktop = new Estatico("bricks.png");
            bricktop.setPosicao(2, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
        }

        ZigueZague zz1 = new ZigueZague("caveira.png");
        zz1.setPosicao(8, 7);
        Desenho.acessoATelaDoJogo().addPersonagem(zz1);
    }
}
