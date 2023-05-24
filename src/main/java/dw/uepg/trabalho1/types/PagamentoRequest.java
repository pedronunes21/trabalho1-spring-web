package dw.uepg.trabalho1.types;

public class PagamentoRequest {
    private int ano;
    private int mes;
    private float valor;
    private long codJogador;

    public PagamentoRequest(int ano, int mes, float valor, long codJogador) {
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.codJogador = codJogador;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public long getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(long codJogador) {
        this.codJogador = codJogador;
    }
}
