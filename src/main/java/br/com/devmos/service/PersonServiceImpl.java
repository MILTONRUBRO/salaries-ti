package br.com.devmos.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import br.com.devmos.EntradaDeDados;
import br.com.devmos.ObterDadosCSV;
import br.com.devmos.model.Person;

public class PersonServiceImpl {

	private final EntradaDeDados leitor = new EntradaDeDados();
	private final String DIGITE_OPCAO_DESEJADA = "Digite a opção desejada: ";
	private final String OPCAO_SAIR = "x";
	private final String OPCAO_CADASTRAR_EM_LOTE = "1";
	private final String OPCAO_LISTAR_REGISTROS = "2";
	private final String OPCAO_BUSCA_POR_SALARIO = "3";
	private final String OPCAO_BUSCA_POR_IDADE = "4";
	private final String ORDENAR = "5";
	private final String REMOVER_DUPLICADOS = "6";
	private final String TOTAL_REGISTROS = "7";

	List<Person> persons = new ArrayList<>();
	Map<Integer, List<Person>> mapAgePerson = new HashMap<>();

	private void iniciaApp() {
		carregaNomeApp();
	}

	private void carregaMenu() {
		iniciaApp();

		System.out.println("********  DIGITE A OPÇÃO DESEJADA   ******");

		System.out.println("1 - CADASTRO EM LOTE (CSV)");
		System.out.println("2 - LISTAR REGISTROS");
		System.out.println("3 - BUSCAR POR SALARIO ANUAL");
		System.out.println("4 - BUSCAR POR IDADE");
		System.out.println("5 - ORDENAR LISTA");
		System.out.println("6 - REMOVER DUPLICADOS");
		System.out.println("7 - TOTAL REGISTROS");

		System.out.println("X - SAIR");
	}

	private void carregaNomeApp() {
		System.out.println("******************************************");
		System.out.println("*********** SALARIOS TI EUA **************");
		System.out.println("******************************************");
	}

	private void finalizaApp() {
		System.out.println("Até logo!!");
	}

	private void opcaoInvalida() {
		System.out.println("Opção INVÁLIDA. Tente novamente.");
	}

	public void processar() throws IOException {

		String opcaoDigitada = obterEntradaDoUsuario(leitor);

		while (!escolheuSair(opcaoDigitada)) {
			tratarOpcaoSelecionada(opcaoDigitada);
			opcaoDigitada = obterEntradaDoUsuario(leitor);
		}

		finalizaApp();

	}

	private String obterEntradaDoUsuario(EntradaDeDados leitor) {
		carregaMenu();
		System.out.print(DIGITE_OPCAO_DESEJADA);
		return leitor.obterEntrada().toLowerCase();
	}

	private boolean escolheuSair(String opcaoDigitada) {
		return opcaoDigitada.equals(OPCAO_SAIR);
	}

	private void tratarOpcaoSelecionada(String opcaoDigitada) throws IOException {
		switch (opcaoDigitada) {
		case OPCAO_SAIR:
			break;
		
		case OPCAO_CADASTRAR_EM_LOTE:
			carregarRegistrosEmLote();
			pularLinha(2);
			break;
		
		case OPCAO_LISTAR_REGISTROS:
			listarRegistros();
			pularLinha(2);
			break;
		
		case OPCAO_BUSCA_POR_SALARIO:
			buscaPorSalario();
			pularLinha(2);
			break;
		
		case OPCAO_BUSCA_POR_IDADE:
			buscaPorIdade();
			pularLinha(2);
			break;
		
		case ORDENAR:
			ordenar();
			pularLinha(2);
			break;
		
		case REMOVER_DUPLICADOS:
			remover();
			pularLinha(2);
			break;
		
		case TOTAL_REGISTROS:
			totalRegistros();
			pularLinha(2);
			break;
		default:
			opcaoInvalida();
			break;
		}
	}

	public void pularLinha(int numeroDeLinhas) {
		for (int i = 1; i <= numeroDeLinhas; i++) {
			System.out.println();
		}
	}

	private void totalRegistros() {
		System.out.println("TOTAL DE REGISTROS = " + persons.size());

	}
	
	private void carregarRegistrosEmLote() throws IOException {
		persons = new ObterDadosCSV().listSalaries();
		System.out.println("Dados Cadastrados com Sucesso");
	}
	
	private void listarRegistros() {
		StringBuilder sb = new StringBuilder();

		if (persons.isEmpty()) {
			sb.append("[]");
		} else {
			sb.append("[\n");
			for (Person person : persons) {
				sb.append("\t").append(person).append(",\n");
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n]");
		}

		System.out.println(sb);
	}
	
	private void listarRegistros(List<Person> list) {
		StringBuilder sb = new StringBuilder();

		if (persons.isEmpty()) {
			sb.append("[]");
		} else {
			sb.append("[\n");
			for (Person person : list) {
				sb.append("\t").append(person).append(",\n");
			}
			sb.setLength(sb.length() - 2);
			sb.append("\n]");
		}

		System.out.println(sb);
	}
	
	private void remover() {
		Set<Person> set = new HashSet<>(persons);
		List<Person> personsWithoutDuplicate = new ArrayList<>(set);
		persons = personsWithoutDuplicate;
		System.out.println("Removidos com sucesso!");

	}
	
	private void ordenar() {
		persons.sort(Comparator.comparing(Person::getSalary));
		System.out.println("LISTA ORDERNADA COM SUCESSO!!");
		listarRegistros();
	}
	
	private void buscaPorIdade() {

		List<Person> response = new ArrayList<>();
		System.out.print("Digite a idade desejada: ");
		int age = Integer.valueOf(leitor.obterEntrada());
		
		for (Person person : persons) {
			if (age == person.getAge())
				response.add(person);
		}

		if (Objects.nonNull(response)) {
			listarRegistros(response);
		}else {
			System.out.println("Nenhum dado econtrado para a idade : " + age);
		}
	}
	
	private void buscaPorSalario() {

		List<Person> response = new ArrayList<>();
		System.out.print("Digite o salario Desejado: ");
		Double salary = Double.valueOf(leitor.obterEntrada());
		
		for (Person person : persons) {
			if (salary.equals(person.getSalary()))
				response.add(person);
		}

		if (Objects.nonNull(response)) {
			listarRegistros(response);
		}else {
			System.out.println("Nenhum dado econtrado para o salario : " + salary);
		}
	}

}
