package Modelo;

import Auxiliar.Consts; 
import Auxiliar.Desenho;
import Controler.Tela;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable{

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean bEmpurravel;  /*Se encostar empurra o objeto*/
    protected boolean bColetavel;   /*Se encostar coleta o objeto*/
    protected boolean bPorta;
    protected boolean bMorrivel;
    protected boolean bEstatico;
    private char c;

    protected Personagem(String sNomeImagePNG, char c) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        this.bEmpurravel = false;
        this.bColetavel = false;
        this.bMorrivel = false;
        this.bEstatico = false;
        this.c = c;
        try {
            if(this.c == 'h')       
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_HERO + sNomeImagePNG);
            else if(this.c == 't')
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_FOGO + sNomeImagePNG);
            else if(this.c == 'i')
            iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_INIMIGO + sNomeImagePNG);
            else if(this.c == 'l')
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_LATERAL + sNomeImagePNG);
            else
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void SkinPersonagem(String sNomeImagePNG, char c){
        try {
            if(this.c == 'h')
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_HERO + sNomeImagePNG);
            else if(this.c == 'i')
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH_INIMIGO + sNomeImagePNG);
            else
                iImage = new ImageIcon(new java.io.File("..").getCanonicalPath() + Consts.PATH + sNomeImagePNG);    
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Personagem*/
        return pPosicao;
    }
    
    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public boolean isbEmpurravel() {
        return bEmpurravel;
    }

    public boolean isbColetavel() {
        return bColetavel;
    }

    public boolean isbMortal() {
        return bMortal;
    }

    public boolean isbPorta() {
        return bPorta;
    }

    public boolean isbMorrivel() {
        return bMorrivel;
    }

    public boolean isbEstatico() {
        return bEstatico;
    }

    public void setbEstatico(boolean bEstatico) {
        this.bEstatico = bEstatico;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public void setbEmpurravel(boolean bEmpurravel) {
        this.bEmpurravel = bEmpurravel;
    }

    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
}