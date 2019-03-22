package Ascari.one.AscariCab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class example {
	@RequestMapping(value = "/api/cab/baby")
	public String Hello()
	{
		return "Mad a road";
	}
}
