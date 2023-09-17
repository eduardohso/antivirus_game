import java.util.*;
public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Scanner entrada= new Scanner(System.in);
        Jogadores p1= new JogadorSimples("P1",2,6,2,2);
        Jogadores p2= new JogadorSuporte("P2",1,7,2,2);
        Tabuleiro tabuleiro = new Tabuleiro();
        String playerJogando;
        int op = 0;
        tabuleiro.gerarFonteInfeccao();

        Setor setor = new Setor(){
            @Override
            public void imprimirSetor(boolean porta_norte, boolean porta_sul, boolean porta_oeste, boolean porta_leste, ArrayList<String> setorP1, ArrayList<String> setorP2, String playerJogando) {

            }
        };
        setor.listaPlayers();
        char comando = 'j';
        boolean continua = true;
        int n;
        System.out.println("---------------------------");
        System.out.println("|   Antivírus por um dia  |");
        System.out.println("---------------------------");
        System.out.println("Objetivo do jogo:\nChegar até a fonte de infecção representada pelo X.");
        do{
            try {
                System.out.println("O que deseja fazer:\n1- Iniciar jogo  2- Sair");
                op = entrada.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Insira uma opção valida!");
                entrada.next();
            }
        }while(op!=1 & op!= 2);
        if(op==1) {
            op = 0;
            tabuleiro.limpaConsole();
            for (int t = 1; t < 26; ) {
                do {
                    try { // movimentação jogador
                        System.out.println("Turno "+t);
                        tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                        System.out.println("Selecione uma porta para entrar: W- Cima, S- Baixo, A- Direita, D- Esquerda ");
                        comando = entrada.next().charAt(0);
                        comando = Character.toLowerCase(comando);
                        tabuleiro.limpaConsole();
                        p1.movimentarJogador(comando);
                        p2.movimentarJogador(comando);
                    } catch (InputMismatchException e) {
                        System.out.println("Insira um comando Válido W- Cima, S- Baixo, A- Direita, D- Esquerda ");
                    }
                } while (comando != 'w' & comando != 'W' & comando != 'a' & comando != 'A' & comando != 's' & comando != 'S' & comando != 'd' & comando != 'D'&continua);
                if ((p1.posi_linha == tabuleiro.linha_virus) & (p1.posi_coluna == tabuleiro.coluna_virus)) {
                    System.out.println("Você venceu!");
                    System.out.println("Parabens voce conseguiu chegar ate a fonte de infecção!");
                    break;
                }
                if ((p2.posi_linha == tabuleiro.linha_virus) & (p2.posi_coluna == tabuleiro.coluna_virus)) {
                    System.out.println("Você venceu!");
                    System.out.println("Parabens voce conseguiu chegar ate a fonte de infecção!");
                    break;
                }
                if (t == 25 & ((p2.posi_linha & p2.posi_coluna) != (tabuleiro.linha_virus & tabuleiro.coluna_virus)) ||
                        t == 25 & ((p1.posi_linha & p1.posi_coluna) != (tabuleiro.linha_virus & tabuleiro.coluna_virus))) {
                    System.out.println("Você perdeu!");
                    System.out.println("Fim de jogo!");
                    break;
                }
                if ((p1.posi_linha & p1.posi_coluna) == (p2.posi_linha & p2.posi_coluna)) {
                    n = tabuleiro.tipoSetor();
                    setor.setPorta_norte(setor.gerarPorta());
                    setor.setPorta_sul(setor.gerarPorta());
                    setor.setPorta_oeste(setor.gerarPorta());
                    setor.setPorta_leste(setor.gerarPorta());
                    setor.geraInimigos();
                    do {
                        if (setor.jogador.size() > 1) {
                            playerJogando = setor.jogador.get(0).getNome();
                            if (playerJogando.equals("P1")) {
                                for (int i = 0; i < 2; i++) {
                                    tabuleiro.limpaConsole();
                                    System.out.println("Turno " + t);
                                    tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                                    setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                                    System.out.println("Qual ação quer realizar?");
                                    if(n<6) {
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2-Procurar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>8){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2-Procurar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.ataqueAleatorio(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>5&n<9){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 );
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1);
                                            if (op == 1) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                }
                                Thread.sleep(1000);
                                tabuleiro.limpaConsole();
                            }

                            playerJogando = setor.jogador.get(1).getNome();
                            op = 0;
                            if (playerJogando.equals("P2")) {
                                for (int i = 0; i < 2; i++) {
                                    tabuleiro.limpaConsole();
                                    System.out.println("Turno " + t);
                                    tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                                    setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                                    System.out.println("Qual ação quer realizar?");
                                    if(n<6) {
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Procurar  3- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 3) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2- Curar  3- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            if (op == 3) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>8){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Procurar  3- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.ataqueAleatorio(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 3) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2- Curar  3- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            if (op == 3) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>5&n<9){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Curar  2- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.curar();
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                }
                                Thread.sleep(1000);
                                tabuleiro.limpaConsole();
                            }

                            System.out.println("Turno " + t);
                            tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                            setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                            if (setor.inimigos.size() > 0) {
                                setor.atkInimigo();
                            }
                            Thread.sleep(1000);
                            tabuleiro.limpaConsole();
                            t++;
                            if (setor.jogador.size() == 0) {
                                System.out.println("Você perdeu! Todos os players foram eliminados!");
                                System.out.println("Fim de jogo!");
                                break;
                            }
                        }

                        if (setor.jogador.size() < 2) {
                            playerJogando = setor.jogador.get(0).getNome();
                            op = 0;
                            if (playerJogando.equals("P1")) {
                                for (int i = 0; i < 2; i++) {
                                    tabuleiro.limpaConsole();
                                    System.out.println("Turno " + t);
                                    tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                                    setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                                    System.out.println("Qual ação quer realizar?");
                                    if(n<6) {
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2-Procurar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>8){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2-Procurar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.ataqueAleatorio(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>5&n<9){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 );
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.ataqueAleatorio(playerJogando);
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1-Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1);
                                            if (op == 1) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                }
                                Thread.sleep(1000);
                                tabuleiro.limpaConsole();
                            }
                            if (playerJogando.equals("P2")) {
                                op = 0;
                                for (int i = 0; i < 2; i++) {
                                    tabuleiro.limpaConsole();
                                    System.out.println("Turno " + t);
                                    tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                                    setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                                    System.out.println("Qual ação quer realizar?");
                                    if(n<6) {
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Procurar  3- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 3) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2- Curar  3- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            if (op == 3) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>8){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Procurar  3- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.ataqueAleatorio(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 3) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Procurar  2- Curar  3- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2 & op != 3);
                                            if (op == 1) {
                                                setor.procurar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            if (op == 3) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }
                                    if(n>5&n<9){
                                        if (setor.inimigos.size() > 0) {
                                            do {
                                                try {
                                                    System.out.println("1- Atacar  2- Curar");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.selecionarAlvo();
                                                setor.atacar(playerJogando);
                                            }
                                            if (op == 2) {
                                                setor.curar();
                                            }
                                            op = 0;
                                        } else {
                                            do {
                                                try {
                                                    System.out.println("1- Curar  2- Nada");
                                                    op = entrada.nextInt();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Insira uma opção valida!");
                                                    entrada.next();
                                                }
                                            } while (op != 1 & op != 2);
                                            if (op == 1) {
                                                setor.curar();
                                            }
                                            if (op == 2) {
                                                tabuleiro.limpaConsole();
                                            }
                                            op = 0;
                                        }
                                    }

                                }
                                Thread.sleep(1000);
                                tabuleiro.limpaConsole();
                            }
                            System.out.println("Turno " + t);
                            tabuleiro.imprimirTabuleiro(p1.getPosi_linha(), p1.getPosi_coluna(), p2.getPosi_linha(), p2.getPosi_coluna());
                            setor.imprimirSetor(setor.porta_norte, setor.porta_sul, setor.porta_oeste, setor.porta_leste, playerJogando);
                            if (setor.inimigos.size() > 0) {
                                setor.atkInimigo();
                            }
                            Thread.sleep(1000);
                            tabuleiro.limpaConsole();
                            t++;
                            if (setor.jogador.size() == 0) {
                                System.out.println("Você perdeu! Todos os players foram eliminados!");
                                System.out.println("Fim de jogo!");
                                break;
                            }
                        }
                    } while (setor.inimigos.size() > 0);
                    if (setor.jogador.size() == 0) {
                        break;
                    }
                }
            }
        }if(op==2){
            System.out.println("Saindo...");
        }
    }
}
