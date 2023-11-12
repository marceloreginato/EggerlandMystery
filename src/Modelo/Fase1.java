package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase1 extends Fase {
    public Fase1 (Hero hero) {
        super(hero);
        hero.setPosicao(1, 1);
        porta.setPosicao(Consts.RES/2, 9);

        for(int i = 2; i < Consts.RES - 2; i++){
            Estatico brick2 = new Estatico("bricks.png");
            brick2.setPosicao(i, 2);
            Desenho.acessoATelaDoJogo().addPersonagem(brick2);
            Estatico brick6 = new Estatico("bricks.png");
            brick6.setPosicao(i, 6);
            Desenho.acessoATelaDoJogo().addPersonagem(brick6);
        }

        for(int i = 1; i < Consts.RES - 1; i++){
            if(i == Consts.RES/2)
                continue;
            Estatico brick4 = new Estatico("bricks.png");
            brick4.setPosicao(i, 4);
            Desenho.acessoATelaDoJogo().addPersonagem(brick4);
            Estatico brick8 = new Estatico("bricks.png");
            brick8.setPosicao(i, 8);
            Desenho.acessoATelaDoJogo().addPersonagem(brick8);
        }

        for(int j = 6; j < 8; j++){
            Estatico bricktop = new Estatico("bricks.png");
            bricktop.setPosicao(1, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
        }   

        for(int i = 8; i < 9; i++){
            Estatico brick9 = new Estatico("bricks.png");
            brick9.setPosicao(i, 9);
            Desenho.acessoATelaDoJogo().addPersonagem(brick9);
        }

        for(int z = 3; z < 10; z = z+4){
            Empurravel emp = new Empurravel("caixa.png");
            emp.setPosicao(Consts.RES/2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(emp);
            Coletavel moeda = new Coletavel("moeda.png");
            moeda.setPosicao((Consts.RES/2)+1, z);
            Desenho.acessoATelaDoJogo().addPersonagem(moeda);
        }

        for(int z = 2; z < 7; z = z+4){
            Inimigo inimigo = new Inimigo("MonstroVerde.png");
            inimigo.setPosicao(Consts.RES - 2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(inimigo);
        }

        Inimigo inimigo = new Inimigo("caveira.png");
        inimigo.setPosicao(Consts.RES - 6, 10);
        Desenho.acessoATelaDoJogo().addPersonagem(inimigo);

        for(int i = Consts.RES - 5 ; i < Consts.RES - 3; i++){
            Coletavel moeda = new Coletavel("moeda.png");
            moeda.setPosicao(i, 10);
            Desenho.acessoATelaDoJogo().addPersonagem(moeda);
        }
        
        Coletavel moeda = new Coletavel("moeda.png");
        moeda.setPosicao((Consts.RES/2) - 1, 3);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda);

    }
}
