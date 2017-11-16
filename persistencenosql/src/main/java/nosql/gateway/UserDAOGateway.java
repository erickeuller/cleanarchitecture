package nosql.gateway;

import core.boundaries.UserDAO;
import core.entities.User;
import nosql.adapters.UserEntityAdapter;
import nosql.dao.UserEntityDAO;
import nosql.dao.impl.UserEntityDAOImpl;

import java.util.Collection;
import java.util.stream.Collectors;

import static nosql.adapters.UserEntityAdapter.from;
import static nosql.adapters.UserEntityAdapter.to;

public class UserDAOGateway implements UserDAO {

    private UserEntityDAO dao = new UserEntityDAOImpl();

    public User createUser(User user) {
        return to(dao.createUser(from(user)));
    }

    public User findByCode(String code) {
        return to(dao.findByCode(code));
    }

    @Override
    public Collection<User> findAll() {
        return dao.findAll().stream().map(UserEntityAdapter::to).collect(Collectors.toList());
    }

    public User update(User user) {
        return to(dao.update(from(user)));
    }

    public void delete(User user) {
        dao.delete(from(user));
    }
}
