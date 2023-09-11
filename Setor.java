import java.util.*;
public abstract class Setor extends Tabuleiro {
    ArrayList<Inimigo> inimigos = new ArrayList<>();
    ArrayList<Entidade> jogador = new ArrayList<>();

    Jogadores jogadorSimples = new JogadorSimples("P1",2,6,2,4);
    Jogadores jogadorSuporte = new JogadorSuporte("P2",1,7,4,9);

    Scanner entrada = new Scanner(System.in);
    Random rand = new Random();
    int atkDef,opAtk,opPlayer;

    public void listaPlayers(){//inicializa o Arraylist de jogadores
        jogador.add(jogadorSimples);
        jogador.add(jogadorSuporte);
    }

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

    public boolean isPorta_norte() {
        return porta_norte;
    }

    public boolean isPorta_sul() {
        return porta_sul;
    }

    public boolean isPorta_leste() {
        return porta_leste;
    }

    public boolean isPorta_oeste() {
        return porta_oeste;
    }


    public void geraInimigos(){//gera os inimigos aleatoriamente e salva em um Arraylist
        int r = rand.nextInt(5)+1;
        for(int i  = 0;i<r;i++){
            atkDef = rand.nextInt(3)+1;
            Inimigo ini = new Inimigo("inimigo",atkDef,atkDef,8,4);
            inimigos.add(ini);
        }
    }
   
    public void imprimirSetor(boolean porta_norte, boolean porta_sul, boolean porta_oeste, boolean porta_leste,String playerJogando){//usado para imprimir o setor
        System.out.println();
        System.out.println("     Setor");
        if(porta_norte==true){
            System.out.println("|------*------|");
        }else
            System.out.println("|-------------|");
        for(int i=0;i<5;i++){
            if(i==0){
                if(inimigos.size()>0) {
                    System.out.print("|");
                    if (inimigos.size() == 1) {
                        for (int j = 0; j < inimigos.size(); j++) {
                            System.out.println("     " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef() + "     |");
                        }
                    }
                    if (inimigos.size() == 2) {
                        for (int j = 0; j < inimigos.size(); j++) {
                            if (j == 1) {
                                System.out.print("   " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef());
                                System.out.println("  |");
                            } else
                                System.out.print("  " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef());
                        }
                    }
                    if (inimigos.size() == 3 || inimigos.size() > 3) {
                        for (int j = 0; j < 3; j++) {
                            if (j == 2) {
                                System.out.print(inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef());
                                System.out.println("|");
                            } else
                                System.out.print(inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef() + "  ");
                        }
                    }
                }else{
                    System.out.println("|             |");
                }
            }

           if(i == 1){
               if(inimigos.size()>3) {
                   System.out.print("|");
                   for (int j = 3; j < inimigos.size(); j++) {
                       if (inimigos.size() == 4) {
                           System.out.println("     " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef() + "     |");
                       }
                       if (inimigos.size() == 5) {
                           if (j == 4) {
                               System.out.print("   " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef());
                               System.out.println("  |");
                           } else
                               System.out.print("  " + inimigos.get(j).getAtk() + "/" + inimigos.get(j).getDef());
                       }
                   }
               }else{
                   System.out.println("|             |");
               }
           }

            if (i==2){
                if(porta_oeste && porta_leste==true){
                    System.out.println("*             *");
                }else if(porta_leste==true){
                    System.out.println("|             *");
                }else if(porta_oeste==true){
                    System.out.println("*             |");
                }else
                    System.out.println("|             |");
            }
            if(i==3){
                if(jogador.size()<2){
                        System.out.println("|     " + jogador.get(0).getNome()  + "      |");
                }
                if(jogador.size()==2) {
                    for(int j = 0;j< jogador.size();j++) {
                        if(j==0)
                            System.out.print("|  " + jogadorSimples.getNome());
                        else
                            System.out.println("     " + jogadorSuporte.getNome() + "  |");
                    }
                }
                if(jogador.size()==0 )
                    System.out.println("|             |");
            }

            if(i==4){
                if(jogador.size()<2) {
                        System.out.println("|     " + jogador.get(0).getAtk() + "/" + jogador.get(0).getDef()+ "     |");
                }
                if(jogador.size()==2)
                    for(int j = 0;j< jogador.size();j++) {
                        if(j==0) {
                            if(jogadorSimples.getDef()<10&jogadorSimples.getDef()>0) {
                                System.out.print("|  " + jogadorSimples.getAtk() + "/" + jogadorSimples.getDef() + "   ");
                            }else{
                                System.out.print("|  " + jogadorSimples.getAtk() + "/" + jogadorSimples.getDef() + "  ");
                            }
                        }else {
                            if(jogadorSuporte.getDef()<10&jogadorSuporte.getDef()>0) {
                                System.out.println(jogadorSuporte.getAtk() + "/" + jogadorSuporte.getDef() + "  |");
                            }else{
                                System.out.println(jogadorSuporte.getAtk() + "/" + jogadorSuporte.getDef() + " |");
                            }
                        }
                    }
                if(jogador.size()==0)
                    System.out.println("|             |");
            }
        }
        if(porta_sul==true){
            System.out.println("|------*------|");
        }else
            System.out.println("|-------------|");

    }

