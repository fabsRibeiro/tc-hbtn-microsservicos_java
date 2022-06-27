package JPA;

import com.example.jpah2demo.entity.Cliente;
import com.example.jpah2demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        Cliente addCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCliente);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Cliente clienteEncontrado = clienteRepository.getReferenceById(idClient);
        return ResponseEntity.ok(clienteEncontrado);
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
       try {
            clienteRepository.deleteById(idClient);
       } catch (Exception e){
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> attCliente = clienteRepository.findById(id);
        if(attCliente.isPresent()){
            Cliente atualizarCliente = attCliente.get();
            atualizarCliente.setEmail(cliente.getEmail());
            atualizarCliente.setIdade(cliente.getIdade());
            atualizarCliente.setNome(cliente.getNome());
            atualizarCliente.setId(cliente.getId());
        }
    }
}
