package io.gabo.schoolbridgeapi.service;

import io.gabo.schoolbridgeapi.domain.EducationLevel;
import io.gabo.schoolbridgeapi.repository.EducationLevelRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationLevelService {

    private final EducationLevelRepository levelRepo;

    public EducationLevelService(EducationLevelRepository levelRepo) {
        this.levelRepo = levelRepo;
    }

    /** Return the next level in ascending order; throws if none exists. */
    public EducationLevel getNext(EducationLevel current) {
        return levelRepo
                .findFirstByLevelOrderGreaterThanOrderByLevelOrderAsc(current.getLevelOrder())
                .orElseThrow(() ->
                        new IllegalStateException("No next education level found after " + current.getLevelOrder()));
    }
}
