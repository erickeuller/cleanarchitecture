package core.usecases;

import core.boundaries.UserDAO;
import core.entities.User;

public class UpdateUser {

    private UserDAO dao;

    public UpdateUser(UserDAO dao) {
        this.dao = dao;
    }

    public User update(User user) {
        return dao.update(user);
    }
}
