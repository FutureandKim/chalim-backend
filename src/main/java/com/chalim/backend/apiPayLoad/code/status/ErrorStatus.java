package com.chalim.backend.apiPayLoad.code.status;

import com.chalim.backend.apiPayLoad.code.BaseErrorCode;
import com.chalim.backend.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500000", "서버 에러입니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"400000","잘못된 요청입니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "403000", "금지된 요청입니다."),
    _NOT_FOUND(HttpStatus.NOT_FOUND, "404000", "요청한 자원을 찾을 수 없습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
