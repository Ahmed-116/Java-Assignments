
public class TextMessage extends Sms {

    // Constructor for TextMessage, accepts content as String
    public TextMessage(String content) {
        super(content); // Pass the content (String) to the parent constructor, which will convert it to byte[]
    }

    @Override
    public String toString() {
        return super.toString(); // Use the base class's toString
    }
}
