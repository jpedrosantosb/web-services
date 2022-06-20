package com.exemplo.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemplo.projeto.entities.Categoria;
import com.exemplo.projeto.entities.Ordem;
import com.exemplo.projeto.entities.OrdemItem;
import com.exemplo.projeto.entities.Pagamento;
import com.exemplo.projeto.entities.Produto;
import com.exemplo.projeto.entities.Usuario;
import com.exemplo.projeto.entities.enums.OrdemStatus;
import com.exemplo.projeto.repositories.CategoriaRepository;
import com.exemplo.projeto.repositories.OrdemItemRepository;
import com.exemplo.projeto.repositories.OrdemRepository;
import com.exemplo.projeto.repositories.ProdutoRepository;
import com.exemplo.projeto.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private OrdemRepository ordemRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private OrdemItemRepository ordemItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");

		Produto p1 = new Produto(null, "A Revolução dos Bichos", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Madame Bovary", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Usuario u1 = new Usuario(null, "Pedro Santos", "santos@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Joao Bastos", "bastos@gmail.com", "977777777", "123456");

		Ordem o1 = new Ordem(null, Instant.parse("2019-06-20T19:53:07Z"), OrdemStatus.ENTREGUE, u1);
		Ordem o2 = new Ordem(null, Instant.parse("2019-07-21T03:42:10Z"), OrdemStatus.AGUARDANDO_PAGAMENTO, u2);
		Ordem o3 = new Ordem(null, Instant.parse("2019-07-22T15:21:22Z"), OrdemStatus.CANCELADO, u1);

		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		ordemRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrdemItem oi1 = new OrdemItem(o1, p1, 2, p1.getPreco());
		OrdemItem oi2 = new OrdemItem(o1, p3, 1, p3.getPreco());
		OrdemItem oi3 = new OrdemItem(o2, p3, 2, p3.getPreco());
		OrdemItem oi4 = new OrdemItem(o3, p5, 2, p5.getPreco());

		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Pagamento pay1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPagamento(pay1);

		ordemRepository.save(o1);
	}
}
