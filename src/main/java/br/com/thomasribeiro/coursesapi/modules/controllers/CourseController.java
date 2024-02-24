package br.com.thomasribeiro.coursesapi.modules.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thomasribeiro.coursesapi.modules.entities.CourseEntity;
import br.com.thomasribeiro.coursesapi.modules.entities.constants.Active;
import br.com.thomasribeiro.coursesapi.modules.services.CourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("")
    public ResponseEntity<CourseEntity> insert(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            CourseEntity course = this.courseService.insert(courseEntity);
            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseEntity> update(
            @PathVariable(name = "id") UUID id,
            @Valid @RequestBody CourseEntity courseEntity) {

        CourseEntity updatedCourse = this.courseService.update(id, courseEntity);
        return ResponseEntity.ok().body(updatedCourse);
    }

    @GetMapping("")
    public ResponseEntity<List<CourseEntity>> getAll() {
        List<CourseEntity> courses = this.courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getById(@PathVariable(name = "id") UUID courseId) {
        try {
            CourseEntity result = this.courseService.getById(courseId);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseEntity> deleteById(@PathVariable(name = "id") UUID id) {
        this.courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<CourseEntity> patch(@PathVariable(name = "id") UUID id,
            @Valid @RequestBody CourseEntity courseEntity) {

        CourseEntity patchedCourse = this.courseService.patch(id, courseEntity);
        patchedCourse.setActive(Active.TRUE);

        return ResponseEntity.ok().body(patchedCourse);
    }

}
