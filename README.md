#### 영속 컨텍스트

영속 컨텍스트는 세션(JPA 의 EntityManager) 단위로 생긴다. 즉, 세션 생성 시점에 영속 컨텍스트가 생성되고 세션 종료 시점에 컨텍스트가 사라진다. 응용 프로그램은 영속 컨텍스트에 직접 접근할 수 없다. 대신 EntityManager를 통해서 영속 ㅋ턴텍스트와 관련된 작업을 수행한다. [참고 - 최범균 님의 JPA]

#### 스프링 부트 에서의 JPA

스프링 부트 에서는 persistence.xml 같은 설정이 필요 없다. 단지, JPA 를 위한 프로퍼티 설정만 추가하면 된다. 

spring.jpa.생략

#### EntityManager

EntityManager 를 사용하기 위해서는 

```java
@PersistenceContext
    private EntityManager em;
```

만 정의해주고 사용하면 된다. 예를 들어서, 

```java
entityManager.find(User.class, email);
```


```java
TypedQuery<User> query =  
  entityManager.createQuery(  
  "select u from User u order by u.name",  
  User.class);  
List<User> result = query.getResultList();
```


**entityManager** 주요 메서드

- find
- merge
- remove
- 등등...

#### 트랜잭션

@Transactional 을 선언하면 된다. 단, 스프링은 Unchecked Exception을 rollback 대상으로 지정한다. RuntimeException을 상속한 예외를 Unchecked Exception이라 한다.
Checked Exception 발생 시 롤백을 원한다면 다음과 같이 rollbackOn 옵션에 Exception.class 추가하면 된다. 

#### jpql
JPA 는 SQL 과 유사한 JPQL 을 제공한다.
```java
TypedQuery<User> query =  
  entityManager.createQuery(  
  "select u from User u order by u.name",  
  User.class);
```

#### @Entity 

@Table 어노테이션을 사용하면 테이블 이름으로 직접 지정할 수 있다. 

@Id
Entity 의 가장 큰 특징은 식별자를 가진다. @ID 어노테이션을 사용한다. @Id 어노테이션을 적용한 필드 값은 EntityManager#find() 메서드에서 엔티티 객체를 찾을 때 식별자로 사용한다. 

@Basic 
생략 가능, int, long, string 과 같은 기본 타입일 때 매핑

@Temporal 
날짜와 시간, DATE, TIME, TIMESTAMP 등
하이버네이트 5.2 이상부터는 LocalhostDateTime 지원

@Enumerated 
열거 타입에 대한 매핑

@Column
필드 이름과 테이블의 컬럼 이름이 다를 경우


매핑을 필드가 아니라, getter 에 주고 싶다면?
@Column 어노테이션을 필드가 아니라, getter, setter 에 붙여주면 된다. 프로퍼티 접근 타입을 사용하면 객체 지향 관점에서 공개 get/set 메서드는 캡슐화를 약화 시키는 원인이 된다. 물론, get/set 메서드를 protected 나 private 로 범위를 제한할 수 있지만, 프로퍼티 접근 타입보다 필드 접근 타입을 선호한다. [최범균님  JPA 참고]


읽을만한 글

[https://medium.com/@geminikim/%EA%B0%9C%EC%9D%B8%EC%B7%A8%ED%96%A5-jpa-%EC%82%AC%EC%9A%A9%EA%B8%B0-2%ED%8E%B8-entity-with-getter-setter-and-test-a0305af69090](https://medium.com/@geminikim/%EA%B0%9C%EC%9D%B8%EC%B7%A8%ED%96%A5-jpa-%EC%82%AC%EC%9A%A9%EA%B8%B0-2%ED%8E%B8-entity-with-getter-setter-and-test-a0305af69090)

@Taransient
Transient
필드, 영속 대상에서 제외

#### 엔티티 클래스의 제약 조건

- 기본 생성자를 제공해야 한다. 
- 기본 생성자의 접근 범위는 public 또는 protected 이어야 한다. private 일 경우 JPA 의 특징이 올바로 동작하지 않는다. 

# EntityManager 기본 기능


#### find()

```java
public <T> T find(Class<T> entityClass, Object primaryKey);
```
#### getReference()

find 와 유사하지만, 데이터가 존재하지 않는 경우 EntityNotFoundExceptino 을 발생시킴

#### persist() 

새로운 Entity 를 DB 에 저장

MySQL 의 auto_increment 칼럼을 사용하기 위해서는, @GeneratedValue(st... 어노테이션을 사용하면 매핑이 된다. 

@GeneratedValue(strategy = GenerationType.IDENTITY)

#### remove()

트랜잭션 커밋 시점에 실제 삭제를 위한 delete 쿼리를 실행한다. 



# SimpleJpaRepository

따로 확인해보자. 

EntityManager 를 사용하고, 각 메서드는 @Transactional 이 걸려있음. 즉, 이 의미는 이미 트랜잭션이 중이라면 참여하고 트랜잭션이 없다면 트랜잭션을 새로 시작하라는 의미

읽어보자. 
[https://www.popit.kr/jpa-%EB%B3%80%EA%B2%BD-%EA%B0%90%EC%A7%80%EC%99%80-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0/](https://www.popit.kr/jpa-%EB%B3%80%EA%B2%BD-%EA%B0%90%EC%A7%80%EC%99%80-%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8D%B0%EC%9D%B4%ED%84%B0/)

[https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/](https://suhwan.dev/2019/02/24/jpa-vs-hibernate-vs-spring-data-jpa/)



# EntityManager, 영속 컨텍스트, 트랜잭션, 라이프사이클

최범균님 책 5장,6장 다시 보자. 중요




# 1:1 연관매핑

일단, MyISAM과 InnoDB에서 인덱스 생성 관련하여 구동방식이 다름.. 주의

테스트는 InnoDB 로 셋팅해서 진행

```
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```



