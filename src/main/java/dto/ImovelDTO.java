package dto;

import model.Imovel;
import org.springframework.beans.BeanUtils;

public class ImovelDTO {

    private Long id;
    private String descricao;
    private String endereco;

    public ImovelDTO(Imovel imovel) {
        BeanUtils.copyProperties(imovel, this);
    }

    public ImovelDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
