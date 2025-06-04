package qqru3ka.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;
    @NotBlank
    private String title;
    private Double rating;
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name = "developer_id", nullable = false)
    private Integer developerId;
    @Min(0)
    private Integer price;
    @Column(columnDefinition = "TEXT")
    private String description = "";
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "is_active")
    private Boolean isActive = true;
    @Column(name = "purchase_count")
    private Integer purchaseCount = 0;
    private String version = "1.0.0";
    @OneToMany(mappedBy = "game")
    private List<UserLibrary> inLibraries = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    private List<UserWishlist> inWishlists = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    private List<UserCart> inCarts = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    private List<GameGenre> genres = new ArrayList<>();
    @OneToMany(mappedBy = "game")
    private List<Comment> comments = new ArrayList<>();


    public Game(){
    }

    public Game(String title, Integer developerId, Integer price, String description, LocalDate releaseDate) {
        this.title = title;
        this.developerId = developerId;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<UserLibrary> getInLibraries() {
        return inLibraries;
    }

    public void setInLibraries(List<UserLibrary> inLibraries) {
        this.inLibraries = inLibraries;
    }

    public List<UserWishlist> getInWishlists() {
        return inWishlists;
    }

    public void setInWishlists(List<UserWishlist> inWishlists) {
        this.inWishlists = inWishlists;
    }

    public List<UserCart> getInCarts() {
        return inCarts;
    }

    public void setInCarts(List<UserCart> inCarts) {
        this.inCarts = inCarts;
    }

    public List<GameGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<GameGenre> genres) {
        this.genres = genres;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
