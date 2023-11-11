package Controler;

import Modelo.Personagem;
import Modelo.Tiro;
import Modelo.Hero;
import Auxiliar.Posicao;
import java.util.ArrayList;
import Auxiliar.Consts;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e) {
        for (int i = 1; i < e.size(); i++) {
            e.get(i).autoDesenho();
        }
        e.get(0).autoDesenho();
    }

    public void processaTudo(ArrayList<Personagem> umaFase) {
        Hero hero = (Hero) umaFase.get(0);
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);
            if (hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if (pIesimoPersonagem.isbTransponivel())
                    /* TO-DO: verificar se o personagem eh mortal antes de retirar */
                    umaFase.remove(pIesimoPersonagem);
        }
    }

    /*
     * Retorna true se a posicao p é válida para Hero com relacao a todos os
     * personagens no array
     */
    public boolean ehPosicaoValida_Antigo(ArrayList<Personagem> umaFase, Posicao p, char c) {
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);
            if (!pIesimoPersonagem.isbTransponivel())
                if (pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }
        return true;    
    }

    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p, char c, Tela tela) {
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            if (pIesimoPersonagem.getPosicao().igual(p)) {

                if (!pIesimoPersonagem.isbTransponivel()) {

                    if (pIesimoPersonagem.isbEmpurravel()) {

                        int linha = pIesimoPersonagem.getPosicao().getLinha();
                        int coluna = pIesimoPersonagem.getPosicao().getColuna();

                        switch (c) {
                            case 'u':
                                if(linha == 0)
                                    return false;
                                Posicao posicaoU = new Posicao(linha - 1, coluna);
                                if(!this.ehPosicaoValida(umaFase, posicaoU, 'u', tela))
                                    return false;
                                pIesimoPersonagem.setPosicao(linha - 1, coluna);
                                break;

                            case 'd':
                                if(linha == Consts.RES - 1)
                                    return false;
                                Posicao posicaoD = new Posicao(linha + 1, coluna);
                                if(!this.ehPosicaoValida(umaFase, posicaoD, 'd', tela))
                                    return false;
                                pIesimoPersonagem.setPosicao(linha + 1, coluna);
                                break;

                            case 'l':
                                if(coluna == 0)
                                    return false;
                                Posicao posicaoL = new Posicao(linha, coluna - 1);
                                if(!this.ehPosicaoValida(umaFase, posicaoL, 'l', tela))
                                    return false;
                                pIesimoPersonagem.setPosicao(linha, coluna - 1);
                                break;

                            case 'r':
                                if(coluna == Consts.RES - 1)
                                    return false;
                                Posicao posicaoR = new Posicao(linha - 1, coluna + 1);
                                if(!this.ehPosicaoValida(umaFase, posicaoR, 'r', tela))
                                    return false;    
                                pIesimoPersonagem.setPosicao(linha, coluna + 1);
                                break;

                            default:
                                break;
                        }

                        return true;
                    }
                    
                    return false;
                }
                if(pIesimoPersonagem.isbColetavel()){
                    tela.setMoedas();
                }
            }
            if (!pIesimoPersonagem.isbTransponivel())
                if (pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }
        return true;
    }
}
