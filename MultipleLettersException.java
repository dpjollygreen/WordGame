public class MultipleLettersException extends Exception{
    @Override
    public String getMessage() {
        //System.out.println("More than one letter was entered");
        return "More than one letter was entered";
    }
}
