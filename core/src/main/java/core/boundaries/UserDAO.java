package core.boundaries;

import core.entities.User;

import java.util.Collection;

public interface UserDAO {

    User createUser(User user);

    User findByCode(String code);

    Collection<User> findAll();

    User update(User user);

    void delete(User user);
}
