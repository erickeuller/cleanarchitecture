package rest.vo;

import java.time.LocalDate;

public class UserVO {

    private String code;

    private LocalDate birth;

    private String name;

    public String getCode() {
        return code;
    }

    public UserVO setCode(String code) {
        this.code = code;
        return this;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public UserVO setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserVO setName(String name) {
        this.name = name;
        return this;
    }
}
