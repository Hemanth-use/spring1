package hero.controller.admin;

import hero.entity.admin.AnalyticsField;
import hero.service.admin.AnalyticsFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics-fields")
public class AnalyticsFieldController {

    @Autowired
    private AnalyticsFieldService analyticsFieldService;

    @GetMapping
    public List<AnalyticsField> getAllFields() {
        return analyticsFieldService.getAllAnalyticsFields();
    }



    @GetMapping("/{id}")
    public ResponseEntity<AnalyticsField> getFieldById(@PathVariable Long id) {
        AnalyticsField field = analyticsFieldService.getAnalyticsFieldById(id);
        return field != null ? ResponseEntity.ok(field) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AnalyticsField> createField(@RequestBody AnalyticsField field) {
        return ResponseEntity.ok(analyticsFieldService.createAnalyticsField(field));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalyticsField> updateField(@PathVariable Long id, @RequestBody AnalyticsField field) {
        AnalyticsField updatedField = analyticsFieldService.updateAnalyticsField(id, field);
        return updatedField != null ? ResponseEntity.ok(updatedField) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        analyticsFieldService.deleteAnalyticsField(id);
        return ResponseEntity.noContent().build();
    }
}

