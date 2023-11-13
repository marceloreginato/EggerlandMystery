package Modelo.Blocos; 

import Modelo.Personagem;
import Auxiliar.Desenho;    

public class Porta extends Personagem {
    public Porta(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bTransponivel = true;
        this.bPorta = true;
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 1){
            this.bColetavel = true;
            super.SkinPersonagem("PortaAberta.png", 'p');
        }

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 5 && Desenho.acessoATelaDoJogo().getFase() == 2){
            this.bColetavel = true;
            super.SkinPersonagem("PortaAberta.png", 'p');
        }

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 1 && Desenho.acessoATelaDoJogo().getFase() == 3){
            this.bColetavel = true;
            super.SkinPersonagem("PortaAberta.png", 'p');
        }

        if(Desenho.acessoATelaDoJogo().getMoedasColetadas() == 3 && Desenho.acessoATelaDoJogo().getFase() == 4){
            this.bColetavel = true;
            super.SkinPersonagem("PortaAberta.png", 'p');   
        }
    }
}
