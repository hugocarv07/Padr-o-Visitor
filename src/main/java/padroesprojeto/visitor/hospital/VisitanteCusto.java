package padroesprojeto.visitor.hospital;

public class VisitanteCusto implements Visitante {

    private float total;

    public float getTotal() {
        return total;
    }

    @Override
    public void visitar(Consulta consulta) {
        total += consulta.getValor();
    }

    @Override
    public void visitar(Exame exame) {
        if (exame.isUrgente()) {
            total += exame.getValor() * 1.5f;
        } else {
            total += exame.getValor();
        }
    }

    @Override
    public void visitar(Internacao internacao) {
        total += internacao.getDias() * internacao.getValorDiaria();
    }
}
