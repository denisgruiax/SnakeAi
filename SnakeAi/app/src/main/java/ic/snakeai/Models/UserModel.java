package ic.snakeai.Models;

public class UserModel {
    private String username;
    private String password;
    private Integer maxScore;

    public UserModel(){
    }

    public UserModel(String username, String password, Integer maxScore){
        this.username=username;
        this.password=password;
        this.maxScore=maxScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) { this.maxScore = maxScore; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel user = (UserModel) o;
        return (username.equals(user.username) &&
                password.equals(user.password) && maxScore==user.maxScore);
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }
}
