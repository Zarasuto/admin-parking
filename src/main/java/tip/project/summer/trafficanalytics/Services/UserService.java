package tip.project.summer.trafficanalytics.Services;

import tip.project.summer.trafficanalytics.Models.User;

public interface UserService {
    public User loadByUsername(String username);
}
