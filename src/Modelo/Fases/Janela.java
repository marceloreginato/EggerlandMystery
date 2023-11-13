package Modelo.Fases;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;

public class Janela{

    /*Classe que cria as fases nao jogaveis (tela de inicio, fim
    e gameover). Desenha um background com uma imagem 675x675 px. 
    O nome da imagem eh passado ao instanciar o objeto.*/

    public String sNomeBackground;

    public Janela(String sNomeBackgorund){
        this.sNomeBackground = sNomeBackgorund;

        try {   
            Image backgroundImage = Toolkit.getDefaultToolkit().getImage(new java.io.File("..").getCanonicalPath() + Consts.PATH_TELA + sNomeBackgorund);
            Desenho.acessoATelaDoJogo().getGraphicsBuffer().drawImage(backgroundImage, 0, 0, Desenho.acessoATelaDoJogo());
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}