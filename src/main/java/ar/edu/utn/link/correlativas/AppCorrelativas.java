package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.MateriaRepetidaException;
import ar.edu.utn.link.correlativas.app.RepoAlumno;
import ar.edu.utn.link.correlativas.app.RepoMateria;
import ar.edu.utn.link.correlativas.app.RepoMateriaJPA;
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
/*
    @Bean
    public CommandLineRunner alumno(RepoMateriaJPA repo){
        return (args) -> {
            repo.save(new Alumno("Juan"));
            repo.save(new Alumno("Luis"));
            repo.save(new Alumno("Carlos"));
            repo.save(new Alumno("Laura"));
        };
    }*/
}
