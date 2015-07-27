package com.wolff.jackson.aula04_jacksonwolff;

/**
 * Created by professor on 13/07/2015.
 */
public class Produto {
    private String imageId;
    private String nome;
    private String descricao;
    private String codigo;

    public Produto(String imageId, String nome, String descricao, String codigo) {
        this.imageId = imageId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return descricao;
    }

    public void setDesc(String desc) {
        this.descricao = desc;
    }

    public String getTitle() {
        return nome;
    }

    public void setTitle(String title) {
        this.nome = title;
    }

    public String getCodito() {
        return codigo;
    }

    public void setCodigo(String title) {
        this.codigo = title;
    }

    @Override
    public String toString() {
        return nome + "\n" + descricao;
    }
}