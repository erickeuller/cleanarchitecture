package core.entities;

import java.time.LocalDate;

public class User {

    private String code;

    private String name;

    private LocalDate birth;

    public String getCode() {
        return code;
    }

    public User setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public User setBirth(LocalDate birth) {
        this.birth = birth;
        return this;
    }
}
