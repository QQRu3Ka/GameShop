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
    private Integer game_id;
    @NotBlank
    private String title;
    private Double rating;
    private OffsetDateTime created_at = OffsetDateTime.now();
    @Column(nullable = false)
    private Integer developer_id;
    @Min(0)
    private Integer price;
    @Column(columnDefinition = "TEXT")
    private String description = "";
    private LocalDate release_date;
    private Boolean is_active = true;
    private Integer purchase_count = 0;
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

    public Game(String title, Integer developer_id, Integer price, String description, LocalDate release_date) {
        this.title = title;
        this.developer_id = developer_id;
        this.price = price;
        this.description = description;
        this.release_date = release_date;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
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

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public Integer getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Integer developer_id) {
        this.developer_id = developer_id;
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

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(Integer purchase_count) {
        this.purchase_count = purchase_count;
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
