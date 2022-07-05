package tip.project.summer.trafficanalytics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tip.project.summer.trafficanalytics.Models.User;
import tip.project.summer.trafficanalytics.Security.CurrentAuthenticated;
import tip.project.summer.trafficanalytics.Security.PasswordConfig;
import tip.project.summer.trafficanalytics.Services.UserServiceImpl;
import tip.project.summer.trafficanalytics.Validators.PasswordMatch;

import javax.validation.Valid;

@Controller
public class RegisterLoginController {

    @Autowired
    private CurrentAuthenticated currentAuthenticated;

    @Autowired
    private PasswordMatch passwordMatch;

    @Autowired
    private PasswordConfig PasswordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String redirectToRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) throws InterruptedException {
        passwordMatch.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        model.addAttribute("user",user);
        model.addAttribute("SuccessMessage","Registration Complete!");
        user.setPassword(PasswordEncoder.passwordEncoder().encode(user.getPlainpassword()));
        userService.saveUserToDatabase(user);
        Thread.sleep(1000);
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        if(currentAuthenticated.getAuthentication()==null){
            return "login";
        }
        return "redirect:/";
    }

    @InitBinder    /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
