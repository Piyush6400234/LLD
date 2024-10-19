package structural.Flyweight.Fonts;
// Flyweight interface
//This interface defines a method for rendering the object (characters) by using both intrinsic (shared) and extrinsic
// (unique) states.

public interface CharacterFlyweight {
    void display(int posX, int posY); // Extrinsic states
}
