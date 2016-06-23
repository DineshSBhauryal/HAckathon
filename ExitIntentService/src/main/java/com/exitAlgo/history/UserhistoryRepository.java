package com.exitAlgo.history;
import org.springframework.data.repository.CrudRepository;
public interface UserhistoryRepository extends CrudRepository<Userhistory, Long>{
	
	public Userhistory findByUsername(String username);
}