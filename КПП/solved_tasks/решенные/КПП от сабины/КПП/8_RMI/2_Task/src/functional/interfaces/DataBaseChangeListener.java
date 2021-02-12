package functional.interfaces;

import functional.DataBaseChangeEvent;

import java.util.EventListener;

public interface DataBaseChangeListener extends EventListener {
    void dataChanged(DataBaseChangeEvent e);
}
