package core.boundaries;

import core.entities.User;

public interface UserDAO {

    User createUser(User user);

    User findByCode(String code);

    User update(User user);

    void delete(User user);
}
