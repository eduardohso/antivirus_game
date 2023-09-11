public class JogadorSuporte extends Jogadores{
    public JogadorSuporte(String nome,int ataque, int defesa, int posi_coluna, int posi_linha) {
        super(nome,ataque, defesa, posi_coluna, posi_linha);
    }
    public void movimentarJogador(char comando){
         comando= Character.toLowerCase(comando); 
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
                break;
        }
    }

}
