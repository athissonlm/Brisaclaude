package com.example.brisa.services;

import com.example.brisa.exceptions.ResourceNotFoundException;
import com.example.brisa.models.course.CourseModel;
import com.example.brisa.models.course.CourseProgressionModel;
import com.example.brisa.repositories.CourseProgressionRepository;
import com.example.brisa.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseProgressionRepository courseProgressionRepository;

    public List<CourseModel> findAll() {
        return courseRepository.findAll();
    }

    public CourseModel findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + id));
    }

    public List<CourseProgressionModel> findProgressionsByClassId(Long classId) {
        return courseProgressionRepository.findByClassId(classId);
    }

    public List<CourseProgressionModel> findProgressionsByCourseId(Long courseId) {
        return courseProgressionRepository.findByCourseId(courseId);
    }
}