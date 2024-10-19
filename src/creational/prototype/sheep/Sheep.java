package creational.prototype.sheep;

public interface Sheep {
    String getName();
    void setName(String name);
    Sheep clone();
}
