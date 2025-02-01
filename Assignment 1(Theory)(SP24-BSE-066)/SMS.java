import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SMS {
    private String msg;
    String sender;
    private String receiver;
    private String messageId;
    private String status;
    public static int counter = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.now();
    public String date = dateTime.format(formatter);


    public SMS( String receiver,String sender,String message ) {
        this.msg = message;
        this.sender = sender;
        this.receiver = receiver;
        this.status = "unread";
        this.messageId = String.format("%03d", ++counter);


    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void markAsRead() {
        this.status = "read";
    }

    @Override
    public String toString() {
        return
                "[" + date +
                        "]"+"(Message # "+messageId+")" + sender + " to "+ receiver + ": " + msg + "(" + status + ")";
    }
}
