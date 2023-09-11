import java.util.InputMismatchException;
public abstract class Jogadores extends Entidade {
    public Jogadores(String nome,int atk, int def, int posi_coluna, int posi_linha) {
        super(nome,atk, def, posi_coluna, posi_linha);
    }
    public void movimentarJogador(char comando) throws InputMismatchException{//usado para movimentar os players com w a s d

        comando = Character.toLowerCase(comando);
        switch (comando) {
            case 'w':
                posi_linha-=1;
                break;
            case 's':
                posi_linha+=1;
                break;
            case 'a':
                posi_coluna-=1;
                break;
            case 'd':
                posi_coluna+=1;
                break;
            default:
                throw new InputMismatchException();
        }
    }
}