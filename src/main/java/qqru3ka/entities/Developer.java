package qqru3ka.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity(name = "Developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer developer_id;
    private Integer user_id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotBlank
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDate founded_date;
    @Min(0)
    private Integer revenue;
    private String website;
    private Boolean is_active = true;

    public Developer() {
    }

    public Developer(Integer userId, String name, String email, LocalDate foundedDate) {
        this.user_id = userId;
        this.name = name;
        this.email = email;
        this.founded_date = foundedDate;
    }

    public Integer getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Integer developer_id) {
        this.developer_id = developer_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public LocalDate getFounded_date() {
        return founded_date;
    }

    public void setFounded_date(LocalDate founded_date) {
        this.founded_date = founded_date;
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

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }
}
