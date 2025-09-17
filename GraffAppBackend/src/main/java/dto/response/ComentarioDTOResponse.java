package dto.response;

import java.util.Date;

public class ComentarioDTOResponse {

    private int comentarioId;
    private String comentarioTexto;
    private Date comentarioDataPublicacao;
    private Integer usuarioId;
    private Integer postId;


    public ComentarioDTOResponse() {}


    public ComentarioDTOResponse(int comentarioId, String comentarioTexto, Date comentarioDataPublicacao, Integer usuarioId, Integer postId) {
        this.comentarioId = comentarioId;
        this.comentarioTexto = comentarioTexto;
        this.comentarioDataPublicacao = comentarioDataPublicacao;
        this.usuarioId = usuarioId;
        this.postId = postId;
    }

    // Getters e Setters
    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

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