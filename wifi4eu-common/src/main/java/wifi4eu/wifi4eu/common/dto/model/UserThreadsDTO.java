package wifi4eu.wifi4eu.common.dto.model;

public class UserThreadsDTO {
    private int id;
    private int userId;
    private int threadId;

    public UserThreadsDTO() {
    }

    public UserThreadsDTO(int id, int userId, int threadId) {
        this.id = id;
        this.userId = userId;
        this.threadId = threadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
}