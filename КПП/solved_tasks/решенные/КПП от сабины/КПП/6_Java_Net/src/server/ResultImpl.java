package server;

import Interfaces.Result;

import java.io.Serializable;

public class ResultImpl implements Serializable, Result {
    private Object output;
    private long scoreTime;

    public ResultImpl(Object output, long scoreTime) {
        this.output = output;
        this.scoreTime = scoreTime;
    }

    public Object output() {
        return output;
    }

    public long scoreTime() {
        return scoreTime;
    }
}
