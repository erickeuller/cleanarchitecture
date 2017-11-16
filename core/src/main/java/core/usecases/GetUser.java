package core.usecases;

import core.boundaries.UserDAO;
import core.entities.User;

import java.util.Collection;

public class GetUser {

    private UserDAO dao;

    public GetUser(UserDAO dao) {
        this.dao = dao;
    }

    public User byCode(String code) {
        return dao.findByCode(code);
    }

    public Collection<User> findAll() {
        return dao.findAll();
    }
}
