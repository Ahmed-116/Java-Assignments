

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sms {
    private String messageId;
    private String senderName;
    private String receiver;
    private Object content;  // Can store any type of content: String, byte[], Integer, custom objects
    private String status;
    public static int messageCounter = 0;
    LocalDateTime ldt = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy_E_hh:mm:ss ");
    public String dateTime = ldt.format(dtf);

    // Default constructor for marking the message as read
    public void markAsRead() {
        this.status = "read";
    }

    // Getters and Setters
    public String getSenderName() {
        return senderName;
    }

    public String getReceiver() {
        return receiver;
    }

    public Object getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getMessageId() {
        return messageId;
    }

    // Constructor for Sms with Object content (could be String, byte[], Integer, etc.)
    public Sms(Object content) {
        this.messageId = String.format("%03d", ++messageCounter);
        this.senderName = "Wajahat";
        this.receiver = receiver;
        this.content = content;
        this.status = "unread";
        this.dateTime = dateTime;
    }


    public Sms(String content) {
        this((Object) content);
    }


    public Sms(byte[] content) {
        this((Object) content);
    }

    @Override
    public String toString() {
        if (content instanceof String) {
            // If the content is a String, just return the string representation
            return String.format("MessageId: %s\nFrom: %s\nTo: %s\nStatus: %s\nContent: %s\nTime: %s\n",
                    messageId, senderName, receiver, status, content, dateTime);
        } else if (content instanceof byte[]) {
            // If the content is byte[], print it as a byte array
            return String.format("MessageId: %s\nFrom: %s\nTo: %s\nStatus: %s\nContent: %s\nTime: %s\n",
                    messageId, senderName, receiver, status, java.util.Arrays.toString((byte[]) content), dateTime);
        } else {
            // If the content is of an unknown type, just print it as an object
            return String.format("MessageId: %s\nFrom: %s\nTo: %s\nStatus: %s\nContent: %s\nTime: %s\n",
                    messageId, senderName, receiver, status, content.toString(), dateTime);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sms sms = (Sms) o;
        return messageId.equals(sms.messageId) || senderName.equals(sms.senderName);
    }
}


