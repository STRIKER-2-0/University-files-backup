package client;

import compute.Task;

public class CapitalizeString implements Task<String> {
    private static final long serialVersionUID = 227L;
	private	String str = null;

    public CapitalizeString(String str) {
        this.str = str;
    }

    public String execute() {
        return str+str;
    }
}