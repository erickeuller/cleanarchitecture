package nosql.dao.impl;

import com.mongodb.MongoClient;
import nosql.dao.UserEntityDAO;
import nosql.entities.UserEntity;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Collection;

public class UserEntityDAOImpl implements UserEntityDAO {

    private Datastore datastore;

    public UserEntityDAOImpl() {
        Morphia morphia = new Morphia();
        MongoClient mongoClient = new MongoClient(UserEntityDAO.HOST, UserEntityDAO.PORT);
        morphia.mapPackage(UserEntity.class.getPackage().getName());
        datastore = morphia.createDatastore(mongoClient, UserEntityDAO.DATABASE);
        datastore.ensureIndexes();
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        datastore.save(user);
        return user;
    }

    @Override
    public UserEntity findByCode(String code) {
        return datastore.createQuery(UserEntity.class).field("code").equal(code).get();
    }

    @Override
    public UserEntity update(UserEntity user) {
        UserEntity foundUser = findByCode(user.getCode());
        user.setId(foundUser.getId());
        datastore.save(user);
        return user;
    }

    @Override
    public Collection<UserEntity> findAll() {
        return datastore.createQuery(UserEntity.class).asList();
    }

    @Override
    public void delete(UserEntity user) {
        user = findByCode(user.getCode());
        datastore.delete(user);
    }
}
