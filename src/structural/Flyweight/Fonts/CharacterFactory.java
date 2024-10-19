package structural.Flyweight.Fonts;
import java.util.HashMap;
import java.util.Map;

// Flyweight Factory: Creates and manages flyweight objects
//The factory is responsible for creating and managing flyweight objects. If an object with the same intrinsic state
// (symbol, font and color) already exists, it reuses it instead of creating a new one.

public class CharacterFactory {
    private Map<String, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char symbol, String font, String color){
        String key = symbol + "-" + font + "-" + color;
        // If a flyweight character with the same intrinsic state exists, return it
        if(!characters.containsKey(key)){
            characters.put(key, new Character(symbol, font, color));
            System.out.println("Creating new character with characteristics: " + symbol + " " + font + " " + color);
        }
        else{
            System.out.println("Reusing existing character");
        }
        return characters.get(key);
    }
}
