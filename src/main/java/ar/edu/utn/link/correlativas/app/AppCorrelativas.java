package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppCorrelativas {

    @Value("${algo}")
    private int unNumero;

    @Value("${path}")
    private String path;

    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner ejemplo(RepoMateria repo){
        return (cosas) -> {
            repo.save(new Materia("Sistemas operativos",3));
            repo.save(new Materia("Matemática discreta",1));
            repo.save(new Materia("Sintaxis",2));
            repo.save(new Materia("Análisis",1));
            repo.save(new Materia("Paradigmas",2));
            repo.save(new Materia("Física",3));
            System.out.println(unNumero);
            System.out.println(path);
        };
    }
}
