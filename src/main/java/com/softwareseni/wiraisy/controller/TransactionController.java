package com.softwareseni.wiraisy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softwareseni.wiraisy.dto.General_dto;
import com.softwareseni.wiraisy.dto.Sum_dto;
import com.softwareseni.wiraisy.dto.Transaction_id_dto;
import com.softwareseni.wiraisy.entity.Transaction;
import com.softwareseni.wiraisy.service.TransactionService;



@RestController
public class TransactionController {
	
	@PutMapping(value = "/transaction/put/{transaction_id}/{amount}/{type}/{parent_id}")
	@ResponseBody
	public ResponseEntity<General_dto> addTransaction(@PathVariable Long transaction_id, @PathVariable Double amount, @PathVariable String type, @PathVariable Optional<Long> parent_id){
		General_dto dto = TransactionService.putTransaction(transaction_id,amount,type,parent_id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
    }

	@GetMapping(value = "/transaction/get/{transaction_id}")
	@ResponseBody
	public ResponseEntity<General_dto> gettransactionbyidtransaction(@PathVariable Long transaction_id){
		Transaction t = TransactionService.gettransactionbyidtransaction(transaction_id);
		General_dto dto = new General_dto(t.getAmount(), t.getType(), t.getParent().getParent_id());
		return new ResponseEntity<>(dto, HttpStatus.OK);
    }
	
	@GetMapping(value = "/transaction/gett/{type}")
	@ResponseBody
	public ResponseEntity<List<Transaction_id_dto>> gettransactionidbytype(@PathVariable("type") String type){
		List<Transaction_id_dto> list = new ArrayList<>();
		List<Long> listlong = TransactionService.gettransactionidbytype(type);
		for(Long id: listlong) {
			Transaction_id_dto o = new Transaction_id_dto();
			o.setTransaction_id(id);
			list.add(o);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
    }

	
	@GetMapping(value = "/transaction/sum/{transaction_id}")
	@ResponseBody
	public ResponseEntity<Sum_dto> getsumallamountbyparentintransaction(@PathVariable Long transaction_id){
		return new ResponseEntity<>(TransactionService.getsumallamountbyparentintransaction(transaction_id), HttpStatus.OK);
	}
	
}
