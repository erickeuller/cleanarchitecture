package sql.adapters;

import core.entities.User;
import sql.entities.UserEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UserEntityAdapter {

     public static UserEntity from(User user) {
        UserEntity entity = new UserEntity();
        entity.setCode(user.getCode());
        entity.setBirth(Date.from(user.getBirth().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        entity.setName(user.getName());
        return entity;
    }

    public static User to(UserEntity entity) {
        return new User()
                .setBirth(LocalDate.from(entity.getBirth().toInstant()))
                .setCode(entity.getCode())
                .setName(entity.getName());
    }
}
