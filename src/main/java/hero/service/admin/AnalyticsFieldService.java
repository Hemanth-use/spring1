package hero.service.admin;

import hero.entity.admin.AnalyticsField;

import java.util.List;

public interface AnalyticsFieldService {
    List<AnalyticsField> getAllAnalyticsFields();
    AnalyticsField getAnalyticsFieldById(Long id);
    AnalyticsField createAnalyticsField(AnalyticsField analyticsField);
    AnalyticsField updateAnalyticsField(Long id, AnalyticsField analyticsField);
    void deleteAnalyticsField(Long id);

}

