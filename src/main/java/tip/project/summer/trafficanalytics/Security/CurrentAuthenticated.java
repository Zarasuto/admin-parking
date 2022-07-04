package tip.project.summer.trafficanalytics.Security;

import tip.project.summer.trafficanalytics.Models.User ;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentAuthenticated {

    public Authentication getAuthentication(){
        if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken){
            return null;
        }
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getLoggedInName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User getUserDetails(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
