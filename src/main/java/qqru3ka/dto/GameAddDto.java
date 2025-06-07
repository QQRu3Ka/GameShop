package qqru3ka.dto;

import java.time.LocalDate;

public class GameAddDto {
    private String title;
    private Integer developerId;
    private Integer price;
    private String description;
    private LocalDate releaseDate;
    private String storageName;

    public GameAddDto() {
    }

    public GameAddDto(String title, Integer developerId, Integer price, String description,
                      LocalDate releaseDate, String storageName) {
        this.title = title;
        this.developerId = developerId;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
        this.storageName = storageName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
}
