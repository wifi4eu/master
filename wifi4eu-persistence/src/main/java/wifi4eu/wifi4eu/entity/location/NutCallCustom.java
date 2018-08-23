package wifi4eu.wifi4eu.entity.location;

import javax.persistence.*;

@Entity
public class NutCallCustom {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "event", length = 20)
    public String event;

    @Column(name = "label", length = 20)
    public String label;

    public NutCallCustom(){

    }

    public NutCallCustom(Integer id, String event, String label) {
        this.id = id;
        this.event = event;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

