package padroesprojeto.visitor.hospital;

public interface Visitante {

    void visitar(Consulta consulta);

    void visitar(Exame exame);

    void visitar(Internacao internacao);
}
