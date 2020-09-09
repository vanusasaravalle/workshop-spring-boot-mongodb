package com.vansaravalle.workshopmongo.resource;

import com.vansaravalle.workshopmongo.domain.User;
import com.vansaravalle.workshopmongo.dto.UserDTO;
import com.vansaravalle.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> findAll(){

      List<User> list = userService.findAll();
      List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <UserDTO> findById (@PathVariable String id){

       Optional<User> user = userService.findById(id);
       return ResponseEntity.ok().body(new UserDTO(user));
    }


}
