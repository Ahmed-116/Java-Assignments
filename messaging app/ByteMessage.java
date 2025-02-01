

public class ByteMessage extends Sms {

    // Constructor for ByteMessage, accepts content as byte array
    public ByteMessage(byte[] content) {

        super(content); // Pass the byte[] content to the parent constructor
    }

    @Override
    public String toString() {
        return super.toString() + "Content Size (Bytes): " + getContent()+ "\n"; // Add content size for byte messages
    }
}
