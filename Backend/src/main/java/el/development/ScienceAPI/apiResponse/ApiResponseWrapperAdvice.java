package el.development.ScienceAPI.apiResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ApiResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response) {

        // DO NOT wrap errors already handled
        if (body instanceof ApiResponse) {
            return body;
        }

        // DO NOT wrap null (optional but cleaner)
        if (body == null) {
            return new ApiResponse<>(ApiStatusCode.OK, null);
        }

        // DO NOT wrap Spring errors / framework responses
        if (body instanceof ResponseEntity) {
            return body;
        }

        return new ApiResponse<>(
                ApiStatusCode.OK,
                body
        );
    }
}