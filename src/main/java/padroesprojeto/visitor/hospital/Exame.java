package padroesprojeto.visitor.hospital;

public class Exame implements ItemAtendimento {

    private String tipo;
    private float valor;
    private boolean urgente;

    public Exame(String tipo, float valor, boolean urgente) {
        this.tipo = tipo;
        this.valor = valor;
        this.urgente = urgente;
    }

    public String getTipo() {
        return tipo;
    }

    public float getValor() {
        return valor;
    }

    public boolean isUrgente() {
        return urgente;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
