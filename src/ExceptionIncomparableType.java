public class ExceptionIncomparableType extends Exception{
    public ExceptionIncomparableType(String type) {
        super(String.format("Несопоставимый тип", type));
    }
}

