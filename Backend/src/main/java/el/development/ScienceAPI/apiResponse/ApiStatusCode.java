package el.development.ScienceAPI.apiResponse;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;

public enum ApiStatusCode {
    //OK
    OK(1,"Ok"),

    //ERRORS

    //account
    UNAUTHORIZED(1000,"Użytkownik niezalogowany"),
    FORBIDDEN(1001,"Brak uprawnień do zasobu"),
    PASSWORD_NO_MATCH(1002,"Hasła muszą być takie same"),
    PASSWORD_COMPLEXITY(1003,"Hasło nie spełnia wymogów złożoności"),
    EMAIL_NOT_VALID(1004,"Email niepoprawny"),
    EMAIL_EXISTS(1005,"Email już istnieje"),
    USER_DOES_NOT_EXIST(1006,"Oczekiwany zasób nie istnieje"),
    INVALID_CREDENTIALS(1007,"Niepoprawne dane logowania"),

    ERROR(-1,"Wystąpił nieoczekiwany błąd");

    private final int code;
    private final String message;
    @Nullable
    private final HttpStatus httpStatus;

    ApiStatusCode(int code, String message) {
        this(code, message, null);
    }

    ApiStatusCode(int code, String message, @Nullable HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }
    public HttpStatus getHttpStatus() { return httpStatus != null ? httpStatus : HttpStatus.BAD_REQUEST; }
}
