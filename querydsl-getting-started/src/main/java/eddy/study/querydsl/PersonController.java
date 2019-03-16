package eddy.study.querydsl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public List<Person> findAll(){
        return personDao.findAll();
    }

    @GetMapping("/{name}")
    public List<Person> findByName(@PathVariable(name = "name") String name){

        return personDao.findByName(name);
    }
}
