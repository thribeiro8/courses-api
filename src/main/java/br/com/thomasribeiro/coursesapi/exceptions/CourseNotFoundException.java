package br.com.thomasribeiro.coursesapi.exceptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super("Curso não encontrado");
    }
}
