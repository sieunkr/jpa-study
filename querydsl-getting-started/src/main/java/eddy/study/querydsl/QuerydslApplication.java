package eddy.study.querydsl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuerydslApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    public QuerydslApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        personRepository.save(new Person("eddy"));

    }
}
