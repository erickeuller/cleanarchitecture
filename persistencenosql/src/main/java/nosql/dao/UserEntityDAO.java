package nosql.dao;

import nosql.entities.UserEntity;

import java.util.Collection;

public interface UserEntityDAO {

    String DATABASE = "cleanarc";
    String HOST = "localhost";
    int PORT = 27017;

    UserEntity createUser(UserEntity user);

    UserEntity findByCode(String code);

    UserEntity update(UserEntity user);

    Collection<UserEntity> findAll();

    void delete(UserEntity user);
}
