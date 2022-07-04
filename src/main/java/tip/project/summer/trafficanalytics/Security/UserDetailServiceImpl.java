package tip.project.summer.trafficanalytics.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tip.project.summer.trafficanalytics.Services.UserServiceImpl;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.loadByUsername(username);
    }
}
