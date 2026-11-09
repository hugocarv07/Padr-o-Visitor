package padroesprojeto.visitor.hospital;

public class Internacao implements ItemAtendimento {

    private int dias;
    private float valorDiaria;

    public Internacao(int dias, float valorDiaria) {
        this.dias = dias;
        this.valorDiaria = valorDiaria;
    }

    public int getDias() {
        return dias;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
