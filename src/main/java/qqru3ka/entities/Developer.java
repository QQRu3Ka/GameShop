package qqru3ka.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity(name = "Developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Integer developerId;
    @Column(name = "user_id")
    private Integer userId;
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotBlank
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "founded_date")
    private LocalDate foundedDate;
    @Min(0)
    private Integer revenue;
    private String website;
    @Column(name = "is_active")
    private Boolean isActive = true;

    public Developer() {
    }

    public Developer(Integer userId, String name, String email, LocalDate foundedDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.foundedDate = foundedDate;
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

    public @Min(0) Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(@Min(0) Integer revenue) {
        this.revenue = revenue;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
