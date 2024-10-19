package creational.builder.cars;

public interface Builder {
    public void buildEngine();
    public void buildBody();
    public void buildWheels();
    public void buildInterior();
}