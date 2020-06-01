package DePaul.Group_9.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DePaul.Group_9.demo.model.Order;
import DePaul.Group_9.demo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@DeleteMapping("/delete/{id}")
	public Boolean delete(@PathVariable int id) {
		orderService.deleteById(id);
		return Boolean.TRUE;
	}
	 
	@GetMapping("/findById/{id}")
	public Optional<Order> findById(@PathVariable int id) {
		return 	orderService.findById(id);
	}
	
 
//	@GetMapping("/findByName/{name}")
//	public List<Order> findByName(@PathVariable String name) {
//		return 	orderService.findByName(name);
//	}
	
	@PutMapping("/update")
	public Boolean update(@RequestBody Order e) {
		orderService.save(e);
		return Boolean.TRUE;
	}
	
	@GetMapping("/list")
	public List<Order> find(){
		return orderService.findAll();
	}

	@PostMapping("/save")
	public Boolean save(@RequestBody Order e) {
		orderService.save(e);
		return Boolean.TRUE;
	}
}
