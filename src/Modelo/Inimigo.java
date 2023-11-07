package Modelo;

public class Inimigo extends Personagem {
    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bColetavel = true;
        this.bTransponivel = false;
    }
}
