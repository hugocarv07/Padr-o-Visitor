package padroesprojeto.visitor.hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VisitanteRelatorio implements Visitante {

    private static final Locale BR = Locale.forLanguageTag("pt-BR");

    private final List<String> linhas = new ArrayList<>();

    public List<String> getLinhas() {
        return linhas;
    }

    public String getRelatorio() {
        return String.join("\n", linhas);
    }

    @Override
    public void visitar(Consulta consulta) {
        linhas.add(String.format(BR, "Consulta: %s - R$ %,.2f", consulta.getMedico(), consulta.getValor()));
    }

    @Override
    public void visitar(Exame exame) {
        String urgencia = exame.isUrgente() ? " (urgente)" : "";
        linhas.add(String.format(BR, "Exame: %s%s - R$ %,.2f", exame.getTipo(), urgencia, exame.getValor()));
    }

    @Override
    public void visitar(Internacao internacao) {
        float total = internacao.getDias() * internacao.getValorDiaria();
        linhas.add(String.format(BR, "Internação: %d dias - R$ %,.2f", internacao.getDias(), total));
    }
}
