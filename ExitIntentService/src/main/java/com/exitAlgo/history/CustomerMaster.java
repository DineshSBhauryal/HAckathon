package com.exitAlgo.history;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.repository.CrudRepository;
public class CustomerMaster {
	public double historyVal(String user) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				HistoryBean.class);
		UserhistoryRepository repository = context
				.getBean(UserhistoryRepository.class);
		
	Userhistory customers = repository.findByUsername(user);
		
		((AbstractApplicationContext) context).close();
		return customers.getScore();
	}
	
	
	/*public static void main(String arrgs[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				HistoryBean.class);
		UserhistoryRepository repository = context
				.getBean(UserhistoryRepository.class);
		repository.save(new Userhistory("Rajesh", 441));
		repository.save(new Userhistory("Krishna", 332));
		
		Iterable<Userhistory> customers = repository.findAll();
		for (Object customer : customers) {
			System.out.println(customer);
		}
		Userhistory customers = repository.findByUsername("Rajesh");
		System.out.println(customers.getScore());
		((AbstractApplicationContext) context).close();
		
	}*/
}