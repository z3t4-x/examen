package examen.com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import examen.com.dao.IEmpresaDAO;
import examen.com.domain.Empresa;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	public CommandLineRunner bookDemo(IEmpresaDAO dao) {
		return (args) -> {

			// crear empresa

			dao.save(new Empresa("11223344556", "Empresa 1", "Lima san Borja", true));
			dao.save(new Empresa("11223344557", "Empresa 2", "Lima Jesús Maria", true));
			dao.save(new Empresa("11223344533", "Empresa 3", "Lima san Bartolo", true));
			dao.save(new Empresa("11223344544", "Empresa 4", "Lima san Andrés", false));
			dao.save(new Empresa("11223344511", "Empresa 5", "Lima san Catalomés", true));
			dao.save(new Empresa("11225544511", "Empresa 6", "Lima san Valencia", true));

			// listar empresas
			System.out.println("Books found with findAll():");
			System.out.println("---------------------------");
			for (Empresa empresa : dao.findAll()) {
				System.out.println("id ==> " + empresa.getIdEmpresa());
				System.out.println(empresa.toString());
			}
			System.out.println();

			//

		};
	}

}
