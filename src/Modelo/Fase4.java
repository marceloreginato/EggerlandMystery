package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase4 extends Fase {
    public Fase4(Hero hero){
        super(hero);
        hero.setPosicao(4, 6);
        porta.setPosicao(Consts.RES - 3, 6);

        for(int j = 4; j < 9; j += 4){
            AtiraNaVisao atv = new AtiraNaVisao("PlantinhaDormindo", hero);
            atv.setPosicao(Consts.RES - 8, j);
            Desenho.acessoATelaDoJogo().addPersonagem(atv);
        }
    
        for(int j = 2; j < Consts.RES - 5; j++){
            if(j == 6)
                continue;
            Estatico brick = new Estatico("bricks.png");
            brick.setPosicao(Consts.RES - 7, j);
            Desenho.acessoATelaDoJogo().addPersonagem(brick);
        }   
        
        Empurravel emp1 = new Empurravel("caixa.png");
        emp1.setPosicao(Consts.RES - 7, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(emp1);

        Empurravel emp2 = new Empurravel("caixa.png");
        emp2.setPosicao(5, 2);
        Desenho.acessoATelaDoJogo().addPersonagem(emp2);

        Empurravel emp3 = new Empurravel("caixa.png");
        emp3.setPosicao(6, 2);
        Desenho.acessoATelaDoJogo().addPersonagem(emp3);

        Empurravel emp4 = new Empurravel("caixa.png");
        emp4.setPosicao(5, Consts.RES - 6);
        Desenho.acessoATelaDoJogo().addPersonagem(emp4);

        Empurravel empmeio = new Empurravel("caixa.png");
        empmeio.setPosicao(6, Consts.RES - 6);
        Desenho.acessoATelaDoJogo().addPersonagem(empmeio);

        for(int j = 4; j < 9; j += 4){
            Coletavel col1 = new Coletavel("moeda.png");
            col1.setPosicao(3, j);
            Desenho.acessoATelaDoJogo().addPersonagem(col1);
        }

        Coletavel col2 = new Coletavel("moeda.png");
        col2.setPosicao(Consts.RES - 8, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(col2);

    }
}
