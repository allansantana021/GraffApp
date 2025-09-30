package com.GraffAppBackend.GraffAppBackend.dto.request;

import java.util.Date;

public class CurtidaDTORequest {

    private Integer usuarioId;
    private Integer grafiteId;
    private Date curtidaData;
    private Integer postId;


    public CurtidaDTORequest() {}


    public CurtidaDTORequest(Integer usuarioId, Integer grafiteId, Date curtidaData, Integer postId) {
        this.usuarioId = usuarioId;
        this.grafiteId = grafiteId;
        this.curtidaData = curtidaData;
        this.postId = postId;
    }


    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getGrafiteId() {
        return grafiteId;
    }

    public void setGrafiteId(Integer grafiteId) {
        this.grafiteId = grafiteId;
    }

    public Date getCurtidaData() {
        return curtidaData;
    }

    public void setCurtidaData(Date curtidaData) {
        this.curtidaData = curtidaData;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}