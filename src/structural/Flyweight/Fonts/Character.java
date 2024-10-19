package structural.Flyweight.Fonts;
//Concrete Flyweight: Stores intrinsic state (character, font, color)

public class Character implements CharacterFlyweight{
    //    All the intrinsic variables should not be allowed to change.
    private final char symbol; // Intrinsic state
    private final String font; // Intrinsic state
    private final String color; // Intrinsic state
    public Character(char symbol, String font, String color){
        this.symbol = symbol;
        this.font = font;
        this.color = color;
    }

    @Override
    public void display(int posX, int posY){
        // The extrinsic state (position) is passed in by the client
        System.out.println("Displaying character: " + this.symbol + " in font " + this.font + " and color " +
                this.color +" at position X: " + posX + " Y: " + posY);
    }
}
