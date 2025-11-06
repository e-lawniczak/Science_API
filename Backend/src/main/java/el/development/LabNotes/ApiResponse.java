package el.development.LabNotes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>  {
    private ApiStatusCode code;
    private T returnObject;

    public ApiResponse(ApiStatusCode code){
        code = code;
        returnObject = null;
    }
}
