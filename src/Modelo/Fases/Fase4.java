package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Hero; 
import Modelo.Blocos.Coletavel;
import Modelo.Blocos.Empurravel;
import Modelo.Blocos.Tijolo;
import Modelo.Inimigo.AtiraNaVisao;

public class Fase4 extends Fase {   
    
    /*Classe que herda de Fase e define o ambiente da Fase 4.
    Criar um objeto refere-se a instancia-lo e adiciona-lo a
    faseAtual da Tela.*/

    public Fase4 (Hero hero) {
        super(hero);

        /*Define posicao do Hero e da Porta*/
        hero.setPosicao(4, 6);
        porta.setPosicao(Consts.RES - 3, 6);    

        /*Cria inimigos da fase*/
        for(int j = 3; j < 9; j += 5){
            AtiraNaVisao atv = new AtiraNaVisao("PlantinhaDormindo", hero);
            atv.setPosicao(Consts.RES - 8, j);
            Desenho.acessoATelaDoJogo().addPersonagem(atv);
        }
    
        /*Cria Tijolos da fase*/
        for(int j = 2; j < Consts.RES - 5; j++){
            if(j == 6 || j == 5)
                continue;
            Tijolo brick = new Tijolo("TijoloRoxo.png");
            brick.setPosicao(Consts.RES - 7, j);
            Desenho.acessoATelaDoJogo().addPersonagem(brick);
        }   
        
        /*Cria caixas empurraveis da fase*/
        Empurravel emp1 = new Empurravel("caixa.png");
        emp1.setPosicao(Consts.RES - 7, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(emp1);

        Empurravel emp2 = new Empurravel("caixa.png");
        emp2.setPosicao(Consts.RES - 7, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(emp2);


        Empurravel emp3 = new Empurravel("caixa.png");
        emp3.setPosicao(5, 2);
        Desenho.acessoATelaDoJogo().addPersonagem(emp3);

        Empurravel emp4 = new Empurravel("caixa.png");
        emp4.setPosicao(6, 2);
        Desenho.acessoATelaDoJogo().addPersonagem(emp4);

        Empurravel emp5 = new Empurravel("caixa.png");
        emp5.setPosicao(5, Consts.RES - 6);
        Desenho.acessoATelaDoJogo().addPersonagem(emp5);

        Empurravel empmeio = new Empurravel("caixa.png");
        empmeio.setPosicao(6, Consts.RES - 6);  
        Desenho.acessoATelaDoJogo().addPersonagem(empmeio); 


        /*Cria moedas da fase*/
        for(int j = 3; j < 9; j += 5){  
            Coletavel col1 = new Coletavel("moeda.png");
            col1.setPosicao(3, j);
            Desenho.acessoATelaDoJogo().addPersonagem(col1);
        }

        for(int j = 5; j < 7; j++){  
            Coletavel col2 = new Coletavel("moeda.png");
            col2.setPosicao(Consts.RES - 8, j);
            Desenho.acessoATelaDoJogo().addPersonagem(col2);
        }

    }
}
