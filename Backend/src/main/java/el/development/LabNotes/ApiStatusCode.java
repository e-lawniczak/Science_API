package el.development.ScienceAPI;

public enum ApiStatusCode {
    //OK
    OK(""),

    //ERRORS
    PASSWORD_NO_MATCH("Hasła muszą być takie same"),
    PASSWORD_COMPLEXITY("Hasło nie spełnia wymogów złożoności"),
    EMAIL_NOT_VALID("Email niepoprawny"),
    EMAIL_EXISTS("Email już istnieje"),

    ERROR("Wystąpił nieoczekiwany błąd"), INVALID_CREDENTIALS("Niepoprawne dane logowania");

    private String msg;

    ApiStatusCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
