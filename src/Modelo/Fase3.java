package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase3 extends Fase{
    public Fase3 (Hero hero) {
        super(hero);
        hero.setPosicao(2, 2);
        porta.setPosicao(Consts.RES - 3, 9);

        AtiraPelaMoeda am1 = new AtiraPelaMoeda("MonstroRoxoDireita.png", hero);
        am1.setPosicao(4, 3);           
        Desenho.acessoATelaDoJogo().addPersonagem(am1);

        AtiraPelaMoeda am2 = new AtiraPelaMoeda("MonstroRoxoFrente.png", hero);
        am2.setPosicao(4, 8);            
        Desenho.acessoATelaDoJogo().addPersonagem(am2);

        AtiraPelaMoeda am3 = new AtiraPelaMoeda("MonstroRoxoTras.png", hero);
        am3.setPosicao(9, 3);           
        Desenho.acessoATelaDoJogo().addPersonagem(am3);                             

        AtiraPelaMoeda am4 = new AtiraPelaMoeda("MonstroRoxoEsquerda.png", hero);
        am4.setPosicao(9, 8);           
        Desenho.acessoATelaDoJogo().addPersonagem(am4);

        Empurravel emp = new Empurravel("caixa.png");
        emp.setPosicao(Consts.RES - 3, 8);
        Desenho.acessoATelaDoJogo().addPersonagem(emp);                        

        Coletavel moeda1 = new Coletavel("moeda.png");
        moeda1.setPosicao(6, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda1);
    }
}
