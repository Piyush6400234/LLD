package structural.Flyweight.Fonts;
/*
FLYWEIGHT PATTERN
    ------- Also know as Cache
Intrinsic data -> Among different objects there are some data(usually variables) that do not change among them, or
                  they remain same in all the objects, they are called Intrinsic state.
Extrinsic data -> Rest of the state (variables) that usually changes/varies among different objects are called
                  Extrinsic objects.
Example:: There's a game u'r developing, and we've got a huge quantity of bullets, missiles, and shrapnel.
          Each of these objects are having states like color, sprite(representational image), Coordinates, vector and speed.
But we noticed that we want to keep a constant color and sprite for all bullets, similarly another constant color and
sprite for all missiles and so on.
But each bullet's coordinates, vector and speed will be different, similarly for missiles and shrapnel

That's why:
color and sprite are INTRINSIC state.
Coordinates, speed and vector are EXTRINSIC state.
Instead of repeatedly using same values for color and sprite for all bullets we make objects containing a particular
set of color and sprite and reuse them as much as possible.

Make sure that there should be no any endpoint to change the intrinsic states in flyweight implementation classes.
(In Java we can use final keyword)
We never store Extrinsic states in Flyweight object (Only intrinsic states to be stored)
============================================= :COMPONENTS: =========================================
1). FLYWEIGHT INTERFACE: Defines common behavior that will be shared by all flyweight objects.
2). CONCRETE FLYWEIGHT: Implements the Flyweight interface and stores intrinsic state that is shared among objects.
3). FLYWEIGHT FACTORY: Responsible for creating and managing flyweight objects. It ensures that shared objects are reused when possible.
4). CLIENT: The client interacts with the flyweight objects and provides extrinsic data that is unique to each object.


============================================ PROBLEM STATEMENT =====================================
Consider an application that displays text with different fonts, colors, and sizes. Instead of creating a new object
for each character with its font and color properties, we can reuse the same objects for characters that share the
same properties (font, size, color). Only unique data, like the character position, will be stored separately.
====================================================================================================


 */
public class Main {
    public static void main(String[] args) {
        CharacterFactory charc = new CharacterFactory();
        CharacterFlyweight ch1 = charc.getCharacter('c', "font1", "color1");
        CharacterFlyweight ch2 = charc.getCharacter('d', "font2", "color2");
        CharacterFlyweight ch3 = charc.getCharacter('c', "font1", "color1");

        ch1.display(3, 4);


    }
}
/*

============================================ OTHER USE-CASES =======================================
1). Text Editors: Text editors like Microsoft Word or Google Docs may have many characters with the same font and style.
    Instead of creating a separate object for each character, a flyweight can be used to share common formatting
    information among many characters.
2). Game Development: In games where you have many objects (like trees, characters, or obstacles) that share common
    data (like textures, colors, or behaviors), the flyweight pattern can help reduce memory consumption by sharing
    common data among these objects.
3). GUI Applications: In GUI frameworks, many visual elements (buttons, labels, etc.) share similar properties. Instead
    of duplicating properties across multiple elements, the flyweight pattern can store shared properties (like font,
    color, or size) once and reuse them.
4). Document Management Systems: A document management system can have many documents, but all with the same metadata
    (author, creation date, etc.). A flyweight can share the metadata across documents to save memory.

===================================== :WHY USE THE FLYWEIGHT PATTERN: ================================
1). Optimizes Memory Usage: The primary goal of the Flyweight Pattern is to reduce memory consumption by reusing
    objects that share the same intrinsic properties. This is particularly useful in systems where a large number of
    similar objects are created.

2). Performance: By reducing the number of objects in memory, the flyweight pattern can improve performance, especially
    in systems with limited resources.

3). Avoids Object Duplication: Without the flyweight pattern, objects with similar or identical properties would be
    duplicated, leading to increased memory usage. The flyweight pattern solves this by ensuring that shared properties
    are only stored once and reused.

=================================== :PROBLEMS THE FLYWEIGHT PATTERN SOLVES: ===========================
1). Memory Bloat: In scenarios where many objects are created with shared data, memory can become a bottleneck. The
    flyweight pattern reduces this memory bloat by sharing intrinsic properties among objects.

2). Object Duplication: Without the flyweight pattern, each object might have its own copy of the data, even if it is
    the same across many objects. This leads to unnecessary duplication of data and memory usage. The flyweight pattern
    consolidates shared data.

3). Performance Overhead: Constant creation of new objects with similar data can slow down an application. By reusing
    existing objects, the flyweight pattern improves performance.







 */