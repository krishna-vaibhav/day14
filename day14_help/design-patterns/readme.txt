Design patterns

There are common problems faced by programmers all over.
Not a domain specific problem --asso with banking / insurance or manufacturing or pharma etc.

BUT if its a generic problem(eg : writing a web app , separating cross cutting concerns ) --then there are standard solutions to these common problems -- these are nothing but the design patterns---best practises.

Design Patterns -- Started with Gang Of Four in 1994 --but being modified/enhanced since then.
Summary was
1. Always prefer composition over inheritance
2. Always code for i/f & not imple.

In a nut shell 
Good programming practises --to be followed by prog community.

Should u know about all of  them ? -- 100 %
Should u apply all of them -- NO ---nobody does that--you should only use those patterns which your appln demands.

They are categorised into 3 parts
1. Creational design patterns  -- best practises for object creation
eg : singleton , factory , builder
2. Structural  -- best practises for composition of objects to create a larger application
eg : adapter
3. Behavioural -- best practises for communication between the objects (w/o any composition)

You can think of additional category as 
4. J2EE design patterns  -- MVC , Front Controller , DAO , DTO 


Pattern examples 
1. singleton 
Typically all spring beans , used are singleton.

2. Factory
eg : o.s.bean.factory.BeanFactory <----- ApplicationContext <----- ClassPathXmlApplicationContext
In above case , SC is following factory pattern --provider of the rdymade spring beans (via ctx.getBean method)
Another eg : Hibernate's session factory

2.5 Builder -- 
Use case --When there are too many parameters needed to be passed to a class constructor, instead use builder pattern.


Structural Patterns 

3. Adapter design pattern is one of the structural design pattern and its used so that two unrelated interfaces can work together. The object that joins these unrelated interface is called an Adapter.
eg :  Mobile charger works as an adapter between mobile charging socket and the wall socket.
1. We will have two classes – Volt (to measure voltage) and Socket (producing constant voltage of 230V).
2. Now  build an adapter that can produce 3 volts, 12 volts and default 230 volts. So  create an adapter interface with these methods.
3. Object adapter implementation --based on composition
4. A tester
-------------------
4. Facade Design Pattern -- structural design pattern

Suppose we have an application with set of interfaces to use MySql/Oracle database and to generate different types of reports, such as HTML report, PDF report etc.

So we will have different set of interfaces to work with different types of database. Now a client application can use these interfaces to get the required database connection and generate reports.

But when the complexity increases or the interface behavior names are confusing, client application will find it difficult to manage it.

So we can apply Facade design pattern here and provide a wrapper interface on top of the existing interface to help client application.

eg : 
1. Two helper interfaces, -- namely MySqlHelper and OracleHelper.
2. Facade pattern interface 
3. Tester

----------------------
Proxy Design pattern is one of the Structural design pattern
Provide a surrogate(substitute) or placeholder for another object to control access to it.
eg : AOP proxies.
Refer to example of tx manager in spring framework
eclipse project --test_aop_simple
--------------------
Behavioral Design patterns

1. Template Method is a behavioral design pattern. 
Template Method design pattern is used to create a method stub and deferring some of the steps of implementation to the subclasses.
eg : Spring example  -- RestTemplate

----------------
2. A Command pattern is an object behavioral pattern

Allows us to achieve complete decoupling between the sender and the receiver.

A sender  -- is an object that invokes an operation
A receiver is an object that receives the request to execute a certain operation.

With decoupling, the sender has no prior knowledge of the Receiver's interface. 

Here request = command that is to be executed. 
The Command pattern also allows us to vary when and how a request is fulfilled. Thus :  a Command pattern provides us flexibility as well as extensibility.
eg :
1. 2 electrical instruments to operate --fan & light bulb
2. Command i/f
3. Command imple classes
4. Switch -- invokes command on the receiver object
5. tester


