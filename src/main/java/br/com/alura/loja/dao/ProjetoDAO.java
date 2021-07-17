package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Projeto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ProjetoDAO {

    private static Map<Long, Projeto> banco = new HashMap<>();
    private static AtomicLong contador = new AtomicLong(1);

    static {
        banco.put(1L, new Projeto("Minha loja", 1L,  2014));
        banco.put(2L, new Projeto("Alura", 2L,  2012));
    }

    public void adiciona(Projeto projeto) {
        long id = contador.incrementAndGet();
        projeto.setId(id);
        banco.put(id, projeto);
    }

    public Projeto busca(Long id) {
        return banco.get(id);
    }

    public Projeto remove(long id) {
        return banco.remove(id);
    }
}
