package pl.splon.blog.models.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.splon.blog.models.UserModel;
import pl.splon.blog.models.UserType;
import pl.splon.blog.models.Utils;
import pl.splon.blog.models.forms.RegisterForm;
import pl.splon.blog.models.repositories.UserRepository;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {
    public enum RegisterStatus {
        OK, BUSY_LOGIN, ERROR;
    }

    final
    UserRepository userRepository;

    @Getter @Setter
    private boolean isLogin;
    @Getter @Setter
    private int badLoginCounter;
    @Getter @Setter
    private UserModel user;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public RegisterStatus register(RegisterForm registerForm){
        if(userRepository.existsByLogin(registerForm.getLogin())){
            return RegisterStatus.BUSY_LOGIN;
        }

        registerForm.setPassword(Utils.hash256SHA(registerForm.getPassword()));

        UserModel newUserModel = new UserModel(registerForm);
        newUserModel.setUserType(UserType.USER);

        userRepository.save(newUserModel);
        return RegisterStatus.OK;
    }


}
