package desafio.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
// Essa classe observa TODOS os controllers da aplicação
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
// Quando acontecer uma MethodArgumentNotValidException,
// chame este método automaticamente
    public ResponseEntity<Map<String, List<String>>> handleValidation(
            MethodArgumentNotValidException ex
    ) {

        // Aqui estamos extraindo apenas as mensagens de erro
        // ex.getBindingResult() resultado da validação
        // getFieldErrors() erros por campo
        // stream() percorre a lista
        // map(...) transforma cada erro em uma mensagem
        List<String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        // Monta o JSON esperado pelo frontend
        // { "erros": [ ... ] }
        Map<String, List<String>> body = Map.of("erros", erros);

        // Retorna HTTP 422 + corpo formatado
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(body);
    }
}
