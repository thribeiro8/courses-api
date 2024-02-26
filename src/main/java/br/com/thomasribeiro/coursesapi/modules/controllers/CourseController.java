package br.com.thomasribeiro.coursesapi.modules.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.thomasribeiro.coursesapi.modules.entities.CourseEntity;
import br.com.thomasribeiro.coursesapi.modules.services.CourseService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("")
    public CourseEntity insert(@Valid @RequestBody CourseEntity courseEntity) {
        return this.courseService.insert(courseEntity);
    }

    @PutMapping("/{id}")
    public CourseEntity update(
            @PathVariable(name = "id") UUID id,
            @Valid @RequestBody CourseEntity courseEntity) {

        return this.courseService.update(id, courseEntity);
    }

    @GetMapping("")
    public List<CourseEntity> getAll() {
        return this.courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseEntity getById(@PathVariable(name = "id") UUID id) {
        return this.courseService.getById(id);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        this.courseService.deleteById(id);
    }

    @PatchMapping("/{id}/active")
    public CourseEntity patch(@PathVariable(name = "id") UUID id,
            @RequestBody CourseEntity courseEntity) {

        return this.courseService.patch(id, courseEntity);
    }

}
