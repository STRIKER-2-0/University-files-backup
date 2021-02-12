package functional;

import java.util.EventObject;

public class DataBaseChangeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DataBaseChangeEvent(Object source) {
        super(source);
    }
}
