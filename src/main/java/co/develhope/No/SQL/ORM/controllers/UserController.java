package co.develhope.No.SQL.ORM.controllers;

import co.develhope.No.SQL.ORM.entities.User;
import co.develhope.No.SQL.ORM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return userRepository.findById(id);
    }
    @GetMapping
    public List<User> listaUsers(){
        return userRepository.findAll();
    }
    @PutMapping("/{id}")
    public User editUser(@PathVariable String id, @RequestBody User user){
        user.setId(id);
        return userRepository.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
