package Modelo.Blocos; 

import Modelo.Personagem;
import Auxiliar.Desenho;    

public class Porta extends Personagem {
    public Porta(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bTransponivel = true;                          //define porta transponivel
        this.bPorta = true;                                 //variavel para verificacao de porta na controle de jogo
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 1){ //caso todas as moedas da fase 1 um forem pegas transforma porta em coletavel e muda skin da porta
            this.bColetavel = true;     //transformando em coletavel
            super.SkinPersonagem("PortaAberta.png", 'p');   //mudando skin
        }   

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 2){ //caso todas as moedas da fase 2 forem pegas transforma porta em coletavel e muda skin da porta
            this.bColetavel = true;     //transformando em coletavel
            super.SkinPersonagem("PortaAberta.png", 'p');  //mudando skin
        }

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 1 && Desenho.acessoATelaDoJogo().getFase() == 3){  //caso todas as moedas da fase 3 forem pegas transforma porta em coletavel e muda skin da porta
            this.bColetavel = true;     //transformando em coletavel
            super.SkinPersonagem("PortaAberta.png", 'p');   //mudando skin
        }

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 3 && Desenho.acessoATelaDoJogo().getFase() == 4){  //caso todas as moedas da fase 4 forem pegas transforma porta em coletavel e muda skin da porta
            this.bColetavel = true;     //transformando em coletavel
            super.SkinPersonagem("PortaAberta.png", 'p');   //mudando skin
        }
    }
}
