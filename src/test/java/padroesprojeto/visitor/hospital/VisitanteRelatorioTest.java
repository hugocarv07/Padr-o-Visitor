package padroesprojeto.visitor.hospital;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitanteRelatorioTest {

    @Test
    void deveGerarUmaLinhaPorTipoDeItem() {
        Prontuario prontuario = new Prontuario();
        prontuario.adicionar(new Consulta("Dra. Ana", 200.0f));
        prontuario.adicionar(new Exame("Hemograma", 150.0f, false));
        prontuario.adicionar(new Exame("Raio-X", 300.0f, true));
        prontuario.adicionar(new Internacao(3, 400.0f));

        VisitanteRelatorio relatorio = new VisitanteRelatorio();
        prontuario.aceitar(relatorio);

        assertEquals(List.of(
                "Consulta: Dra. Ana - R$ 200,00",
                "Exame: Hemograma - R$ 150,00",
                "Exame: Raio-X (urgente) - R$ 300,00",
                "Internação: 3 dias - R$ 1.200,00"), relatorio.getLinhas());
    }

    @Test
    void deveJuntarAsLinhasNoRelatorio() {
        Prontuario prontuario = new Prontuario();
        prontuario.adicionar(new Consulta("Dra. Ana", 200.0f));
        prontuario.adicionar(new Internacao(2, 400.0f));

        VisitanteRelatorio relatorio = new VisitanteRelatorio();
        prontuario.aceitar(relatorio);

        assertEquals("Consulta: Dra. Ana - R$ 200,00\nInternação: 2 dias - R$ 800,00", relatorio.getRelatorio());
    }
}
