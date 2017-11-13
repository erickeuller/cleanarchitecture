package rest.adapters;

import core.entities.User;
import rest.vo.UserVO;

public class UserVoAdapter {

    public static UserVO from(User user) {
        return new UserVO()
                .setCode(user.getCode())
                .setBirth(user.getBirth())
                .setName(user.getName());
    }

    public static User to(UserVO user) {
        return new User()
                .setCode(user.getCode())
                .setBirth(user.getBirth())
                .setName(user.getName());
    }

}
