package pl.splon.blog.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterForm {
    private String login;
    private String password;
    private String passwordRepeat;
    private int age;
}
