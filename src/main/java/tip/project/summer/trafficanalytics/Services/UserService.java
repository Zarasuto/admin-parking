package tip.project.summer.trafficanalytics.Services;

import tip.project.summer.trafficanalytics.Models.User;

public interface UserService {

    void saveUserToDatabase(User user);
    User loadByUsername(String username);
}
