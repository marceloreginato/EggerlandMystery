package Modelo;

import java.util.ArrayList;

import Auxiliar.Desenho;
import Auxiliar.Posicao;

public class Tiro extends Personagem {

    private char direcao;    
 
    public Tiro(String sNomeImagePNG, char direcao) {
        super(sNomeImagePNG, 't');  
        this.bMortal = true;               //variavel booleana para definir que o tiro mata o Hero
        this.bTiro = true;                 //variavel para verificar em controleDoJogo se o pIesimoPersonagem é um tiro
        this.direcao = direcao;                        //caracter que define direcao do tiro
    }   

    public void autoDesenho() {
        super.autoDesenho();
        if(this.direcao == 'r'){                 //caso o caracter de definicao do tiro seja r, o tiro irá para a direita
            if(!moveRight())               //tiro se move para a direita até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);     
            if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao())) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));  //caso nao seja valida remove o tiro
        }
        if(this.direcao == 'l'){                 //caso caracter de definicao do tiro sera l, o tiro irá para a esquerda
            if(!moveLeft())                //tiro se move para a esquerda até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao())) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));  //caso nao seja valida remove o tiro
        }
        if(this.direcao == 'u'){                  //caso caracter de definicao do tiro sera u, o tiro irá para cima
            if(!moveUp())                   //tiro se move para cima até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao())) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));   //caso nao seja valida remove o tiro
        }   
        if(this.direcao == 'd'){                  //caso caracter de definicao do tiro sera d, o tiro irá para baixo
            if(!moveDown())                 //tiro se move para baixo até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao())) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this)); //caso nao seja valida remove o tiro
        }
    }

    /*Metodo que verifica se a posicao que objeto esta se movendo eh possivel.*/
    @Override
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p) {
        Personagem pIesimoPersonagem;

        /*Percorre o array do ambiente da fase (desconsiderando o Hero) e
        verifica se ha algum Personagem na posicao a ser movimentada.*/
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            if (pIesimoPersonagem.getPosicao().igual(p)) {

                /*Tratamento para se o objeto que esta se movendo eh um Tiro.
                Remove Personagem morrivel e eh destrido ao atingir outros Personagens.*/
                if (pIesimoPersonagem.isbMorrivel()) {
                    umaFase.remove(pIesimoPersonagem);
                    return false;
                }
                if(pIesimoPersonagem.isbEmpurravel() || pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbPorta() || !pIesimoPersonagem.isbTransponivel() || pIesimoPersonagem.isbZigueZague())
                    return false;
                return true;
            }
        }
        /*Retorna true se nao for conflitante*/
        return true;
    }



}   
