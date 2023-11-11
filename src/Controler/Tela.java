package Controler;

import Modelo.Personagem;
import Modelo.InimigoAtirador;
import Modelo.AtiraNaVisao;
import Modelo.Coletavel;        
import Modelo.Empurravel;
import Modelo.Estatico;
import Modelo.Hero;
import Modelo.Inimigo;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.ZigueZague;
import Auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    private int fase = 1; 
    public int qntmoedas = 0;
    
    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        
        // fasesJogo = new ArrayList<ArrayList<Personagem>>();
        faseAtual = new ArrayList<Personagem>();
        hero = new Hero("HeroEstaticFace.png"); 
        hero.setPosicao(1, 1);
        this.addPersonagem(hero);

        switch (fase) {
            case 1:
                for(int i = 2; i < Consts.RES - 2; i++){
                    Estatico brick3 = new Estatico("bricks.png");
                    brick3.setPosicao(i, 2);
                    this.addPersonagem(brick3);
                    Estatico brick7 = new Estatico("bricks.png");
                    brick7.setPosicao(i, 6);
                    this.addPersonagem(brick7);
                    Estatico brick11 = new Estatico("bricks.png");
                    brick11.setPosicao(i, 10);
                    this.addPersonagem(brick11);
                }

                for(int i = 1; i < Consts.RES - 1; i++){
                    if(i == Consts.RES/2)
                        continue;
                    Estatico brick5 = new Estatico("bricks.png");
                    brick5.setPosicao(i, 4);
                    this.addPersonagem(brick5);
                    Estatico brick9 = new Estatico("bricks.png");
                    brick9.setPosicao(i, 8);
                    this.addPersonagem(brick9);
                }

                for(int j = 6; j < 8; j++){
                    Estatico bricktop = new Estatico("bricks.png");
                    bricktop.setPosicao(1, j);
                    this.addPersonagem(bricktop);
                }   

                for(int z = 3; z < 10; z = z+4){
                    Empurravel emp1 = new Empurravel("caixa.png");
                    emp1.setPosicao(Consts.RES/2 - 2, z);
                    this.addPersonagem(emp1);
                    Empurravel emp2 = new Empurravel("caixa.png");
                    emp2.setPosicao(Consts.RES/2 - 1, z);
                    this.addPersonagem(emp2);
                    Empurravel emp = new Empurravel("caixa.png");
                    emp.setPosicao(Consts.RES/2, z);
                    this.addPersonagem(emp);
                    Coletavel moeda = new Coletavel("moeda.png");
                    moeda.setPosicao((Consts.RES/2)+1, z);
                    this.addPersonagem(moeda);
                }

                for(int z = 2; z < 7; z = z+4){
                    Inimigo inimigo = new Inimigo("skoot.png");
                    inimigo.setPosicao(Consts.RES - 2, z);
                    this.addPersonagem(inimigo);
                }

                Inimigo inimigo = new Inimigo("skoot.png");
                inimigo.setPosicao(Consts.RES/2, 1);
                this.addPersonagem(inimigo);

                Coletavel moeda = new Coletavel("moeda.png");
                moeda.setPosicao(2, 1);
                // moeda.setPosicao((Consts.RES/2)-1, 3);
                this.addPersonagem(moeda);
                    
                break;
            
            case 2:
                for(int i = 2; i < Consts.RES - 3; i++){
                    Estatico brick3 = new Estatico("bricks.png");
                    brick3.setPosicao(i, 3);
                    this.addPersonagem(brick3);
                    Estatico brick5 = new Estatico("bricks.png");
                    brick5.setPosicao(i, 5);
                    this.addPersonagem(brick5);
                }

                for(int i = 4; i < Consts.RES - 4; i++){
                    if(i == Consts.RES/2)
                        continue;
                    Estatico brick11 = new Estatico("bricks.png");
                    brick11.setPosicao(i, 11);
                    this.addPersonagem(brick11);
                    Estatico brick9 = new Estatico("bricks.png");
                    brick9.setPosicao(i, 9);
                    this.addPersonagem(brick9);
                }

                for(int j = 7; j < 9; j++){
                    Estatico bricktop = new Estatico("bricks.png");
                    bricktop.setPosicao(2, j);
                    this.addPersonagem(bricktop);
                }

                ZigueZague zz1 = new ZigueZague("robo.png");
                zz1.setPosicao(8, 8);
                this.addPersonagem(zz1);

                break;
        }
    
        // ZigueZague zz1 = new ZigueZague("robo.png");
        // zz1.setPosicao(8, 8);
        // this.addPersonagem(zz1);

        // // InimigoAtirador bV = new InimigoAtirador("caveira.png");
        // // bV.setPosicao(9, 1);
        // // this.addPersonagem(bV);

        // AtiraNaVisao anv1 = new AtiraNaVisao("PlantinhaDormindo.png", hero);
        // anv1.setPosicao(6, 6);
        // this.addPersonagem(anv1);

        // Coletavel col1 = new Coletavel("moeda.png");
        // col1.setPosicao(4, 4);
        // this.addPersonagem(col1);

        // Empurravel emp1 = new Empurravel("caixa.png");
        // emp1.setPosicao(2, 2);
        // this.addPersonagem(emp1);   
    }

    public boolean ehPosicaoValida(Posicao p, char c, char tipoPersonagem){
        return cj.ehPosicaoValida(this.faseAtual, p, c, this, tipoPersonagem);
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }           

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public void setMoedas(){
        qntmoedas++;
    }

    public Graphics getGraphicsBuffer(){
        return g2;  
    }
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File("..").getCanonicalPath() + Consts.PATH + "black.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        for (int i = 0; i < Consts.RES; i++){
            for (int j = 0; j < Consts.RES; j++){
                if(i == 0 || j == 0 || i == Consts.RES - 1 || j == Consts.RES - 1 || j == Consts.RES - 4 || (i == 7 && j > Consts.RES - 4) || (i == 12 && j > Consts.RES - 4)){
                    Estatico est = new Estatico("TijoloRoxo.png");      
                    est.setPosicao(i, j);
                    faseAtual.add(est);
                }
            }
        }


        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            this.faseAtual.clear();
        } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            hero.atira(hero.getLastMovment());  
        }

        this.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", "
                + (hero.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
