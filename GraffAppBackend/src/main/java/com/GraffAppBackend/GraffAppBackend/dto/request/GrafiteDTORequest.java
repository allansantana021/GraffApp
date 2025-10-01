package com.GraffAppBackend.GraffAppBackend.dto.request;

import java.math.BigDecimal;
import java.util.Date;

public class GrafiteDTORequest
 {

    private String grafiteTitulo;
    private String grafiteDescricao;
    private String grafiteImagem;
    private BigDecimal grafiteLatitude;
    private Date grafiteLongitude;
    private Integer postId;


    public GrafiteDTORequest() {}


    public GrafiteDTORequest(String grafiteTitulo, String grafiteDescricao, String grafiteImagem,
                             BigDecimal grafiteLatitude, Date grafiteLongitude, Integer postId) {
        this.grafiteTitulo = grafiteTitulo;
        this.grafiteDescricao = grafiteDescricao;
        this.grafiteImagem = grafiteImagem;
        this.grafiteLatitude = grafiteLatitude;
        this.grafiteLongitude = grafiteLongitude;
        this.postId = postId;
    }


    public String getGrafiteTitulo() {
        return grafiteTitulo;
    }

    public void setGrafiteTitulo(String grafiteTitulo) {
        this.grafiteTitulo = grafiteTitulo;
    }

    public String getGrafiteDescricao() {
        return grafiteDescricao;
    }

    public void setGrafiteDescricao(String grafiteDescricao) {
        this.grafiteDescricao = grafiteDescricao;
    }

    public String getGrafiteImagem() {
        return grafiteImagem;
    }

    public void setGrafiteImagem(String grafiteImagem) {
        this.grafiteImagem = grafiteImagem;
    }

    public BigDecimal getGrafiteLatitude() {
        return grafiteLatitude;
    }

    public void setGrafiteLatitude(BigDecimal grafiteLatitude) {
        this.grafiteLatitude = grafiteLatitude;
    }

    public Date getGrafiteLongitude() {
        return grafiteLongitude;
    }

    public void setGrafiteLongitude(Date grafiteLongitude) {
        this.grafiteLongitude = grafiteLongitude;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}