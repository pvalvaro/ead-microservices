package com.ead.course.services;

import com.ead.course.dtos.ModuleRecordDto;
import com.ead.course.models.CourseModel;
import com.ead.course.models.ModuleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface ModuleService {
    void delete(ModuleModel moduleModel);

    boolean existsTitle(String title);

    ModuleModel save(ModuleRecordDto moduleRecordDto, CourseModel courseModel);

    List<ModuleModel> findAll();

    ModuleModel findById(UUID moduleId);

    ModuleModel update(ModuleRecordDto moduleRecordDto, ModuleModel moduleModel);

    List<ModuleModel> findAllModulesIntoCourse(UUID courseId);

    ModuleModel findModuleIntoCourse(UUID courseId, UUID moduleId);

    Page findAllModulesIntoCourse(Specification<ModuleModel> spec, Pageable pageable);
}
