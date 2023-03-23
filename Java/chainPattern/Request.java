package chainPattern;

public class Request  {
    String type;
    String content;


    int status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }

}
