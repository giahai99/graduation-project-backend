package com.utc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utc.exception.ResourceNotFoundException;
import com.utc.model.Type;
import com.utc.repository.TypeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("CovidManagement/")
public class TypeListController {
	@Autowired
	private TypeRepository typeRepository;

	@GetMapping("/types")
	public List<Type> getAllTypes(){
		return typeRepository.findAll();
	}
	// get type by id rest api
	@GetMapping("/types/{id}")
	public ResponseEntity<Type> getRowById(@PathVariable Integer id ){
		Type type = typeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Type doesn't exist with type id :"+ id));
		return ResponseEntity.ok(type);
	}
	
	// delete type row rest api
		@DeleteMapping("/types/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteType(@PathVariable Integer id){
			Type type = typeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Type doesn't exist with type id :"+id));
			typeRepository.delete(type);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
		}	
}
