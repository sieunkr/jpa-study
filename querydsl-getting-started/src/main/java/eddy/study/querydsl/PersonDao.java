package eddy.study.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//TODO:정상적으로 실행은 되지만... IDE 에서 빨간줄 표시되고, directory 에도 생성되지 않은 상황
//querydsl plugin 을 실행하면, 중복되었다는 오류 발생...
import static eddy.study.querydsl.QPerson.person;

@Component
public class PersonDao {

    private final JPAQueryFactory queryFactory;

    public PersonDao(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }
    
    public List<Person> findAll(){
        return queryFactory
                .selectFrom(person)
                .fetch();
    }

    public List<Person> findByName(String name){
        return queryFactory
                .selectFrom(person)
                .where(person.name.eq(name))
                .fetch();
    }

}
