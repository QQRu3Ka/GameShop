package qqru3ka.dto;

public class CommentDto {
    private Integer gameId;
    private Integer userId;
    private Integer rating;
    private String text;

    public CommentDto() {
    }

    public CommentDto(Integer gameId, Integer userId, Integer rating, String text) {
        this.gameId = gameId;
        this.userId = userId;
        this.rating = rating;
        this.text = text;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
