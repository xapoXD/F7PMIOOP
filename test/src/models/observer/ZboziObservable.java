package models.observer;

import models.Zbozi;

public interface ZboziObservable {

    void addToSklad(Zbozi zbozi);

    void removeFromSklad(Zbozi zbozi);

}
