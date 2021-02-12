public class FunctionNotFoundException extends Exception {
    public FunctionNotFoundException() {
        this("Метод не найден");
    }

    public FunctionNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
