package br.com.thomasribeiro.coursesapi.exceptions;

import java.util.UUID;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(UUID id) {
        super("Curso não encontrado com o id " + id);
    }
}
