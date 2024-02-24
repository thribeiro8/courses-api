package br.com.thomasribeiro.coursesapi.exceptions;

public class CourseExistsException extends RuntimeException {

    public CourseExistsException() {
        super("Nome de curso já existe");
    }
}
