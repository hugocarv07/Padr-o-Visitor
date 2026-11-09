package padroesprojeto.visitor.hospital;

public class VisitanteContagem implements Visitante {

    private int consultas;
    private int exames;
    private int internacoes;

    public int getConsultas() {
        return consultas;
    }

    public int getExames() {
        return exames;
    }

    public int getInternacoes() {
        return internacoes;
    }

    @Override
    public void visitar(Consulta consulta) {
        consultas++;
    }

    @Override
    public void visitar(Exame exame) {
        exames++;
    }

    @Override
    public void visitar(Internacao internacao) {
        internacoes++;
    }
}
