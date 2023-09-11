public abstract class Entidade {
    protected int atk,def;
    protected String nome;
    protected int posi_coluna;
    protected int posi_linha;

    public Entidade(String nome,int atk, int def, int posi_linha, int posi_coluna) {
        this.nome = nome;
        this.atk = atk;
        this.def = def;
        this.posi_linha = posi_linha;
        this.posi_coluna = posi_coluna;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public String getNome(){
        return nome;
    }

    public int getPosi_coluna() {
        return posi_coluna;
    }

    public int getPosi_linha() {
        return posi_linha;
    }


    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def= def;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPosi_coluna(int posi_coluna) {
        this.posi_coluna = posi_coluna;
    }

    public void setPosi_linha(int posi_linha) {
        this.posi_linha = posi_linha;
    }

    
}
