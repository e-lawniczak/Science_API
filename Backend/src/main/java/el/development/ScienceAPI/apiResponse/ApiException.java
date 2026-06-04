package el.development.ScienceAPI.apiResponse;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ApiStatusCode code;

    public ApiException(ApiStatusCode code) {
        this.code = code;
    }

}