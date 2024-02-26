package br.com.thomasribeiro.coursesapi.exceptions;

public class CourseExistsException extends RuntimeException {

    public CourseExistsException(String name) {
        super("O nome do curso " + name + " já existe");
    }
}
