package app.helpers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenericResponse<T> {
    private ArrayList<Error> errores;
    private HttpStatus Success;
    private List<T> payload;
}
