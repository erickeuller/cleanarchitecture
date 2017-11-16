package nosql.adapters;

import core.entities.User;
import nosql.entities.UserEntity;

public class UserEntityAdapter {

    public static UserEntity from(User user) {
        UserEntity entity = new UserEntity();
        entity.setCode(user.getCode());
        entity.setName(user.getName());
        return entity;
    }

    public static User to(UserEntity entity) {
        return new User()
                .setCode(entity.getCode())
                .setName(entity.getName());
    }
}
