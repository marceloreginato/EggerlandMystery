package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase3 extends Fase{
    public Fase3 (Hero hero) {
        super(hero);
        hero.setPosicao(1, 1);
        porta.setPosicao(Consts.RES - 4, 9);

        AtiraPelaMoeda am1 = new AtiraPelaMoeda("MonstroRoxoDireita.png", hero);
        am1.setPosicao(3, 4);           
        Desenho.acessoATelaDoJogo().addPersonagem(am1);

        AtiraPelaMoeda am2 = new AtiraPelaMoeda("MonstroRoxoFrente.png", hero);
        am2.setPosicao(3, 9);           
        Desenho.acessoATelaDoJogo().addPersonagem(am2);

        AtiraPelaMoeda am3 = new AtiraPelaMoeda("MonstroRoxoTras.png", hero);
        am3.setPosicao(8, 4);           
        Desenho.acessoATelaDoJogo().addPersonagem(am3);                             

        AtiraPelaMoeda am4 = new AtiraPelaMoeda("MonstroRoxoEsquerda.png", hero);
        am4.setPosicao(8, 9);           
        Desenho.acessoATelaDoJogo().addPersonagem(am4);                        

        Coletavel moeda1 = new Coletavel("moeda.png");
        moeda1.setPosicao(5, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda1);
    }
}
