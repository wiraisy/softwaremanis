package com.softwareseni.wiraisy.service;

import java.util.*;

import com.softwareseni.wiraisy.dto.General_dto;
import com.softwareseni.wiraisy.dto.Sum_dto;
import com.softwareseni.wiraisy.entity.Parent;
import com.softwareseni.wiraisy.entity.Transaction;

public class TransactionService {
	
	private static List<Transaction> listtrans = new ArrayList<>();
	private static List<Transaction> listtrans2 = new ArrayList<>();
	
	static {
		Transaction t = new Transaction();
		t.setTransaction_id(1l);
		t.setParent(new Parent(Optional.of(1l)));
		t.setType("cars");
		t.setAmount(3000d);
        listtrans.add(t);
        Transaction t1 = new Transaction();
		t1.setTransaction_id(2l);
		t1.setParent(new Parent(Optional.of(2l)));
		t1.setType("bike");
		t1.setAmount(1000d);
        listtrans.add(t1);
	}

	public static General_dto putTransaction(Long transaction_id, Double Amount, String type, Optional<Long> Parent_id){
		listtrans2 = new ArrayList<>(listtrans);
		for(int a = 0; a<listtrans2.size(); a++) {
			if(listtrans2.get(a).getTransaction_id() == transaction_id) {
				if(listtrans2.get(a).getParent().getParent_id() == Parent_id) {
					listtrans.get(a).setAmount(Amount);
					listtrans.get(a).setType(type);
					break;
				}else {
					listtrans.get(a).setParent(new Parent(Parent_id));
					listtrans.get(a).setAmount(Amount);
					listtrans.get(a).setType(type);
					break;
				}
			}else {
				Transaction tt = new Transaction();
				tt.setTransaction_id(transaction_id);
				tt.setParent(new Parent(Parent_id));
				tt.setAmount(Amount);
				tt.setType(type);
				listtrans.add(tt);
				break;
			}
			
		}
		
		return new General_dto(Amount, type, Parent_id);
    }
	
	public static Transaction gettransactionbyidtransaction(Long transaction_id){
		Transaction trans = new Transaction();
		for(Transaction ty: listtrans) {
			if(ty.getTransaction_id() == transaction_id) {
				trans.setParent(ty.getParent());
				trans.setTransaction_id(ty.getTransaction_id());
				trans.setAmount(ty.getAmount());
				trans.setType(ty.getType());
			}
		}
        return trans;
    }
	
	public static List<Long> gettransactionidbytype(String type){
		List<Long> list = new ArrayList<>();
		for(Transaction trans: listtrans) {
			if(trans.getType().equals(type)) {
				list.add(trans.getTransaction_id());
			}
		}
        return list;
    }
	
	private static Optional<Long> Parentid;
	private static Double sum;
	
	public static Sum_dto getsumallamountbyparentintransaction(Long transaction_id){
	    sum = 0d;
	    Parentid = Optional.empty();
		for(Transaction trans: listtrans) {
			if(trans.getTransaction_id() == transaction_id) {
				if(trans.getParent().getParent_id().isPresent()) {
					sum = 0d;
					Parentid = trans.getParent().getParent_id();
				}else {
					sum += trans.getAmount();
				}
			}
			
		}
			if(Parentid.isPresent()) {
				for(Transaction t: listtrans) {
					if(t.getParent().getParent_id().equals(Parentid)) {
						sum += t.getAmount();
					}
				}
			}
			
        return new Sum_dto(sum);
    }
	
	
	
}
