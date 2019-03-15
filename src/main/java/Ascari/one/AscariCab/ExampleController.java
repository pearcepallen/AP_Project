package Ascari.one.AscariCab;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	
		@RequestMapping("/")
		public String Hello()
		{
			return "y pree deebo";
		}
	

}
