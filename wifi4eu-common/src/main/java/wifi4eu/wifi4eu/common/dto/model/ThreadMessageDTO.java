package wifi4eu.wifi4eu.common.dto.model;

public class ThreadMessageDTO {
    private int id;
    private int threadId;
    private int authorId;
    private String message;
    private long createDate;

    public ThreadMessageDTO() {
    }

    public ThreadMessageDTO(int id, int threadId, int authorId, String message, long createDate) {
        this.id = id;
        this.threadId = threadId;
        this.authorId = authorId;
        this.message = message;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}