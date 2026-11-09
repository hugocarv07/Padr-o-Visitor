package padroesprojeto.visitor.hospital;

public class Consulta implements ItemAtendimento {

    private String medico;
    private float valor;

    public Consulta(String medico, float valor) {
        this.medico = medico;
        this.valor = valor;
    }

    public String getMedico() {
        return medico;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
