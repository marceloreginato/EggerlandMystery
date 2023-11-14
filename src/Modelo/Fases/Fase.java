package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Blocos.Porta;
import Modelo.Blocos.Tijolo;    
import Modelo.Blocos.Numero;
import Modelo.Blocos.Lateral;
import Modelo.Hero;

public abstract class Fase { 

    /*Classe abstrata que cria o ambiente de uma Fase. Instancia os objetos
    padroes de todas as fases (Hero, Porta, Bordas e Setup Lateral).*/

    /*Instancia Porta*/
    protected Porta porta = new Porta("PortaFechada.png");

    /*Instancia Setup Lateral - Numeros*/
    protected Numero numVida = new Numero(Desenho.acessoATelaDoJogo().getVidas(), 'v');
    protected Numero numMoeda = new Numero(Desenho.acessoATelaDoJogo().getMoedas(), 'm');
    protected Numero numFase = new Numero(Desenho.acessoATelaDoJogo().getFase(), 'f');

    /*Instancia Setup Lateral - Desenhos*/
    protected Lateral herolateral = new Lateral("HeroEstaticFace.png", 'h');
    protected Lateral tirolateral = new Lateral("TiroHorizontal.png", 't');
    protected Lateral round1 = new Lateral("round1.png", 'r');
    protected Lateral round2 = new Lateral("round2.png", 'l');


    protected Fase (Hero hero) {
        /*Adiciona Hero e Porta na faseAtual da Tela. Hero eh 
        instanciado na propria Tela.*/
        Desenho.acessoATelaDoJogo().addPersonagem(hero);
        Desenho.acessoATelaDoJogo().addPersonagem(porta);

        /*Adiciona Setup Lateral na faseAtual da Tela - Numeros*/
        Desenho.acessoATelaDoJogo().addPersonagem(numVida);
        Desenho.acessoATelaDoJogo().addPersonagem(numMoeda);
        Desenho.acessoATelaDoJogo().addPersonagem(numFase);
        
        /*Adiciona Setup Lateral na faseAtual da Tela - Desenos*/
        Desenho.acessoATelaDoJogo().addPersonagem(herolateral);
        Desenho.acessoATelaDoJogo().addPersonagem(tirolateral);
        Desenho.acessoATelaDoJogo().addPersonagem(round1);
        Desenho.acessoATelaDoJogo().addPersonagem(round2);  
        

        /*Instancia e adiciona na Tela as bordas de tijolos*/   
        for (int i = 0; i < Consts.RES; i++){   
            for (int j = 0; j < Consts.RES; j++){
                if(i == 0 || j == 0 || i == Consts.RES - 1 || j == Consts.RES - 1 || j == Consts.RES - 4 || (i == 7 && j > Consts.RES - 4) || (i == 11 && j > Consts.RES - 4)){
                    Tijolo est = new Tijolo("TijoloRoxo.png");      
                    est.setPosicao(i, j);
                    Desenho.acessoATelaDoJogo().addPersonagem(est);
                }
            }
        } 
    }
}
