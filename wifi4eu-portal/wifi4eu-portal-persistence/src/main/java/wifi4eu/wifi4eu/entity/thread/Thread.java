package wifi4eu.wifi4eu.entity.thread;

import javax.persistence.*;

@Entity
@Table(name = "threads")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "title")
    String title;

    public Thread() {
    }

    public Thread(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}