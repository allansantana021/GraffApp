package dto.response;

import java.util.Date;

public class CurtidaDTOResponse
 {

    private int curtidaId;
    private Integer usuarioId;
    private Integer grafiteId;
    private Date curtidaData;
    private Integer postId;


    public CurtidaDTOResponse() {}


    public CurtidaDTOResponse(int curtidaId, Integer usuarioId, Integer grafiteId, Date curtidaData, Integer postId) {
        this.curtidaId = curtidaId;
        this.usuarioId = usuarioId;
        this.grafiteId = grafiteId;
        this.curtidaData = curtidaData;
        this.postId = postId;
    }


    public int getCurtidaId() {
        return curtidaId;
    }

    public void setCurtidaId(int curtidaId) {
        this.curtidaId = curtidaId;
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