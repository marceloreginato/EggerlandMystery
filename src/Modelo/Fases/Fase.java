package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.Blocos.Porta;
import Modelo.Blocos.Tijolo;
import Modelo.Blocos.Numero;
import Modelo.Blocos.Lateral;
import Modelo.Hero;

public class Fase { 
    Porta porta = new Porta("PortaFechada.png");

    Numero numVida = new Numero(Desenho.acessoATelaDoJogo().getVidas(), 'v');
    Numero numMoeda = new Numero(Desenho.acessoATelaDoJogo().getMoedas(), 'm');
    Numero numFase = new Numero(Desenho.acessoATelaDoJogo().getFase(), 'f');

    Lateral herolateral = new Lateral("HeroEstaticFace.png", 'h');
    Lateral tirolateral = new Lateral("TiroHorizontal.png", 't');
    Lateral round1 = new Lateral("round1.png", 'r');
    Lateral round2 = new Lateral("round2.png", 'l');


    public Fase (Hero hero) {
        Desenho.acessoATelaDoJogo().addPersonagem(hero);
        Desenho.acessoATelaDoJogo().addPersonagem(porta);

        Desenho.acessoATelaDoJogo().addPersonagem(numVida);
        Desenho.acessoATelaDoJogo().addPersonagem(numMoeda);
        Desenho.acessoATelaDoJogo().addPersonagem(numFase);

        Desenho.acessoATelaDoJogo().addPersonagem(herolateral);
        Desenho.acessoATelaDoJogo().addPersonagem(tirolateral);
        Desenho.acessoATelaDoJogo().addPersonagem(round1);
        Desenho.acessoATelaDoJogo().addPersonagem(round2);


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
