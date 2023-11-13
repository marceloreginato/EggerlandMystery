package Controler;
    
import Modelo.Inimigo.AtiraNaVisao; 
import Modelo.Inimigo.AtiraPelaMoeda;  
import Modelo.Blocos.Coletavel;  
import Modelo.Blocos.Estatico;  
import Modelo.Fases.Fase;  
import Modelo.Fases.Fase1;  
import Modelo.Fases.Fase2;  
import Modelo.Fases.Fase3;  
import Modelo.Fases.Fase4;
import Modelo.Fases.Janela;
import Modelo.Hero;  
import Modelo.Inimigo.Inimigo;  
import Modelo.Personagem;
import Modelo.Inimigo.InimigoAtirador;
import Modelo.Blocos.Numero;
import Modelo.Blocos.Porta;
import Modelo.Tiro;
import Modelo.Inimigo.ZigueZague;
import Modelo.Progresso;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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
    
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener { /*DELETAR MOUSELISTENER*/
    private Hero hero;                          /*Define Hero*/
    private ArrayList<Personagem> faseAtual;    /*Array com o ambiente da fase atual do jogo*/ 
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;

    /*Fase atual do jogo: 
    0: Tela de inicio (nao jogavel);
    1: Fase 1 (jogavel);
    2: Fase 2 (jogavel);
    3: Fase 3 (jogavel);
    4: Fase 4 (jogavel);
    5: Tela de fim (nao jogavel);
    6: Tela de gameover (nao jogavel);
    */

    private int fase = 0;  

    private int qntmoedas;          /*Quantidade de moedas em posse do jogador (quantidade de tiros restantes) - reseta a cada inicio de fase*/
    private int moedasColetadas;    /*Quantidade total de moedas coletadas durante a fase*/
    private int qntvidas;           /*Quantidade de vidas - inicia com 5 e nao ganha durante o jogo*/
    private Progresso progresso = new Progresso(this);      /*Define o progresso do jogo, restaura e o atualiza*/ 

    public Tela() {
        Desenho.setCenario(this);           
        initComponents();
        this.addMouseListener(this); /*mouse*/ /*DELETAR*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();                    /*Instancia array com ambiente da fase atual*/
        hero = new Hero("HeroEstaticFace.png");       /*Instancia Hero*/
    }   

    /*Verifica se a posicao a ser movida eh possivel*/
    public boolean ehPosicaoValida(Posicao p, char sentidoMovimento, char tipoPersonagem){
        return cj.ehPosicaoValida(this.faseAtual, p, sentidoMovimento, tipoPersonagem);
    }                       

    /*Verifica se a posicao a ser movida pela classe ZigueZague eh possivel*/
    public boolean ehValidoZigueZague(Posicao p){
        return cj.ehValidoZigueZague(this.faseAtual, p);
    }

    /*Adiciona um personagem no ambiente da fase atual*/
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }           

    /*Remove um personagem do ambiente da fase atual*/
    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }   

    /*Retorna quantidade de objetos no ambiente da fase atual*/
    public int tamanhoFase(){
        return faseAtual.size();
    }

    public int getFase(){   
        return fase;
    }

    public void setFase(int i){
        fase = i;
    } 

    public int getMoedas() {
        return qntmoedas;
    }

    protected void setMoedas(int i){
        qntmoedas = i;
    } 

    /*Adiciona uma moeda (tiro) no inventario do jogador (uma moeda foi coletada)*/
    public void addMoedas(){
        qntmoedas++;
    }  

    /*Remove uma moeda (tiro) do inventario do jogador (um tiro foi gasto)*/
    public void removeMoedas(){
        qntmoedas--;
    } 

    public int getVidas(){   
        return qntvidas;
    }

    public void setVidas(int i){
        qntvidas = i;
    } 
    
    /*Remove uma vida do inventario do jogador (personagem morreu).
    Eh feito tratamento para que aconteca um GameOver caso as vidas
    se acabem. Ao ter um GameOver o jogador perde o seu progresso no
    jogo, reiniciando na fase 1.*/

    public void removeVidas(){
        if(qntvidas == 1){
            progresso.limpar();
            fase = 6;
            criaFase();
        } 
        qntvidas--;
    }

    public int getMoedasColetadas() {
        return moedasColetadas;
    }

    public void setMoedasColetadas(int moedasColetadas) {
        this.moedasColetadas = moedasColetadas;
    }

    /*Adiciona uma moeda na quantidade total de moedas coletadas na fase (uma moeda foi coletada)*/
    public void addMoedasColetadas() { 
        moedasColetadas++;
    }

    /*Metodo que atualiza os numeros no Setup Lateral (contadores de vida, moedas [tiros] e fase).
    Esse metodo eh chamado frequentemente pelo metodo paint dessa classe.*/
    public void atualizaNumeros(){
        Numero vidas = new Numero(getVidas(), 'v');
        Numero moedas = new Numero(getMoedas(), 'm');
        Numero fases = new Numero(getFase(), 'f');
        
        /*As posicoes desses objetos no array faseAtual sao predefinidas,
        logo os objetos sao apenas substituidos pelo metodo set.*/
        faseAtual.set(2, vidas); 
        faseAtual.set(3, moedas);   
        faseAtual.set(4, fases);   
    }

    /*Metodo que constroi as fases jogaveis por meio das classes herdeiras de Fase*/
    public void criaFase(){
        if(fase <= 6)       /*Limpa o array do ambiente da fase atual*/
            faseAtual.clear();
        setMoedas(0);     /*Reseta a quantidade de moedas (tiros) a cada fase*/
        setMoedasColetadas(0);    /*Reseta a quantidade de moedas coletadas na fase*/

        switch (fase) {
            case 1:
                setVidas(5);     /*O jogo sempre se inicia com 5 vidas*/
                new Fase1(hero);
                break;

            case 2:
                new Fase2(hero);
                break;

            case 3:
                new Fase3(hero);                    
                break;

            case 4:
                new Fase4(hero);
                break;

            default:
                break;
        }
    }

    public Graphics getGraphicsBuffer(){
        return g2;  
    }

    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();

        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário de fundo*/
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

        /*Desenha as fases nao jogaveis. As Janelas sao instanciadas nesse metodo, pois precisam que um Graphics seja criado.*/
        switch (fase) {
            case 0: 
                new Janela("TelaInicial.png");
                break;
            case 5:
                progresso.limpar();     /*Jogo finalizado, progresso reiniciado*/
                new Janela("TelaFinal.png");
                break;    
            case 6:
                progresso.limpar();     /*Jogo finalizado, progresso reiniciado*/
                new Janela("TelaGameOver.png");
                break;        
            default:
                break;
        }

        /*Atualiza os numeros do Setup Lateral caso em fase jogavel*/
        if(fase > 0 && fase < 5)
            atualizaNumeros();  

        /*Passa de fase caso a porta tenha sido coletada (Hero tenha acessado ela depois de aberta)
        em fase jogavel. Para passar de fase, muda o indicador de fase para o proximo inteiro, cria
        um novo ambiente de fase e salva o progresso do jogador.*/
        if(tamanhoFase() > 0 && !faseAtual.get(1).isbPorta() && fase > 0 && fase < 5){
            fase++;
            criaFase();
            progresso.salvamento();
        }

        /*Desenha o ambiente da fase atual e processa o andamento e interacao dos objetos nele*/
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

    /*Metodo geral que mantem a tela rodando e atualizando os acontecimentos.
    Esse metodo mantem o metodo paint dessa classe sempre atualizado.*/
    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    /*Metodo que interpreta as teclas pressionadas do teclado*/
    public void keyPressed(KeyEvent e) {

        /*Significado das teclas:

        WASD e UP+LEFT+DOWN+RIGHT: move nos 4 sentidos;
        L: carrega jogo salvo quando na tela de inicio (fase 0);
        N: inicia um jogo novo (fase 1) quando na tela de inicio (fase 0);
        R: Reinicia jogo (fase 0) quando na tela de fim (fase 5) ou de gameover (fase 6);
        E: Salva e fecha o jogo (caso nas fases 5 ou 6, o salvamento do jogo eh para inicializacao padrao).
        */

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE && this.getMoedas() != 0) {
            hero.atira(hero.getLastMovment());  
            removeMoedas();
        } else if (e.getKeyCode() == KeyEvent.VK_L && getFase() == 0){ // load no menu
            progresso.restaurar();
            criaFase();
        } else if (e.getKeyCode() == KeyEvent.VK_N && getFase() == 0){ // new game no menu
            setFase(1);
            criaFase();
        } else if (e.getKeyCode() == KeyEvent.VK_R && getFase() > 4) { // reiniciar no gameover e no fim
            progresso.limpar();
            setFase(0);
            criaFase();
        } else if (e.getKeyCode() == KeyEvent.VK_E) { // salvar e sair ou so sair se jogo finalizado 
            if(getFase() > 0 && getFase() < 5)
                progresso.salvamento();
            else if (getFase() >= 5)
                progresso.limpar();
            System.exit(0);
        }

        /*Invoca o paint imediatamente, sem aguardar o refresh*/
        repaint();
    }

    public void mousePressed(MouseEvent e) { /*DELETAR*/
        /* Clique do mouse desligado*/
        int x = e.getX();
        int y = e.getY();
        
        this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }   


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023 - Eggerland Mystery - Marcelo e Rhayna");
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

    public void mouseMoved(MouseEvent e) { /*DELETAR*/
    }

    public void mouseClicked(MouseEvent e) { /*DELETAR*/
    }

    public void mouseReleased(MouseEvent e) { /*DELETAR*/
    }

    public void mouseEntered(MouseEvent e) { /*DELETAR*/
    }

    public void mouseExited(MouseEvent e) { /*DELETAR*/
    }

    public void mouseDragged(MouseEvent e) { /*DELETAR*/
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
