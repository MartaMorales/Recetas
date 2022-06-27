package com.recetas.springboot.backend.apirest.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    /**
     *La statuspropiedad mantiene el estado de la llamada de operación. Será cualquier cosa, desde 4xx para indicar errores del cliente o 5xx para indicar errores del servidor. Un escenario común es un código http 400 que significa BAD_REQUEST, cuando el cliente, por ejemplo, envía un campo con formato incorrecto, como una dirección de correo electrónico no válida.
     *
     * La timestamppropiedad contiene la instancia de fecha y hora de cuando ocurrió el error.
     *
     * La messagepropiedad contiene un mensaje fácil de usar sobre el error.
     *
     * La debugMessagepropiedad contiene un mensaje del sistema que describe el error con más detalle.
     */

    /*HttpStatus es la clase que contiene el codigo de error Http*/
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this(); // Este this implementa el constructor vacio
        this.status = status;
    }

    ApiError(HttpStatus status, String message, Throwable ex){
        this(); //Implementa el constructor vacio
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
