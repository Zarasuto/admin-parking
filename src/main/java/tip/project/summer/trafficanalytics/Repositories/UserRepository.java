package tip.project.summer.trafficanalytics.Repositories;

import tip.project.summer.trafficanalytics.Models.User ;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    public User findOneByEmailAndEnabledTrue(String username);

    public long countByEmail(String email);
}
