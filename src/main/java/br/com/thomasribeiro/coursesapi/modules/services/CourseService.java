package br.com.thomasribeiro.coursesapi.modules.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thomasribeiro.coursesapi.exceptions.CourseExistsException;
import br.com.thomasribeiro.coursesapi.exceptions.CourseNotFoundException;
import br.com.thomasribeiro.coursesapi.modules.entities.CourseEntity;
import br.com.thomasribeiro.coursesapi.modules.entities.constants.Active;
import br.com.thomasribeiro.coursesapi.modules.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity insert(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                .ifPresent((name) -> {
                    throw new CourseExistsException();
                });

        courseEntity.setActive(Active.FALSE);

        return this.courseRepository.save(courseEntity);
    }

    @SuppressWarnings("null")
    public CourseEntity update(UUID id, CourseEntity courseEntity) {
        CourseEntity course = getById(id);

        if (!courseEntity.getName().isEmpty())
            course.setName(courseEntity.getName());
        if (!courseEntity.getCategory().isEmpty())
            course.setCategory(courseEntity.getCategory());
        if (!(courseEntity.getUpdatedAt() == null))
            course.setUpdatedAt(courseEntity.getUpdatedAt());

        return this.courseRepository.save(course);
    }

    public List<CourseEntity> getAll() {
        return this.courseRepository.findAll();
    }

    @SuppressWarnings("null")
    public CourseEntity getById(UUID id) {
        CourseEntity course = this.courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);

        return course;
    }

    @SuppressWarnings("null")
    public void deleteById(UUID id) {
        CourseEntity course = getById(id);
        this.courseRepository.delete(course);
    }

    public CourseEntity patch(UUID id, CourseEntity courseEntity) {
        CourseEntity course = getById(id);

        course.setActive(Active.TRUE);

        if (!courseEntity.getName().isEmpty())
            course.setName(courseEntity.getName());
        if (!courseEntity.getCategory().isEmpty())
            course.setCategory(courseEntity.getCategory());
        if (!(courseEntity.getUpdatedAt() == null))
            course.setUpdatedAt(courseEntity.getUpdatedAt());

        return course;
    }

}
