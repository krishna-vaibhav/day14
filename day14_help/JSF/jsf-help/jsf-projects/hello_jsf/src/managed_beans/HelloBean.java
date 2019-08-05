package managed_beans;

import java.time.LocalTime;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hello")
//def scope=request scope
@SessionScoped
public class HelloBean {
	private String name="some nm";
	private String greeting;
	public HelloBean() {
		System.out.println("in hello bean constr");
	}
	@PostConstruct
	public void init1()
	{
		System.out.println("in init ");
	}
	public void destroy1()
	{
		System.out.println("in dest ");
	}
	//B.L method -- event handler method
	public String sayHello()
	{
		System.out.println("in say hello");
		if(LocalTime.now().isBefore(LocalTime.NOON))
			greeting="Good  Morning!";
		else if(LocalTime.now().isBefore(LocalTime.of(17, 0)))
			greeting="Good Afternoon !";
		else 
			greeting="Good Evening !";
		greeting=greeting.concat("Hello , "+name);
		return "welcome";
		
	}
	public String sayBye()
	{
		System.out.println("in say bye ");
		greeting ="Good Bye "+name;
		return "welcome";
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	

	

}
