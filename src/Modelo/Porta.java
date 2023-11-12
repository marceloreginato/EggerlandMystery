package Modelo;

public class Porta extends Personagem {
    public Porta(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bTransponivel = true;
        this.bPorta = true;
    }   
}