    public void atacar(String playerJogando){//usado para o ataque dos players
        int m;
        if(playerJogando == "P1") {
            m = (inimigos.get(opAtk).getDef()) - jogadorSimples.getAtk();
            inimigos.get(opAtk).setDef(m);
            inimigos.removeIf(inimigo -> inimigo.getDef() <= 0);
        }else{
            m = (inimigos.get(opAtk).getDef()) - jogadorSuporte.getAtk();
            inimigos.get(opAtk).setDef(m);
            inimigos.removeIf(inimigo -> inimigo.getDef() <= 0);
        }
    }

    public void ataqueAleatorio(String playerJogando) throws InterruptedException {//usado para ataquedos player no setor oculto
        int m;
        if(playerJogando == "P1") {
            int probAtk = rand.nextInt(6) + 1;
            if(probAtk % 2 == 0) {
                m = (inimigos.get(opAtk).getDef()) - jogadorSimples.getAtk();
                inimigos.get(opAtk).setDef(m);
                inimigos.removeIf(inimigo -> inimigo.getDef() <= 0);
            }else{
                System.out.println("O jogador P1 errou o ataque!");
                Thread.sleep(1000);
            }
        }else{
            int probAtk = rand.nextInt(6) + 1;
            if(probAtk % 2 == 0) {
                m = (inimigos.get(opAtk).getDef()) - jogadorSuporte.getAtk();
                inimigos.get(opAtk).setDef(m);
                inimigos.removeIf(inimigo -> inimigo.getDef() <= 0);
            }else{
                System.out.println("O jogador P2 errou o ataque!");
                Thread.sleep(1000);
            }
        }
    }

    public void selecionarAlvo(){//o player seleciona o alvo que deseja atacar
        do{
            try{
                System.out.println("Selecione o alvo de 1 a "+(inimigos.size()));
                opAtk= entrada.nextInt()-1;
            }
            catch(InputMismatchException e){
                System.out.println("Insira um numero valido.");
                entrada.nextLine();
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Insira um numero valido.");
                entrada.nextLine();
            }
        }while(opAtk >= inimigos.size() || opAtk<0);
    }

    public void curar(){//o jogador suporte seleciona quem ele vai curar
        int c;
        do {
            try {
                System.out.println("Qual player deseja curar?\n1-P1     2-P2\n");
                opPlayer = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Insira um numero valido.");
                opPlayer = entrada.nextInt();
            }
        }while(opPlayer!=1 & opPlayer != 2);

        if(opPlayer == 1){
            c = (jogadorSimples.getDef()+2);
            jogadorSimples.setDef(c);
        }else{
            c = (jogadorSuporte.getDef()+2);
            jogadorSuporte.setDef(c);
        }
    }

    public void procurar(String playerJogando) throws InterruptedException {//player realiza ação de procurar no setor, desde que nao seja um setor privado
        int prob,t;
        prob = rand.nextInt(6)+1;
        if(prob==4) {
            System.out.println("O jogador ganha 1 de DEF!");
            Thread.sleep(1000);
            if(playerJogando == "P1"){
                t = (jogadorSimples.getDef())+1;
                jogadorSimples.setDef(t);
            }else{
                t = (jogadorSuporte.getDef())+1;
                jogadorSuporte.setDef(t);
            }
        }if(prob==5) {
            System.out.println("O jogador ganha 2 de DEF!");
            Thread.sleep(1000);
            if(playerJogando == "P1"){
                t = (jogadorSimples.getDef())+2;
                jogadorSimples.setDef(t);
            }else{
                t = (jogadorSuporte.getDef())+2;
                jogadorSuporte.setDef(t);
            }
        }if(prob==6) {
            if(inimigos.size()>0) {
                System.out.println("Todos os inimigos perdem 1 de DEF!");
                Thread.sleep(1000);
                for (int i = 0; i < inimigos.size(); i++) {
                    t = (inimigos.get(i).getDef()) - 1;
                    inimigos.get(i).setDef(t);
                }
                inimigos.removeIf(inimigo -> inimigo.getDef() <= 0);
            }else{
                System.out.println("Nada foi encontrado!");
                Thread.sleep(1000);
            }
        }if(prob<4)
            System.out.println("Nada foi encontrado!");
            Thread.sleep(1000);
    }

    public void atkInimigo() throws InterruptedException {//os inimigos atacam os players
        int i,probAtk;
        for(int n = 0;n < inimigos.size();n++){
                for (int j = 0; j < jogador.size(); j++) {
                    probAtk = rand.nextInt(6) + 1;
                    if (probAtk % 2 == 0) {
                        i = (jogador.get(j).getDef()) - (inimigos.get(n).getAtk());
                        jogador.get(j).setDef(i);
                        System.out.println("O inimigo atacou o jogador " + jogador.get(j).getNome() + "!");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("O inimigo errou o ataque no jogador " + jogador.get(j).getNome() + "!");
                        Thread.sleep(1000);
                    }
                    if(jogador.get(j).getDef()<=0){
                        System.out.println("O jogador "+jogador.get(j).getNome()+" foi eliminado!");
                        Thread.sleep(1000);
                    }
                }
            jogador.removeIf(jogadores -> jogadores.getDef()<=0);
        }

    }

    public abstract void imprimirSetor(boolean porta_norte, boolean porta_sul, boolean porta_oeste, boolean porta_leste, ArrayList<String> setorP1, ArrayList<String> setorP2, String playerJogando);


}


