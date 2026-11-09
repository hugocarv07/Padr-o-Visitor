package padroesprojeto.visitor.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitanteContagemTest {

    @Test
    void deveContarCadaTipoDeItem() {
        Prontuario prontuario = new Prontuario();
        prontuario.adicionar(new Consulta("Dra. Ana", 200.0f));
        prontuario.adicionar(new Consulta("Dr. Paulo", 180.0f));
        prontuario.adicionar(new Exame("Hemograma", 150.0f, false));
        prontuario.adicionar(new Internacao(3, 400.0f));

        VisitanteContagem contagem = new VisitanteContagem();
        prontuario.aceitar(contagem);

        assertEquals(2, contagem.getConsultas());
        assertEquals(1, contagem.getExames());
        assertEquals(1, contagem.getInternacoes());
    }
}
