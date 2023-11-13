package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Hero;
import Modelo.Blocos.Coletavel; 
import Modelo.Blocos.Empurravel;
import Modelo.Blocos.Estatico;
import Modelo.Blocos.Tijolo;        
import Modelo.Inimigo.ZigueZague;

public class Fase2 extends Fase {
    public Fase2 (Hero hero) {
        super(hero);
        hero.setPosicao(3, 9);
        porta.setPosicao(Consts.RES - 4, 9);

        for(int i = 2; i < Consts.RES - 3; i++){
            Tijolo brick2 = new Tijolo("bricks.png");
            brick2.setPosicao(i, 2);
            Desenho.acessoATelaDoJogo().addPersonagem(brick2);
            Tijolo brick4 = new Tijolo("bricks.png");
            brick4.setPosicao(i, 4);
            Desenho.acessoATelaDoJogo().addPersonagem(brick4);
            Tijolo brick6 = new Tijolo("bricks.png");
            if(i == Consts.RES/2 + 1) 
                continue;
            brick6.setPosicao(i, 6);
            Desenho.acessoATelaDoJogo().addPersonagem(brick6);
        }

        for(int i = 2; i < Consts.RES - 3; i++){
            if(i == Consts.RES/2 || i == 3)
                continue;
            Tijolo brick8 = new Tijolo("bricks.png");
            brick8.setPosicao(i, 8);
            Desenho.acessoATelaDoJogo().addPersonagem(brick8);
        }

        for(int j = 8; j < 11; j++){
            Tijolo bricktop = new Tijolo("bricks.png");
            bricktop.setPosicao(1, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
            if(j == 10)
                continue;
            Tijolo brickbottom = new Tijolo("bricks.png");
            brickbottom.setPosicao(Consts.RES - 3, j);
            Desenho.acessoATelaDoJogo().addPersonagem(brickbottom);
        }

        Tijolo bricktop = new Tijolo("bricks.png");
        bricktop.setPosicao(2, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(bricktop);

        Tijolo brickbottom = new Tijolo("bricks.png");
        brickbottom.setPosicao(Consts.RES - 3, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(brickbottom);

        for(int j = 5; j < 8; j+=2){
            ZigueZague zz = new ZigueZague("caveira.png");
            zz.setPosicao(Consts.RES/2, j);
            Desenho.acessoATelaDoJogo().addPersonagem(zz);
        }

        Empurravel emp31 = new Empurravel("caixa.png");
        emp31.setPosicao(Consts.RES-4, 3);
        Desenho.acessoATelaDoJogo().addPersonagem(emp31);

        Empurravel emp32 = new Empurravel("caixa.png");
        emp32.setPosicao(Consts.RES-2, 3);
        Desenho.acessoATelaDoJogo().addPersonagem(emp32);

        Empurravel emp6 = new Empurravel("caixa.png");
        emp6.setPosicao(Consts.RES/2 + 1, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(emp6);

        Empurravel emp8 = new Empurravel("caixa.png");
        emp8.setPosicao(3, 8);
        Desenho.acessoATelaDoJogo().addPersonagem(emp8);

        Empurravel emp9 = new Empurravel("caixa.png");
        emp9.setPosicao(Consts.RES/2, 9);
        Desenho.acessoATelaDoJogo().addPersonagem(emp9);

        for(int i = 1; i < Consts.RES; i+=11){
            Coletavel col1 = new Coletavel("moeda.png");
            col1.setPosicao(i, 3);
            Desenho.acessoATelaDoJogo().addPersonagem(col1);
        }

        for(int i = 1; i < Consts.RES; i+=12){
            Coletavel col2 = new Coletavel("moeda.png");
            col2.setPosicao(i, 7);
            Desenho.acessoATelaDoJogo().addPersonagem(col2);
        }

        Coletavel col3 = new Coletavel("moeda.png");
        col3.setPosicao(Consts.RES/2 + 1, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(col3);
        
    }
}
