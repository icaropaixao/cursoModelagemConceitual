package com.icaropaixao.cursomodelagem;

import com.icaropaixao.cursomodelagem.domain.*;
import com.icaropaixao.cursomodelagem.domain.enums.TipoCliente;
import com.icaropaixao.cursomodelagem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoModelagemApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoModelagemApplication.class, args);
    }

    // executa quando roda a aplicação
    // salvando dados no banco
    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null,"Informática");
        Categoria cat2 = new Categoria(null,"Escritório");

        Produto p1 = new Produto(null,"computador",2000.00);
        Produto p2 = new Produto(null,"impressora",800.00);
        Produto p3 = new Produto(null,"Mouse",80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().add(cat1);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

        Estado est1 = new Estado(null,"Minas Gerais");
        Estado est2 = new Estado(null,"São paulo");

        Cidade c1= new Cidade(null,"Uberlândia",est1);
        Cidade c2 = new Cidade(null, "São paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));


        Cliente cli1= new Cliente(null,"Maria","maria@email","122333444", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("(21)8877291","(31)122433"));

        Endereco e1 = new Endereco (null,"ruaFlores","222","apto 200","Jardim","21222",cli1,c1);
        Endereco e2= new Endereco (null,"Av.matos","333","apto 300","Céu","21333",cli1,c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

    }

}
