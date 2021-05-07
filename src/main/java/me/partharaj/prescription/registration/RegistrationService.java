package me.partharaj.prescription.registration;

import lombok.AllArgsConstructor;
import me.partharaj.prescription.user.User;
import me.partharaj.prescription.user.UserRole;
import me.partharaj.prescription.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public void register(RegistrationRequest request) {

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalStateException("Confirm password should match the password field");
        }

        userService.signUp(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
        ));
    }
}
