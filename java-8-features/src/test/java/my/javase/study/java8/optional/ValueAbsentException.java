package my.javase.study.java8.optional;

/**
 * Created by xpcomrade on 10/26/15.
 */
public class ValueAbsentException extends Throwable {

    public ValueAbsentException(){
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }


    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}
