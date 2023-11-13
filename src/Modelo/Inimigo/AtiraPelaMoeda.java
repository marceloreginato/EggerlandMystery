package Modelo.Inimigo;

import Auxiliar.Desenho;    
import Modelo.Hero;

public class AtiraPelaMoeda extends InimigoAtirador{

    private String sNomeImagePNG;    //string para verificacao do inimigo
    private int tiroD = 0;                  //bloco de variaveis para atirar uma vez a partir da condicao satisfeita
    private int tiroE = 0;
    private int tiroF = 0;
    private int tiroT = 0;
    private int stopLinha = 0;              //variaveis para atirar apenas uma vez se a condicao for satisfeita, apos a coleta da moeda
    private int stopColuna = 0;
    private Hero hero;

    public AtiraPelaMoeda(String sNomeImagePNG, Hero hero){
        super(sNomeImagePNG);
        this.sNomeImagePNG = sNomeImagePNG;
        this.hero = hero;
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(Desenho.acessoATelaDoJogo().getMoedas() != 0){   //verificao para atirar apenas quando a moeda for coletada

            if(tiroD == 0){                                 //verifica se ja foi dado um tiro
                if(this.sNomeImagePNG.equals("MonstroRoxoDireita.png")) //atira para a direita a partir da verificacao de string
                    super.atiraRight('m');                
                tiroD++;                                    //incrementa apos dar um tiro, para garantir um unico tiro
            }
            else if(tiroD != 0 && this.sNomeImagePNG.equals("MonstroRoxoDireita.png")){ //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoDireitaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() > this.pPosicao.getColuna() && stopLinha != 1){     //atira caso o heroi esteja na mesma linha do inimigo                
                    stopLinha = 1;                  //altera variavel para garantia de um unico tiro
                    super.atiraRight('m');         //atira para direita
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha())   //quando o heroi sai da linha do inimigo reseta a variavel para que quando entre novamente o inimigo atire denovo
                    stopLinha = 0;
            }   

            if(tiroE == 0){ //verifica se ja foi dado um tiro
                if(this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png")) //atira para a esquerda a partir da verificacao de string
                    super.atiraLeft('m');
                tiroE++;                                                //incrementa apos dar um tiro, para garantir um unico tiro
            }
            else if(tiroE != 0 && this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png")){    //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoEsquerdaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() < this.pPosicao.getColuna() && stopLinha != 1){    //atira caso o heroi esteja na mesma linha do inimigo
                    stopLinha = 1;                  //altera variavel para garantia de um unico tiro
                    super.atiraLeft('m');         //atira para esqueda
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha()) //quando o heroi sai da linha do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopLinha = 0;
            }

            if(tiroT == 0){ //verifica se ja foi dado um tiro
                if(this.sNomeImagePNG.equals("MonstroRoxoTras.png")) //atira para a cima a partir da verificacao de string
                    super.atiraUp('m');
                tiroT++;                                        //incrementa apos dar um tiro, para garantir um unico tiro
            }
            else if(tiroT != 0 && this.sNomeImagePNG.equals("MonstroRoxoTras.png")){    //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoTras.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() < this.pPosicao.getLinha() && stopColuna != 1){ //atira caso o heroi esteja na mesma coluna do inimigo
                    stopColuna = 1;       //altera variavel para garantia de um unico tiro
                    super.atiraUp('m'); //atira para cima
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna()) //quando o heroi sai da coluna do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopColuna = 0;
            }

            if(tiroF == 0){     //verifica se ja foi dado um tiro
                if(this.sNomeImagePNG.equals("MonstroRoxoFrente.png")) //atira para a baixo a partir da verificacao de string
                    super.atiraDown('m');
                tiroF++;                                        //incrementa apos dar um tiro, para garantir um unico tiro   
            }
            else if(tiroF != 0 && this.sNomeImagePNG.equals("MonstroRoxoFrente.png")){  //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoFrenteAcordado.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() > this.pPosicao.getLinha() && stopColuna != 1){   //atira caso o heroi esteja na mesma coluna do inimigo
                    stopColuna = 1;                 //altera variavel para garantia de um unico tiro
                    super.atiraDown('m');      
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna()) //quando o heroi sai da coluna do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopColuna = 0;
            }
        }
    }
}