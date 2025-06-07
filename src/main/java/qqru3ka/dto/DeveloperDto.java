package qqru3ka.dto;

public class DeveloperDto {
    private Integer userId;
    private String name;
    private String email;
    private String description;

    public DeveloperDto() {
    }

    public DeveloperDto(Integer userId, String name, String email, String description) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
