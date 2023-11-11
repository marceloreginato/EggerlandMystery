package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase1 extends Fase {
    // Porta porta;

    public Fase1 (Hero hero) {

        super(hero);

        // porta = new Porta("Porta.png");
        // porta.setPosicao();
        // Desenho.acessoATelaDoJogo().addPersonagem(porta);

        for(int i = 2; i < Consts.RES - 2; i++){
            Estatico brick3 = new Estatico("bricks.png");
            brick3.setPosicao(i, 2);
            Desenho.acessoATelaDoJogo().addPersonagem(brick3);
            Estatico brick7 = new Estatico("bricks.png");
            brick7.setPosicao(i, 6);
            Desenho.acessoATelaDoJogo().addPersonagem(brick7);
            Estatico brick11 = new Estatico("bricks.png");
            brick11.setPosicao(i, 10);
            Desenho.acessoATelaDoJogo().addPersonagem(brick11);
        }

        for(int i = 1; i < Consts.RES - 1; i++){
            if(i == Consts.RES/2)
                continue;
            Estatico brick5 = new Estatico("bricks.png");
            brick5.setPosicao(i, 4);
            Desenho.acessoATelaDoJogo().addPersonagem(brick5);
            Estatico brick9 = new Estatico("bricks.png");
            brick9.setPosicao(i, 8);
            Desenho.acessoATelaDoJogo().addPersonagem(brick9);
        }

        for(int j = 6; j < 8; j++){
            Estatico bricktop = new Estatico("bricks.png");
            bricktop.setPosicao(1, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
        }   

        for(int z = 3; z < 10; z = z+4){
            Empurravel emp1 = new Empurravel("caixa.png");
            emp1.setPosicao(Consts.RES/2 - 2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(emp1);
            Empurravel emp2 = new Empurravel("caixa.png");
            emp2.setPosicao(Consts.RES/2 - 1, z);
            Desenho.acessoATelaDoJogo().addPersonagem(emp2);
            Empurravel emp = new Empurravel("caixa.png");
            emp.setPosicao(Consts.RES/2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(emp);
            Coletavel moeda = new Coletavel("moeda.png");
            moeda.setPosicao((Consts.RES/2)+1, z);
            Desenho.acessoATelaDoJogo().addPersonagem(moeda);
        }

        for(int z = 2; z < 7; z = z+4){
            Inimigo inimigo = new Inimigo("skoot.png");
            inimigo.setPosicao(Consts.RES - 2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(inimigo);
        }

        Inimigo inimigo = new Inimigo("skoot.png");
        inimigo.setPosicao(Consts.RES/2, 1);
        Desenho.acessoATelaDoJogo().addPersonagem(inimigo);

        Coletavel moeda = new Coletavel("moeda.png");
        moeda.setPosicao(2, 1);
        // moeda.setPosicao((Consts.RES/2)-1, 3);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda);

    }
}
