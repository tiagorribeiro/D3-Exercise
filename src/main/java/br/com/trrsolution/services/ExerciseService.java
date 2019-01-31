package br.com.trrsolution.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.trrsolution.dto.ListName;
import br.com.trrsolution.dto.Request;
import br.com.trrsolution.dto.Response;


@Service
public class ExerciseService {
	
    public List<Response> calculator(List<ListName> request) { 
    	
    	List<Response> response = new ArrayList<Response>();
		int ageOfUsers = 0;
    	
    	for(ListName item : request){
    		if("Lista 1".equals(item.getName())){
    			response.add(getMore24Years(item));
    			response.add(getFeminine(item));
    			response.add(getSumYearsOfUser(item));
    			ageOfUsers += sumAgeAllUsers(item);
    		}
    		else if("Lista 2".equals(item.getName())){
    			response.add(orderUserByNameAsc(item));
    			response.add(orderUserByAgeAsc(item));
    			response.add(getFeminine(item));
    			ageOfUsers += ageOfUsers + sumAgeAllUsers(item);
    		}
    		else if("Lista 3".equals(item.getName())){
    			response.add(sumAgeLessThan25(item));
    			response.add(getUserMoreThan25(item));
    			ageOfUsers += ageOfUsers + sumAgeAllUsers(item);
    		}
    	};
    	
    	response.add(createResponseSumAgeAllUsers(ageOfUsers));
    	
  		return response;
    }
    
    private Response getMore24Years(ListName list) {
    	
    	Response response = new Response();
    	
    	response.setName(list.getName());
    	response.setMessage("Todos os usuarios com idade > 24 anos");
    	response.setData(list.getData().stream().filter((x) -> x.getAge() > 24).collect(Collectors.toList()));
    	
    	return response;
    }
    
    private Response getFeminine(ListName list) {
    	
    	Response response = new Response();
    	
    	response.setName(list.getName());
    	response.setMessage("Todos os usuarios do sexo feminino");
    	response.setData(list.getData().stream().filter((x) -> Character.toUpperCase(x.getGender()) == 'F').collect(Collectors.toList()));
    	
    	return response;
    }
    
    private Response getSumYearsOfUser(ListName list) {
    	
    	Response response = new Response();
    	int age = 0;
    	
    	for(Request item : list.getData()){    	   		
    		if(item.isUs()){
    			age += item.getAge();
    		}
    	};
    	
    	response.setName(list.getName());
    	response.setMessage("Soma de todas as idades dos usuarios"); 
    	response.setSum(age);
    	
    	return response;
    }
    
    private Response orderUserByNameAsc(ListName list) {
    	
    	Response response = new Response();
    	
    	List<Request> list1 = list.getData().stream().filter((x) -> x.isUs()).collect(Collectors.toList());
    	
    	//sort by age
		Collections.sort(list1, new Comparator<Request>() {
			@Override
			public int compare(Request o1, Request o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
    	
    	response.setName(list.getName());
    	response.setMessage("Todos os usuarios (us true) em ordem ascendente (nome)");
    	response.setData(list1);    	
    	
    	return response;
    }
    
    private Response orderUserByAgeAsc(ListName list) {
    	
    	Response response = new Response();
    	
    	List<Request> list1 = list.getData().stream().filter((x) -> x.isUs()).collect(Collectors.toList());
    	
		Collections.sort(list1, new Comparator<Request>() {
			@Override
			public int compare(Request o1, Request o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
		});
    	
    	response.setName(list.getName());
    	response.setMessage("Todos os usuarios por idade (crescente)");
    	response.setData(list1);    	
    	
    	return response;
    }
    
    private Response sumAgeLessThan25(ListName list) {
    	
    	Response response = new Response();
    	int age = 0;
    	
    	for(Request item : list.getData()){    	   		
    		if(item.getAge() < 25 && item.isUs()){
    			age += item.getAge();
    		}
    	};
    	
    	response.setName(list.getName());
    	response.setMessage("Some todas as idades de usuarios com idade menor que 25"); 
    	response.setSum(age);
    	
    	return response;
    }
    
    private Response getUserMoreThan25(ListName list) {
    	
    	Response response = new Response();
    	
    	response.setName(list.getName());
    	response.setMessage("Liste todos os usuarios com idade acima de 30");
    	response.setData(list.getData().stream().filter((x) -> x.isUs() && x.getAge() > 30).collect(Collectors.toList()));
    	
    	return response;
    }
    
    private int sumAgeAllUsers(ListName list) {
    	int age = 0;
    	
    	for(Request item : list.getData()){    	   		
    		if(item.isUs()){
    			age += item.getAge();
    		}
    	};
    	
    	return age;
    }
    
    private Response createResponseSumAgeAllUsers(int totalAge) {
    	
    	Response response = new Response();
    	
    	response.setName("Lista 1, Lista 2, Lista 3");
    	response.setMessage("Encontre a idade total de usuarios dos 3 arrays juntos"); 
    	response.setSum(totalAge);
    	
    	return response;
    }
    
}
