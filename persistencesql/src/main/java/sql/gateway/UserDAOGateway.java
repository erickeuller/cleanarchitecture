package sql.gateway;

import core.boundaries.UserDAO;
import core.entities.User;
import sql.daos.UserEntityDAO;

import javax.ejb.EJB;

import static sql.adapters.UserEntityAdapter.from;
import static sql.adapters.UserEntityAdapter.to;

public class UserDAOGateway implements UserDAO {

    @EJB
    private UserEntityDAO dao;

    @Override
    public User createUser(User user) {
        return to(dao.create(from(user)));
    }

    @Override
    public User findByCode(String code) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
