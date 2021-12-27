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
import com.utc.model.LocationTrace;
import com.utc.repository.LocationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("CovidManagement/")
public class LocationListController {
	@Autowired
	private LocationRepository locationRepository;

	@GetMapping("/locations")
	public List<LocationTrace> getAllLocations(){
		return locationRepository.findAll();
	}
	// get location by id rest api
	@GetMapping("/locations/{id}")
	public ResponseEntity<LocationTrace> getRowById(@PathVariable Integer id ){
		LocationTrace location = locationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Location doesn't exist with location id :"+ id));
		return ResponseEntity.ok(location);
	}
	
	// delete location row rest api
		@DeleteMapping("/locations/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteLocation(@PathVariable Integer id){
			LocationTrace location = locationRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Location don't exist with location id :"+id));
			locationRepository.delete(location);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return ResponseEntity.ok(response);
		}	
}