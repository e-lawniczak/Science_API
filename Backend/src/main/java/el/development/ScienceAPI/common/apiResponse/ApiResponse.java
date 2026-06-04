package el.development.ScienceAPI.common.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String message;
    private int status;
    private T data;

    public ApiResponse(ApiStatusCode code, T responseObject) {
        this.message = code.getMessage();
        this.status = code.getCode();
        this.data = responseObject;
    }

    public ApiResponse(ApiStatusCode code) {
        this.message = code.getMessage();
        this.status = code.getCode();
        this.data = null;
    }
}
