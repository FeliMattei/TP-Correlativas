package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.*;
import ar.edu.utn.link.correlativas.model.Alumno;
import ar.edu.utn.link.correlativas.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AppCorrelativas {

    @Autowired
    RepositoryRestConfiguration config;

    @Value("${algo}")
    private int unNumero;

    @Value("${path}")
    private String path;

    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner materia(RepoMateriaJPA repo) {
        config.exposeIdsFor(Materia.class);

        return (args) -> {
            repo.save(new Materia("Sistemas operativos",3));
            repo.save(new Materia("Matemática discreta",1));
            repo.save(new Materia("Sintaxis",2));
            repo.save(new Materia("Análisis",1));
            repo.save(new Materia("Paradigmas",2));
            repo.save(new Materia("Física",3));

        };
    }

    @Bean
    public CommandLineRunner alumno(RepoAlumnoJPA repo){
        config.exposeIdsFor(Alumno.class);

        return (args) -> {
            /*Materia algo = new Materia("Algo", 1);
            Alumno pepe = new Alumno("Pepe", "Gonzalez");

            pepe.getMateriasAprobadas().add(algo);
            repo.save(pepe);*/
            repo.save(new Alumno("Juan", "Gomez"));
            repo.save(new Alumno("Luis", "Lopez"));
            repo.save(new Alumno("Carlos", "Gardel"));
            repo.save(new Alumno("Laura", "Pereyra"));
        };
    }
}
