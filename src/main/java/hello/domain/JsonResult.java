package hello.domain;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongpf on 16/4/11.
 */
public class JsonResult {
    private boolean success ;

    Set errors ;

    String message  ;


    public static class Errors {
        private String field;
        private String errMsg;

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Errors(String field, String errMsg) {
            this.field = field;
            this.errMsg = errMsg;
        }
    }


    public boolean isSuccess() {
        return this.errors ==null || this.errors.size()==0;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set getErrors() {
        return errors;
    }

    public void setErrors(Set errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addError(String field, String errMsg) {
        Assert.hasLength(field);
        Assert.hasLength(errMsg);
        if (this.errors == null) {
            errors = new HashSet<Errors>();
        }
        errors.add(new Errors(field, errMsg));
    }
}
