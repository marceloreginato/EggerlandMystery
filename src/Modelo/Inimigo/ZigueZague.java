package Modelo.Inimigo;

import Auxiliar.Desenho;
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
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();                                               //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 1){
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());            //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();                                               //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 2){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();                                              //volta para posicao anterior caso posicao nao seja valida
            }
            else if(iDirecao == 3){
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());           //bloco para setar nova posicao do zigue zague e verificar se essa posicao eh valida
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();                                              //volta para posicao anterior caso posicao nao seja valida
            }
        }   
        super.autoDesenho();
    }
}
