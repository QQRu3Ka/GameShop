package qqru3ka.dto;

public class GameStatusDto {
    private Integer gameId;
    private Boolean status;

    public GameStatusDto() {
    }

    public GameStatusDto(Integer gameId, Boolean status) {
        this.gameId = gameId;
        this.status = status;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
