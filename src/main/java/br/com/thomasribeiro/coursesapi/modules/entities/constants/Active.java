package br.com.thomasribeiro.coursesapi.modules.entities.constants;

import lombok.Getter;

@Getter
public enum Active {
    ACTIVE("active"),
    INACTIVE("inactive");

    private String descricao;

    Active(String descricao) {
        this.descricao = descricao;
    }
}
