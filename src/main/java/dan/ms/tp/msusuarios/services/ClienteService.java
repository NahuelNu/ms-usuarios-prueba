package dan.ms.tp.msusuarios.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dan.ms.tp.msusuarios.exception.NotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;


public interface ClienteService {
        public ResponseEntity<Cliente> crear(Cliente c);
        public ResponseEntity<Cliente> buscarPorId(Integer id) throws NotFoundException;
        public ResponseEntity<List<Cliente>> buscarPorCuit(String cuit);
        public ResponseEntity<List<Cliente>> buscarTodos();

        
        public ResponseEntity<Cliente> borrar(Integer id);
        public ResponseEntity<Cliente> modificar(Integer id, Cliente c);

        //Implementear

        public ResponseEntity<Double> getCtaCte(Integer id);
}
