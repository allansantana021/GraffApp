package com.GraffAppBackend.GraffAppBackend.dto.request;

import java.util.Date;

public class PostDTORequest {

    private String postTexto;
    private Date postData;
    private String postTopico;
    private Integer postStatus;
    private Integer usuarioId;

    // Construtor padrão
    public PostDTORequest() {}

    // Construtor parametrizado
    public PostDTORequest(String postTexto, Date postData, String postTopico, Integer postStatus, Integer usuarioId) {
        this.postTexto = postTexto;
        this.postData = postData;
        this.postTopico = postTopico;
        this.postStatus = postStatus;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public String getPostTexto() {
        return postTexto;
    }

    public void setPostTexto(String postTexto) {
        this.postTexto = postTexto;
    }

    public Date getPostData() {
        return postData;
    }

    public void setPostData(Date postData) {
        this.postData = postData;
    }

    public String getPostTopico() {
        return postTopico;
    }

    public void setPostTopico(String postTopico) {
        this.postTopico = postTopico;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}