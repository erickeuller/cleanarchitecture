package core.usecases;

import core.boundaries.UserDAO;
import core.entities.User;

public class DeleteUser {

    private UserDAO dao;

    public DeleteUser(UserDAO dao) {
        this.dao = dao;
    }

    public void delete(User user) {
        dao.delete(user);
    }
}
