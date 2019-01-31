package br.com.trrsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import br.com.trrsolution.dto.ListName;
import br.com.trrsolution.dto.Response;
import br.com.trrsolution.services.ExerciseService;

@Api(value = "List 1")
@RestController
@RequestMapping("/List1")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/calculateData", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Response>> calculateData(@RequestBody List<ListName> request) {
		return new ResponseEntity<>(exerciseService.calculator(request), HttpStatus.OK);
    }	
}
