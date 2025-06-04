package qqru3ka.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String email;
    private String login;
    private String nickname;
    @Column(name = "password_hash")
    private String passwordHash;
    private String role = "user";
    @Column(name = "created_at")
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private Integer balance = 0;
    private String info = "";
    @OneToMany(mappedBy = "user")
    private List<UserLibrary> library = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserWishlist> wishlist = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserCart> cart = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public User() {
    }

    public User(String email, String login, String nickname, String passwordHash) {
        this.email = email;
        this.login = login;
        this.nickname = nickname;
        this.passwordHash = passwordHash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<UserLibrary> getLibrary() {
        return library;
    }

    public void setLibrary(List<UserLibrary> library) {
        this.library = library;
    }

    public List<UserWishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<UserWishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public List<UserCart> getCart() {
        return cart;
    }

    public void setCart(List<UserCart> cart) {
        this.cart = cart;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
