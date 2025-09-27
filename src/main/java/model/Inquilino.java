package model;

import dto.InquilinoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "inquilinos")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    public Inquilino(InquilinoDTO inquilinoDTO) {
        BeanUtils.copyProperties(inquilinoDTO, this);
    }

    public Inquilino() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // equals/hashCode otimizados
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino inquilino = (Inquilino) o;
        return Objects.equals(id, inquilino.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}