package Modelo.Inimigo;

import Auxiliar.Desenho;    
import Modelo.Hero;
import Modelo.Tiro; 

public class AtiraPelaMoeda extends InimigoAtirador{

    private String sNomeImagePNG;    //string para verificacao do inimigo
    private int stopLinha = 0;              //variaveis para atirar apenas uma vez se a condicao for satisfeita, apos a coleta da moeda
    private int stopColuna = 0;
    private boolean primeiroTiro = false;
    private Hero hero;

    public AtiraPelaMoeda(String sNomeImagePNG, Hero hero){
        super(sNomeImagePNG);
        this.sNomeImagePNG = sNomeImagePNG;
        this.hero = hero;
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(Desenho.acessoATelaDoJogo().getMoedas() == 4){   //verificao para atirar apenas quando as moedas forem coletadas

            if(!primeiroTiro){                                                      //verificacao para dar um primeiro tiro quando as moedas forem coletadas
                if(this.sNomeImagePNG.equals("MonstroRoxoDireita.png"))            //para em seguida atirar so quando entrar na visao deste inimigo
                    this.atiraRight();
                else if(this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png"))
                    this.atiraLeft();
                else if(this.sNomeImagePNG.equals("MonstroRoxoFrente.png"))
                    this.atiraDown();
                else if(this.sNomeImagePNG.equals("MonstroRoxoTras.png"))
                    this.atiraUp();
                primeiroTiro = true;                                                                        
            }

            if(primeiroTiro && this.sNomeImagePNG.equals("MonstroRoxoDireita.png")){ //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoDireitaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() > this.pPosicao.getColuna() && stopLinha != 1){     //atira caso o heroi esteja na mesma linha do inimigo                
                    stopLinha = 1;                  //altera variavel para garantia de um unico tiro
                    this.atiraRight();         //atira para direita
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha())   //quando o heroi sai da linha do inimigo reseta a variavel para que quando entre novamente o inimigo atire denovo
                    stopLinha = 0;
            }   

            if(primeiroTiro && this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png")){    //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoEsquerdaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() < this.pPosicao.getColuna() && stopLinha != 1){    //atira caso o heroi esteja na mesma linha do inimigo
                    stopLinha = 1;                  //altera variavel para garantia de um unico tiro
                    this.atiraLeft();         //atira para esqueda
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha()) //quando o heroi sai da linha do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopLinha = 0;
            }

            if(primeiroTiro && this.sNomeImagePNG.equals("MonstroRoxoTras.png")){    //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoTras.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() < this.pPosicao.getLinha() && stopColuna != 1){ //atira caso o heroi esteja na mesma coluna do inimigo
                    stopColuna = 1;       //altera variavel para garantia de um unico tiro
                    this.atiraUp(); //atira para cima
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna()) //quando o heroi sai da coluna do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopColuna = 0;
            }

            if(primeiroTiro && this.sNomeImagePNG.equals("MonstroRoxoFrente.png")){  //caso ja tenha dado primeiro tiro
                super.SkinPersonagem("MonstroRoxoFrenteAcordado.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() > this.pPosicao.getLinha() && stopColuna != 1){   //atira caso o heroi esteja na mesma coluna do inimigo
                    stopColuna = 1;                 //altera variavel para garantia de um unico tiro
                    this.atiraDown();      
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna()) //quando o heroi sai da coluna do inimigo reseta a variavel para que quando entre novamente atire denovo
                    stopColuna = 0;
            }

        }
    }

    /*Polimorfismo metodos atirar*/

    @Override
    public void atiraRight(){         
            Tiro t1 = new Tiro("TiroMonstroRoxoDireita.png", 'r');  //instancia objeto tiro
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t1); //adiciona tiro no array de personagens
    }

    @Override
    public void atiraLeft(){
            Tiro t2 = new Tiro("TiroMonstroRoxoEsquerda.png", 'l');  //instancia objeto tiro
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t2); //adiciona tiro no array de personagens
    }

    @Override
    public void atiraUp(){
            Tiro t3 = new Tiro("TiroMonstroRoxoCima.png", 'u'); //instancia objeto tiro
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t3); //adiciona tiro no array de personagens
    } 

    @Override
    public void atiraDown(){
            Tiro t4 = new Tiro("TiroMonstroRoxoBaixo.png", 'd'); //instancia objeto tiro
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t4); //adiciona tiro no array de personagens
    }
}