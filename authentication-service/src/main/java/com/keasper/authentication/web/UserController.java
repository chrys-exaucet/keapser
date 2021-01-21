package com.keasper.authentication.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.keasper.authentication.dto.UserDTO;
import com.keasper.authentication.mapper.UserMapper;
import com.keasper.authentication.service.UserService;


import io.swagger.annotations.ApiOperation;

import static java.util.stream.Collectors.toList;

import java.net.URI;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;

	public final UserMapper mapper =  UserMapper.INSTANCE;

	@ApiOperation(value="Retourne tous les utilisateurs")
	@GetMapping(value = "/users")
	private List<UserDTO> getUsers(){
		return userService.findAll().stream().map(mapper::toDto).collect(toList());
	}

	@ApiOperation(value="Retourne un utilisateur par son id")
	@GetMapping(value="/user/{id}")
	private UserDTO getUserById(@PathVariable long id) {
		return mapper.toDto(userService.findById(id));
	}

	@ApiOperation(value="Enregistre un nouvel utlisateur")
	@PostMapping(value="/add")
	private ResponseEntity<UserDTO> newUser(@Valid @RequestBody UserDTO newUser) {
		UserDTO user = mapper.toDto(userService.save(mapper.fromDto(newUser)));
		if(user==null) return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/")
				.buildAndExpand(newUser)
				.toUri();
		return ResponseEntity.created(location).build();
	}


	@ApiOperation(value="Met à jour un utilisateur")
	@PutMapping(path = "/update")
	private ResponseEntity<UserDTO> updateEmployee(@Valid @RequestBody UserDTO userUpdate) {
		if((userService.update(mapper.fromDto(userUpdate)) != null)) {
			return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build() ;
	}

	@ApiOperation(value="Supprime un utlisateur par un id")
	@DeleteMapping(path = "/delete/{id}")
	private ResponseEntity<UserDTO> deleteEmployee(@PathVariable("id") Long userId) {
		if(!userService.delete(userId))return ResponseEntity.notFound().build(); 
		else return ResponseEntity.noContent().build();
	}
}
