package tip.project.summer.trafficanalytics.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tip.project.summer.trafficanalytics.Models.Authorities;
import tip.project.summer.trafficanalytics.Models.User;
import tip.project.summer.trafficanalytics.Repositories.AuthorityRepository;
import tip.project.summer.trafficanalytics.Repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void saveUserToDatabase(User user) {
        userRepository.save(user);
        authorityRepository.save(new Authorities("SITE_USER",user));
    }

    @Override
    public User loadByUsername(String username) {
        User user = userRepository.findOneByEmailAndEnabledTrue(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
