package ru.almyal.tacos.data;

import org.springframework.data.repository.CrudRepository;
import ru.almyal.tacos.TacoOrder;
import ru.almyal.tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User save (User user);
    User findByUsername(String username);
}
