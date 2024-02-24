package br.com.thomasribeiro.coursesapi.modules.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import br.com.thomasribeiro.coursesapi.modules.entities.constants.Active;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Nome de curso precisa estar preenchido")
    @Length(min = 4, max = 50, message = "O nome do curso deve conter entre 4 e 50 caracteres")
    private String name;

    @NotBlank(message = "Nome de categoria precisa estar preenchida")
    @Length(min = 5, max = 50, message = "A categoria do curso deve conter entre 5 e 50 caracteres")
    private String category;

    @Enumerated(EnumType.STRING)
    private Active active;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
