package padroesprojeto.visitor.hospital;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {

    private final List<ItemAtendimento> itens = new ArrayList<>();

    public void adicionar(ItemAtendimento item) {
        itens.add(item);
    }

    public void aceitar(Visitante visitante) {
        for (ItemAtendimento item : itens) {
            item.aceitar(visitante);
        }
    }
}
