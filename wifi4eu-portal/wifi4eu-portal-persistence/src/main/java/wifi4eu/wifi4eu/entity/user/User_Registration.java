package wifi4eu.wifi4eu.entity.user;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User_Registration {
    @ManyToOne
    @JoinColumn(name = "_user")
    private int _user;

    @ManyToOne
    @JoinColumn(name = "_registration")
    private int _registration;

    public User_Registration() {

    }

    public User_Registration(int _user, int _registration) {
        this._user = _user;
        this._registration = _registration;
    }

    public int get_user() {
        return _user;
    }

    public void set_user(int _user) {
        this._user = _user;
    }

    public int get_registration() {
        return _registration;
    }

    public void set_registration(int _registration) {
        this._registration = _registration;
    }
}
