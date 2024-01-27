package ru.almyal.tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import ru.almyal.tacos.Taco;

@EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco order);
    Iterable<Taco> findAll(Pageable page);

}
