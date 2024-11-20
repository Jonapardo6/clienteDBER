package servicios;

import modelos.Clientes;

import java.util.Arrays;
import java.util.List;

public class ClientesServiceImplement implements ClientesServices {

    @Override
    public List<Clientes> listar() {
        return Arrays.asList(
                new Clientes(1, "Juan", "Pérez", "juan.perez@example.com"),
                new Clientes(2, "María", "Gómez", "maria.gomez@example.com"),
                new Clientes(3, "Carlos", "López", "carlos.lopez@example.com")
        );
    }
}
