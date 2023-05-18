package academy.spring.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SpringAcademySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAcademySampleApplication.class, args);
	}

}


@Controller
@ResponseBody
class CustomerHttpController {
	private final CustomerRepository customerRepository;

	CustomerHttpController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping("/customers")
	Iterable<Customer> customers() {
		return this.customerRepository.findAll();
	}

}
interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Iterable<Customer> findByName(String name);
}

record Customer (@Id Integer id, String name) {}
