package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;

public class Fase {
    // Porta porta;

    public Fase (Hero hero) {
        hero.setPosicao(1, 1);
        Desenho.acessoATelaDoJogo().addPersonagem(hero);

        for (int i = 0; i < Consts.RES; i++){
            for (int j = 0; j < Consts.RES; j++){
                if(i == 0 || j == 0 || i == Consts.RES - 1 || j == Consts.RES - 1 || j == Consts.RES - 4 || (i == 7 && j > Consts.RES - 4) || (i == 12 && j > Consts.RES - 4)){
                    Estatico est = new Estatico("TijoloRoxo.png");      
                    est.setPosicao(i, j);
                    Desenho.acessoATelaDoJogo().addPersonagem(est);
                }
            }
        }   

        // porta = new Porta("Porta.png");
        // porta.setPosicao();
        // Desenho.acessoATelaDoJogo().addPersonagem(porta);
    }
}
