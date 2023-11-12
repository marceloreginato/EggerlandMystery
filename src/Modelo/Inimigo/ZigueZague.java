package Modelo.Inimigo;

import Auxiliar.Desenho;
import java.util.Random;
import Modelo.Personagem;

public class ZigueZague extends Personagem {
    public ZigueZague(String sNomeImagePNG) {
        super(sNomeImagePNG, 'z');
        this.bTransponivel = false;
    }


    public void autoDesenho(){

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 2){
            Random rand = new Random();
            int iDirecao = rand.nextInt(4);
            
            if(iDirecao == 0){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();
            }
            else if(iDirecao == 1){
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();        
            }
            else if(iDirecao == 2){
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();        
            }
            else if(iDirecao == 3){
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                if(!Desenho.acessoATelaDoJogo().ehValidoZigueZague(this.getPosicao()))
                    this.pPosicao.volta();        
            }
        }   
        super.autoDesenho();
    }
}
