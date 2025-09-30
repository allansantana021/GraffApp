package com.GraffAppBackend.GraffAppBackend.dto.request;

import java.util.Date;

public class ComentarioDTORequest {

    private String comentarioTexto;
    private Date comentarioDataPublicacao;
    private Integer usuarioId;
    private Integer postId;

    
    public ComentarioDTORequest() {}

    
    public ComentarioDTORequest(String comentarioTexto, Date comentarioDataPublicacao, Integer usuarioId, Integer postId) {
        this.comentarioTexto = comentarioTexto;
        this.comentarioDataPublicacao = comentarioDataPublicacao;
        this.usuarioId = usuarioId;
        this.postId = postId;
    }

    // Getters e Setters
    public String getComentarioTexto() {
        return comentarioTexto;
    }

    public void setComentarioTexto(String comentarioTexto) {
        this.comentarioTexto = comentarioTexto;
    }

    public Date getComentarioDataPublicacao() {
        return comentarioDataPublicacao;
    }

    public void setComentarioDataPublicacao(Date comentarioDataPublicacao) {
        this.comentarioDataPublicacao = comentarioDataPublicacao;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}