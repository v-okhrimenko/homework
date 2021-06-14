package ua.ithillel.task4;

public class UserOfSite {
    private int userId;
    private String name;
    private int lessons;
    private long startPosition;

    public UserOfSite(int id, String name, int lessons, long startPosition) {
        this.userId = id;
        this.name = name;
        this.lessons = lessons;
        this.startPosition = startPosition;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public long getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(long startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public String toString() {
        return name + ":" + lessons;
    }
}
