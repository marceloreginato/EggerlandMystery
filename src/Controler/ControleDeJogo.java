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
    // public boolean ehPosicaoValida_Antigo(ArrayList<Personagem> umaFase, Posicao p, char c) {
    //     Personagem pIesimoPersonagem;
    //     for (int i = 1; i < umaFase.size(); i++) {
    //         pIesimoPersonagem = umaFase.get(i);
    //         if (!pIesimoPersonagem.isbTransponivel())
    //             if (pIesimoPersonagem.getPosicao().igual(p))
    //                 return false;
    //     }
    //     return true;    
    // }

    public boolean processaEmpurravel(char sentidoMovimento, Personagem personagemEmpurravel, Tela tela, ArrayList<Personagem> umaFase){
        int linha = personagemEmpurravel.getPosicao().getLinha();
        int coluna = personagemEmpurravel.getPosicao().getColuna();

        switch (sentidoMovimento) {
            case 'u':
                Posicao posicaoU = new Posicao(linha - 1, coluna);
                if(!this.ehPosicaoValida(umaFase, posicaoU, 'u', tela, 'e'))
                    return false;
                personagemEmpurravel.moveUp();
                break;

            case 'd':
                Posicao posicaoD = new Posicao(linha + 1, coluna);
                if(!this.ehPosicaoValida(umaFase, posicaoD, 'd', tela, 'e'))
                    return false;
                personagemEmpurravel.moveDown();
                break;

            case 'l':
                Posicao posicaoL = new Posicao(linha, coluna - 1);
                if(!this.ehPosicaoValida(umaFase, posicaoL, 'l', tela, 'e'))
                    return false;
                personagemEmpurravel.moveLeft();
                break;

            case 'r':
                Posicao posicaoR = new Posicao(linha - 1, coluna + 1);
                if(!this.ehPosicaoValida(umaFase, posicaoR, 'r', tela, 'e'))
                    return false;    
                personagemEmpurravel.moveRight();
                break;

            default:
                break;
        }
        return true;
    }

    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p, char sentidoMovimento, Tela tela, char tipoPersonagem) {
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            if (pIesimoPersonagem.getPosicao().igual(p)) {
                if (!pIesimoPersonagem.isbTransponivel()) {
                    if (pIesimoPersonagem.isbEmpurravel())
                        processaEmpurravel(sentidoMovimento, pIesimoPersonagem, tela, umaFase);
                    return false;
                }
                if(pIesimoPersonagem.isbColetavel()){
                    if(tipoPersonagem != 'h')
                        return false;
                    tela.setMoedas();
                }
                return true;
            }
        }
        return true;
    }

    

}
