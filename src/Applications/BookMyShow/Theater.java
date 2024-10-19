package Applications.BookMyShow;
import Applications.BookMyShow.Enums.City;

import java.util.*;
public class Theater {
    List<Screen> screenList;
    List<Show> showList;
    int theaterId;
    City city;
    String address;

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public List<Show> getShowList() {
        return showList;
    }
}
