package hero.repository.admin;

import hero.entity.admin.AnalyticsField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsFieldRepository extends JpaRepository<AnalyticsField, Long> {

}

