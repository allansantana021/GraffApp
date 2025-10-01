package com.GraffAppBackend.GraffAppBackend.dto.response;

import java.util.Date;

public class PostDTOResponse {

    private int postId;
    private String postTexto;
    private Date postData;
    private String postTopico;
    private Integer postStatus;
    private Integer usuarioId;

    // Construtor padrão
    public PostDTOResponse() {}

    // Construtor parametrizado
    public PostDTOResponse(int postId, String postTexto, Date postData, String postTopico, Integer postStatus, Integer usuarioId) {
        this.postId = postId;
        this.postTexto = postTexto;
        this.postData = postData;
        this.postTopico = postTopico;
        this.postStatus = postStatus;
        this.usuarioId = usuarioId;
    }

    // Getters e Setters
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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