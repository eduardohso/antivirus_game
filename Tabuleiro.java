import java.util.*;
public class Tabuleiro{

    private Setor[][] setores = new Setor[5][5];
    protected int linha_virus,coluna_virus,linhap1,colunap1,linhap2,colunap2;
    public void setPorta_norte(boolean porta_norte) {
        this.porta_norte = porta_norte;
    }

    public void setPorta_sul(boolean porta_sul) {
        this.porta_sul = porta_sul;
    }

    public void setPorta_leste(boolean porta_leste) {
        this.porta_leste = porta_leste;
    }

    public void setPorta_oeste(boolean porta_oeste) {
        this.porta_oeste = porta_oeste;
    }

    public void limpaConsole(){
        for (int cl = 0; cl < 20; cl++) { // limpa o console onde é printado o jogo
            System.out.println();
        }
    }

    public int tipoSetor(){//define o tipo de setor de forma aleatoria
        Random aleatorio= new Random();
        int prob = aleatorio.nextInt(10)+1;
        return prob;
        /*Se prob<6 == setor normal
        * Se prob>5&prob<9 == setor privado
        * Se prob>8 == setor oculto*/

    }
    Random rand = new Random();
    protected boolean porta_norte,porta_sul,porta_leste,porta_oeste;


    public void gerarFonteInfecção(){// gera a posição da fonte de infecção de forma aleatoria
        Random aleatorio = new Random();
        do{
            this.linha_virus= aleatorio.nextInt(5);
            this.coluna_virus= aleatorio.nextInt(5);
        }while(this.linha_virus==2&&this.coluna_virus==2||this.linha_virus==2&&this.coluna_virus==1||this.linha_virus==2&&this.coluna_virus==3
                ||this.linha_virus==1&&this.coluna_virus==2||this.linha_virus==3&&this.coluna_virus==2 );
    }

    public boolean gerarPorta(){
        boolean porta;
        int prob;
        prob = rand.nextInt(10);
        if(prob <= 3){
            porta = false; //  false ou seja uma porta não é gerada, é gerada uma parede
        }else
            porta = true; //  true e uma porta é gerada
        return porta; // retorna o resultado da função randomica dependendo do resultado uma porta será ou não gerada na main
    }

    public void imprimirTabuleiro(int linhap1, int colunap1, int linhap2, int colunap2){// imprimi o tabuleiro
        System.out.println("---------------------------");
        System.out.println("|   Antivírus por um dia  |");
        System.out.println("---------------------------");
        System.out.println("     1   2   3   4   5");

        for(int i=0;i<setores.length;i++){
            System.out.printf("   |");
            for(int j=0;j< setores.length;j++){
                System.out.printf("---|");
            }
            System.out.println();
            System.out.printf((i+1)+"  |");
            for(int j=0;j< setores.length;j++){
                if(linhap1==linhap2&&colunap1==colunap2){
                    if(linhap1==i&&colunap1==j){
                        System.out.printf(" P |");
                    }else if(linha_virus==i&&coluna_virus==j){
                        System.out.print(" X |");
                    }else
                        System.out.printf("   |");
                }
            }
            System.out.println();
        }
        System.out.println("   |---|---|---|---|---|");

    }

}