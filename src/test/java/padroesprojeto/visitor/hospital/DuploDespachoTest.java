package padroesprojeto.visitor.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuploDespachoTest {

    private static class VisitanteEspiao implements Visitante {
        final StringBuilder chamadas = new StringBuilder();

        public void visitar(Consulta consulta) { chamadas.append("Consulta;"); }
        public void visitar(Exame exame) { chamadas.append("Exame;"); }
        public void visitar(Internacao internacao) { chamadas.append("Internacao;"); }
    }

    @Test
    void deveEscolherOMetodoDoVisitantePelaClasseConcretaDoItem() {
        ItemAtendimento consulta = new Consulta("Dra. Ana", 200.0f);
        ItemAtendimento exame = new Exame("Hemograma", 150.0f, false);
        ItemAtendimento internacao = new Internacao(1, 400.0f);

        VisitanteEspiao espiao = new VisitanteEspiao();
        consulta.aceitar(espiao);
        exame.aceitar(espiao);
        internacao.aceitar(espiao);

        assertEquals("Consulta;Exame;Internacao;", espiao.chamadas.toString());
    }

    @Test
    void deveAplicarOMesmoProntuarioAVisitantesDiferentes() {
        Prontuario prontuario = new Prontuario();
        prontuario.adicionar(new Consulta("Dra. Ana", 200.0f));
        prontuario.adicionar(new Exame("Hemograma", 150.0f, false));

        VisitanteCusto custo = new VisitanteCusto();
        VisitanteContagem contagem = new VisitanteContagem();
        prontuario.aceitar(custo);
        prontuario.aceitar(contagem);

        assertEquals(350.0f, custo.getTotal(), 0.01f);
        assertEquals(2, contagem.getConsultas() + contagem.getExames());
    }
}
