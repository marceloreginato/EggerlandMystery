package Modelo.Fases;

import Auxiliar.Consts;
import Auxiliar.Desenho;    
import Modelo.Inimigo.AtiraPelaMoeda;
import Modelo.Blocos.Empurravel;
import Modelo.Blocos.Coletavel;
import Modelo.Hero;

public class Fase3 extends Fase{
    
    /*Classe que herda de Fase e define o ambiente da Fase 3.
    Criar um objeto refere-se a instancia-lo e adiciona-lo a
    faseAtual da Tela.*/

    public Fase3 (Hero hero) {
        super(hero);

        /*Define posicao do Hero e da Porta*/
        hero.setPosicao(2, 2);

        porta.setPosicao(Consts.RES - 3, 9);

        /*Cria inimigos da fase*/   
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

        /*Cria caixas empurraveis da fase*/ 
        Empurravel emp = new Empurravel("caixa.png");
        emp.setPosicao(Consts.RES - 3, 8);      
        Desenho.acessoATelaDoJogo().addPersonagem(emp);                            

        /*Cria moedas da fase*/
        Coletavel moeda1 = new Coletavel("moeda.png");
        moeda1.setPosicao(6, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda1);
        
        Coletavel moeda2 = new Coletavel("moeda.png");
        moeda2.setPosicao(6, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda2);

        Coletavel moeda3 = new Coletavel("moeda.png");
        moeda3.setPosicao(7, 5);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda3);  

        Coletavel moeda4 = new Coletavel("moeda.png");
        moeda4.setPosicao(7, 6);
        Desenho.acessoATelaDoJogo().addPersonagem(moeda4);  
    }
}
