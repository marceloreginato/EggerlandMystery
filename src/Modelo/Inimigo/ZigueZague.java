package Modelo.Inimigo;

import Auxiliar.Desenho;
import Auxiliar.Posicao;

import java.util.ArrayList;
import java.util.Random;
import Modelo.Personagem;

public class ZigueZague extends Personagem {
    public ZigueZague(String sNomeImagePNG) {
        super(sNomeImagePNG, 'z');
        this.bMortal = true;                                //define que o zigue zague pode matar o hero
        this.bZigueZague = true;                            //variavel para tratemnto do zigue zague na controle de jogo
    }


    public void autoDesenho(){

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 2){ // caso todas as moedas da fase 2 forem coletadas ativa movimento dos inimigos
            Random rand = new Random();
            int iDirecao = rand.nextInt(4);         //cria inteiro aleatorio para definir em qual direcao sera o movimento do zigue zague
            
            if(iDirecao == 0){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);            //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao()))
                    this.pPosicao.volta();                                               //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 1){
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());            //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao()))
                    this.pPosicao.volta();                                               //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 2){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao()))
                    this.pPosicao.volta();                                              //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 3){
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());           //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!ehPosicaoValida(Desenho.acessoATelaDoJogo().getFaseAtual(), getPosicao()))
                    this.pPosicao.volta();                                              //volta para posicao anterior caso posicao nao seja valida
            }
        }   
        super.autoDesenho();
    }

    /*valida posição ziguezague, caso a posicao do pIesiomoPersonagem foi considerada invalida
     * retorna false para que o ziguezague nao avance para aquela posicao*/

    @Override
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(pIesimoPersonagem.isbEstatico() || pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbEmpurravel() || pIesimoPersonagem.isbPorta()){
                if(pIesimoPersonagem.getPosicao().igual(p)){
                    return false;   
                }   
            }
        }
        return true; 
    }
}
