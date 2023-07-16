package br.com.devmos.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devmos.model.Person;

public class PersonServiceImpl {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		List<Person> lista = readCSV();
		System.out.println(lista);
	}

	public static List<Person> readCSV() throws IOException {
		String fileName = "src/main/resources/dados/salary_data.csv";
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

			return br.lines().skip(1).map(line -> {
				String[] valor = line.split(",");

				var person = new Person();
				person.setAge(Integer.valueOf(valor[0]));
				person.setGender(valor[1]);
				person.setEducationLevel(valor[2]);
				person.setJobTitle(valor[3]);
				person.setYearsOfExperience(Double.valueOf(valor[4]));
				person.setSalary(Double.valueOf(valor[5]));

				return person;

			}).collect(Collectors.toList());

		}

	}

}
