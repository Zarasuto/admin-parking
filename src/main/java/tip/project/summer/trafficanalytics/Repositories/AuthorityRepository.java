package tip.project.summer.trafficanalytics.Repositories;

import tip.project.summer.trafficanalytics.Models.Authorities ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authorities,Long> {
}
