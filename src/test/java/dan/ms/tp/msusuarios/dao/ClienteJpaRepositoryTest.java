package dan.ms.tp.msusuarios.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import dan.ms.tp.msusuarios.modelo.Cliente;

@DataJpaTest
public class ClienteJpaRepositoryTest {
    
    @Autowired
    ClienteJpaRepository clienteRepo;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){


        Cliente cliente = Cliente.builder()
                            .correoElectronico("a@a.com")
                            .cuit("20123456789")
                            .habilitadoOnline(true)
                            .maximoCuentaCorriente(100.0)
                            .razonSocial("a")
                            .build();
        testEntityManager.persist(cliente);

    }

    @Test
    @Sql({"/data/danH2.sql"})
    public void findByCuitJPQLFound(){
        List<Cliente> clientes = clienteRepo.findByCuitJPQL("20123456789");
        List<Cliente> clientesInsertados = new ArrayList<>();

        clientesInsertados.add((Cliente.builder()
        .correoElectronico("a@a.com")
        .cuit("20123456789")
        .habilitadoOnline(true)
        .maximoCuentaCorriente(100.0)
        .id(1)
        .razonSocial("a")
        .build()));

        assertEquals(clientes, clientesInsertados);
    }
}
