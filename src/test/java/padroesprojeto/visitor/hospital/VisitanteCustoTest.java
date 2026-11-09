package padroesprojeto.visitor.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitanteCustoTest {

    @Test
    void deveSomarOValorDaConsulta() {
        VisitanteCusto custo = new VisitanteCusto();
        new Consulta("Dra. Ana", 200.0f).aceitar(custo);
        assertEquals(200.0f, custo.getTotal(), 0.01f);
    }

    @Test
    void deveCobrarExameNormalPeloValorBase() {
        VisitanteCusto custo = new VisitanteCusto();
        new Exame("Hemograma", 150.0f, false).aceitar(custo);
        assertEquals(150.0f, custo.getTotal(), 0.01f);
    }

    @Test
    void deveAcrescentarCinquentaPorCentoNoExameUrgente() {
        VisitanteCusto custo = new VisitanteCusto();
        new Exame("Hemograma", 150.0f, true).aceitar(custo);
        assertEquals(225.0f, custo.getTotal(), 0.01f);
    }

    @Test
    void deveMultiplicarDiasPelaDiariaNaInternacao() {
        VisitanteCusto custo = new VisitanteCusto();
        new Internacao(3, 400.0f).aceitar(custo);
        assertEquals(1200.0f, custo.getTotal(), 0.01f);
    }

    @Test
    void deveSomarTodosOsItensDoProntuario() {
        Prontuario prontuario = new Prontuario();
        prontuario.adicionar(new Consulta("Dra. Ana", 200.0f));
        prontuario.adicionar(new Exame("Hemograma", 150.0f, true));
        prontuario.adicionar(new Internacao(3, 400.0f));

        VisitanteCusto custo = new VisitanteCusto();
        prontuario.aceitar(custo);

        assertEquals(1625.0f, custo.getTotal(), 0.01f);
    }

    @Test
    void prontuarioVazioNaoDeveTerCusto() {
        VisitanteCusto custo = new VisitanteCusto();
        new Prontuario().aceitar(custo);
        assertEquals(0.0f, custo.getTotal(), 0.01f);
    }
}
