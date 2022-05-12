package com.estudo.course.services;

import com.estudo.course.entities.User;
import com.estudo.course.repositories.UserRepository;
import com.estudo.course.services.exceptions.DatabaseException;
import com.estudo.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public User findById(Long id){
       Optional<User> obj = userRepository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
     return userRepository.save(obj);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
      }

    public User update(@PathVariable Long id, @RequestBody User user){
       User entity = userRepository.getById(id);
       updateData(entity, user);
       return userRepository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
