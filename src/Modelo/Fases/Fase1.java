package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Hero;
import Modelo.Blocos.Coletavel;
import Modelo.Blocos.Empurravel;
import Modelo.Blocos.Estatico;
import Modelo.Blocos.Tijolo;
import Modelo.Inimigo.Inimigo;

public class Fase1 extends Fase {

    /*Classe que herda de Fase e define o ambiente da Fase 1.
    Criar um objeto refere-se a instancia-lo e adiciona-lo a
    faseAtual da Tela.*/

    public Fase1 (Hero hero) {
        super(hero);

        /*Define posicao do Hero e da Porta*/
        hero.setPosicao(1, 1);
        porta.setPosicao(Consts.RES/2, 9);

        /*Cria Tijolos da fase*/
        for(int i = 2; i < Consts.RES - 2; i++){
            Tijolo brick2 = new Tijolo("bricks.png");
            brick2.setPosicao(i, 2);
            Desenho.acessoATelaDoJogo().addPersonagem(brick2);
            Tijolo brick6 = new Tijolo("bricks.png");
            brick6.setPosicao(i, 6);
            Desenho.acessoATelaDoJogo().addPersonagem(brick6);
        }

        for(int i = 1; i < Consts.RES - 1; i++){
            if(i == Consts.RES/2)
                continue;
            Tijolo brick4 = new Tijolo("bricks.png");
            brick4.setPosicao(i, 4);
            Desenho.acessoATelaDoJogo().addPersonagem(brick4);
            Tijolo brick8 = new Tijolo("bricks.png");
            brick8.setPosicao(i, 8);
            Desenho.acessoATelaDoJogo().addPersonagem(brick8);
        }

        for(int j = 6; j < 8; j++){
            Tijolo bricktop = new Tijolo("bricks.png");
            bricktop.setPosicao(1, j);
            Desenho.acessoATelaDoJogo().addPersonagem(bricktop);
        }   

        for(int i = 8; i < 9; i++){
            Tijolo brick9 = new Tijolo("bricks.png");
            brick9.setPosicao(i, 9);
            Desenho.acessoATelaDoJogo().addPersonagem(brick9);
        }

        /*Cria caixas empurraveis e moedas da fase*/
        for(int z = 3; z < 10; z = z+4){
            Empurravel emp = new Empurravel("caixa.png");
            emp.setPosicao(Consts.RES/2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(emp);
            Coletavel moeda = new Coletavel("moeda.png");
            moeda.setPosicao((Consts.RES/2)+1, z);
            Desenho.acessoATelaDoJogo().addPersonagem(moeda);
        }

        /*Cria inimigos da fase*/
        for(int z = 2; z < 7; z = z+4){
            Inimigo inimigo = new Inimigo("MonstroVerde.png");
            inimigo.setPosicao(Consts.RES - 2, z);
            Desenho.acessoATelaDoJogo().addPersonagem(inimigo);
        }

        Inimigo inimigo = new Inimigo("MonstroVerde.png");
        inimigo.setPosicao(Consts.RES - 6, 10);
        Desenho.acessoATelaDoJogo().addPersonagem(inimigo);

        /*Cria moedas da fase*/
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
