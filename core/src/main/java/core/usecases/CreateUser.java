package core.usecases;

import core.boundaries.UserDAO;
import core.entities.User;

public class CreateUser {

    private UserDAO dao;

    public CreateUser(UserDAO dao) {
        this.dao = dao;
    }

    public User create(User user) {
        return dao.createUser(user);
    }
}
