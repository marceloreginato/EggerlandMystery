package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase { 
    Porta porta = new Porta("roboPink.png");

    public Fase (Hero hero) {
        Desenho.acessoATelaDoJogo().addPersonagem(hero);
        Desenho.acessoATelaDoJogo().addPersonagem(porta);

        for (int i = 0; i < Consts.RES; i++){
            for (int j = 0; j < Consts.RES; j++){
                if(i == 0 || j == 0 || i == Consts.RES - 1 || j == Consts.RES - 1 || j == Consts.RES - 4 || (i == 7 && j > Consts.RES - 4) || (i == 12 && j > Consts.RES - 4)){
                    Estatico est = new Estatico("TijoloRoxo.png");      
                    est.setPosicao(i, j);
                    Desenho.acessoATelaDoJogo().addPersonagem(est);
                }
            }
        } 
    }
}
