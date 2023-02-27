package spring.training.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.training.entity.Client;
import spring.training.service.ClientService;

@RestController
@RequestMapping(value = "api/clients")
public class ClientController {
    @Autowired
     ClientService clientService;




    @GetMapping("")
    public ResponseEntity <Object> getClients(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK) ;
    }
    @PostMapping("")
    public ResponseEntity<Object> createClient(@Validated @RequestBody Client client){
        clientService.Save(client);
        return new ResponseEntity<>(client,HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Object>UpdateClient (@RequestBody Client client, @PathVariable("id") Integer id){
        clientService.Update(client, id);
        client.setId(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public void DeleteClient(@PathVariable("id") Integer id ){

        clientService.Delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(clientService.findById(id),HttpStatus.OK);
    }
}
