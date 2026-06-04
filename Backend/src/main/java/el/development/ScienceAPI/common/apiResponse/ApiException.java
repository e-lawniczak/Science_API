package el.development.ScienceAPI.common.apiResponse;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ApiStatusCode code;
    private final String message;

    public ApiException(ApiStatusCode code) {
        this.code = code;
        this.message = null;
    }

    public ApiException(ApiStatusCode code, String message) {
        this.code = code;
        this.message = message;
    }

}