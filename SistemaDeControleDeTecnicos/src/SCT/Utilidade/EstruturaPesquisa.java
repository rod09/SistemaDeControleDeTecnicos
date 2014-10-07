package SCT.Utilidade;

public class EstruturaPesquisa {

    private String campo;//campo para ordenacao
    private boolean ascendente;//indica se o indice deve ser pesquisado com ascendente
    private int limite;
    private String condicao;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public boolean isAscendente() {
        return ascendente;
    }

    public void setAscendente(boolean ascendente) {
        this.ascendente = ascendente;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getOrdem() {
        String ret = "";
        if (!isAscendente()) {
            ret += " DESC ";
        }
        return ret;
    }
}
