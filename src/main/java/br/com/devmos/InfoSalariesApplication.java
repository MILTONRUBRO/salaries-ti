package br.com.devmos;

import java.io.IOException;

import br.com.devmos.service.PersonServiceImpl;

public class InfoSalariesApplication {
	
	public static void main(String[] args) throws IOException {
		try(EntradaDeDados leitor = new EntradaDeDados()) {
            new PersonServiceImpl().processar();
        }
	}

}
