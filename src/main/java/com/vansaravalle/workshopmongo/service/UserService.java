package com.vansaravalle.workshopmongo.service;


import com.vansaravalle.workshopmongo.domain.User;
import com.vansaravalle.workshopmongo.dto.UserDTO;
import com.vansaravalle.workshopmongo.repository.UserRepository;
import com.vansaravalle.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String id){

        Optional<User> user = userRepository.findById(id);
        if (user == null){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;

    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
