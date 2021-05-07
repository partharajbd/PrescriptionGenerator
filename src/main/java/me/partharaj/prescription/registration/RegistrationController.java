package me.partharaj.prescription.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("auth/registration")
public class RegistrationController{

    RegistrationService registrationService;

    @GetMapping
    public String register(RegistrationRequest registrationRequest, Model model){
        return "auth/registrationForm";
    }

    @PostMapping
    public String create(@Valid RegistrationRequest registrationRequest, BindingResult result){

        if (result.hasErrors()) {
            return "auth/registrationForm";
        }

        registrationService.register(registrationRequest);

        return "redirect:/auth/registration/success";
    }

    @GetMapping("/success")
    public String registrationSucceed(){
        return "auth/registrationSucceed";
    }

}
