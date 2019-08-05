What is JSF
JavaServer Faces (JSF) is a Java specification(std part of J2EE specs , J2EE 1.5 onwards)  for building component-based user interfaces for web applications.

If Java AWT/Swing/Java FX represent the UI components for a Desktop Java Application, then JSF UI Components are meant for the Web Applications.

It's a standard Java EE web mvc framework.

JSF is based on well established MVC(Front Servlet Controller) design pattern.

There are as many popular  JSF implementations,namely Oracle Mojarra and Apache MyFaces & PrimeFaces, RichFaces etc.

What does JSF offer over other MVC frameworks?(why JSF ?)

What has been missing in the server side Java implementations is a presence of event driven frameworks to handle User Interface (UI) component interactions, input validations, handling page navigation and rendering.


JavaServerFaces (JSF) technology fills in this gap. JSF provides a set of APIs to represent UI components, manage their state, handle events, perform input validation and manage page navigation and internationalization. It decouples components from their presentation so they can be rendered in multiple ways and on different devices. 

2. JSF architecture
JavaServer Faces Architecture

The JSF architecture consists of six different layers.

UI Component Model
Rendering Model
Event Model
Validation Framework
Page Navigation Framework
Internationalization Framework



A typical JavaServer Faces application includes the following parts:

1. Web pages in which components are laid out. -- Facelets
What Is Facelets?
Facelets  powerful but lightweight page declaration language that is used to build JavaServer Faces views using XHTML style templates and to build component trees. (Support for Facelets tag libraries in addition to JavaServer Faces and JSTL tag libraries)

2. JSF custom tags to add components to the web page

3. Managed beans, which are lightweight container-managed objects (POJOs) based upon dependency injection,
lifecycle callbacks and interceptors.

4.Web deployment descriptor (web.xml file)

5.  Optional,  configuration files -- faces-config.xml file,  to define page navigation rules and configure
beans and  custom components.
6. Custom objects --- custom components, validators , converters, or listeners --programmer  created.
7  A set of custom tags for representing custom objects on the page



Developing a simple JavaServer Faces application typically requires the following steps

1.Create JSF enabled web application.
Dyn web project -- Choose configuration -- JSF 2.2 (or custom configuration & then Modify -- add JSF 2.2 facet) , add User lib (with jsf jars), configure Faces Servlet , additional url patterns can be added -- *.jsf, *.xhtml.



2. Developing managed beans(equivalent to Controller in Spring , actions in Struts or Java beans in Standalone MVC )
eg : HelloBean  
Annotations- 

1. @ManagedBean(name="nameOfBean/id", eager="def-false")
default scope --- request scope.


Step 2 .
Create web pages using component tags (If not created alrdy -- create new facelet template --without any composition tags)
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
    <h:head>
        <title>Facelets Hello </title>
    </h:head>
    <h:body>
       
    </h:body>
</html>

or take the template from help -- jsf-template-for-eclipse


Step 3.
Mapping the javax.faces.webapp.FacesServlet instance -- Is already done at the time of creating JSF enabled web application.

Step 4
Some more annotations.
2. Scope related Annotations -- @RequestScoped-- def scope --current request only.
@ViewScoped -- Bean lives as long as user is interacting with the same JSF view in the browser window or tab. It gets created upon a HTTP request and get destroyed once user postbacks to a different view.
@SessionScoped -- current session
@ApplicationScoped -- entire application
@NoneScoped -- no scope
Custom scope can also be created.

5.   For Using CSS
Create a folder under root(WebContent) -- default name used is <resources> -- under this <css> for .css & <images> for storing images. (css & image folder names can be changed)

For applying CSS -- add under <h:head> the following
<h:outputStylesheet name="css/main.css" />

For using images -- can add under <h:body> the following.

<h:graphicImage library="images" name="lavenderflowers.png"/>




6 Dependency Injection annotation -- to inject some other bean .
eg -- In managed bean -- UserBean
Following property 
@ManagedProperty(value="#{adr}")
   private Address address;
& in another managed Bean address
@ManagedBean(name="adr")
public class Address 
{.....}

If eager=true & scope=application --> only then bean is instantiated at the application start up time.



1. Registering user with address -- 
1.1 Create User Bean & Address Bean
Both -- to be managed by JSF(ie. for auto invocation of setters & getters associated with view layer) -- add @ManagedBean annotation.
User has-a Address.
For auto invocation of getters/setters of Address --(equivalent to MDI of struts 2)
Use 
@ManagedProperty(value="#{adr}")
private Address address;
Supply setter & getter for address property in User bean.
classes -- com.app.model -- User & Address




2. For submitting form ---
<h:commandButton value="Register User" action="user_registered" />
Above is eg of static navigation -- resolves to "user_registered.xhtml"
Can be replaced by dynamic navigation , using JSF EL syntax.
eg --<h:commandButton value="Show Balance" action="#{bankController.check}" /> --calls directly method check on bean(rules on method public string returning --string implicitely taken as outcome)



3. For confirming , session scope, link(<h:link value="Next" outcome="next"/>) . -- static outcome -- resolves to next.xhtml
Can be replaced by dynamic outcome.

4. In next page -- logout link -- BUT to discard session -- has to pass through -- bean method
eg of dyn outcome.
<h:form>
<h:commandLink value="logout" action="#{bankController.logout}" />
</h:form>


In logout method  --
How to discard http session?
Get FacesContext -- get ext context & invalidate session.(API of javax.faces.context.FacesContext)
Upon clicking link --- invokes user_info.logout -- & its return value(string) -- will be outcome.
ret value -- "/index.xhtml?faces-redirect=true" --  for re-directing user to index page.

JSF Converters
 Built in convertors : to convert  UI component's data to object used in a managed bean and vice versa.
Supplied via JSF Core Tag Library
Examples
<f:convertNumber pattern="#000.000" />
<f:convertDateTime pattern="dd-MMM-yyyy" />
Custom converters
Implement Converter interface & register the converter.

JSF Validators
Built In
f:validateLength : length of string
f:validateLongRange : range of numeric value
f:validateDoubleRange : range of float value
f:validateRegex : validates value against given regular expression.

Custom Validator
Implement Validator  interface.
Override public void validate(FacesContext facesContext, UIComponent component, String value) throws ValidatorException



1.2 Create view layer using facelet. --user_register.xhtml
1.  For Using CSS
Create a folder under root(WebContent) -- default name used is <resources> -- under this <css> for .css & <images> for storing images. (css & image folder names can be changed)

For applying CSS -- add under <h:head> the following
<h:outputStylesheet name="css/main.css" />

For using images -- can add under <h:body> the following.

<h:graphicImage library="images" name="lavenderflowers.png"/>

2. How to add messages to Faces Context ?
(API of javax.faces.context.FacesContext)
get Faces context current instance -- addMessage(String clntId,FacesMessage mesg)
& to display it from facelet 
<h:messages  showDetail="true" showSummary="true"/>

or 

<h:message for="clntId"  showDetail="true" showSummary="true"/>



2. Using JSF Tags -- h:dataTable

2.1 Create User Data bean(UserData) -- managed by JSF & place it in application scope, with eager=true.
(i.e. will be created @ application start up time) -- Currently populate Array List of emps in its constructor.--later can be replaced by db. 
API -- javax.faces.model -- DataModel<T> --abstract super class
Concrete sub-class -- for List based data model --- ListDataModel<E> , E -- type of model(pojo/dto)
Constructor 
public ListDataModel(java.util.List<E> list)
Using above , create instance of ListDataModel -- containg emp list.

OR simple List of employees also can be created.
2.2 View layer -- data-table.xhtml

3. Template driven approach
3.1 For storing templates -- create sub-folder under --root or web-inf.
<templates> -- folder name can be anything.
3.2 Create -- new facelet header,footer & template.
3.3 Create new facelet composition using above templates.


10. JSF - AJAX support
JSF supports Ajax by using built-in JavaScript  library that is included  as part of the JSF core libraries.
Can be used either  :
1.  f:ajax tag along with another Facelet standard component (eg : h:inputText)
This method adds Ajax functionality to any UI component without additional coding and configuration.
OR 
2 By  JavaScript API method jsf.ajax.request(), directly within the Facelets
application. This method provides direct access to Ajax methods, and allows customized control of component behavior.

Using f:ajax tag
Important attributes -- 
1. execute -- A Collection that identifies a list of components to be
executed on the server. Can supply space-delimited String of component identifiers in facelet appln and/or one of the keywords. If a ValueExpression is
specified, it must refer to a property that returns a
Collection of String objects. If not specified, the
default value is @this.
eg -- inp1 (comp id of textfield) inp2 (password field)
eg -- @this(default value),@form,@none,@all
eg --
<h:inputText id="userNo"
title="Type a number" value="#{numberBean.userNumber}">
</h:inputText>
<h:commandButton id="submit" value="Submit">
<f:ajax event="click" execute="userNo" />
</h:commandButton>
Meaning  -- h:inputText component with the id value of userNo
should be executed(i.e sent to server) when the button is clicked.

2. render --
After the application sends an Ajax request, it is processed on the server side, and a response is sent back to the client. Since ,  Ajax allows for partial updating of web pages, to enable such partial updating, JavaServer Faces technology allows for partial processing of the view. The handling of the response is defined by the render attribute of the f:ajax tag.
Similar to the execute attribute, the render attribute defines which sections of the page will be updated. The value of a render attribute can be one or more component id values, one of the keywords @this, @all, @none, and @form, or an EL expression A Collection that identifies a list of components to be
rendered to clnt.  If not specified, the default value is @this.
eg -- result (comp id of h:outputText) 
eg -- @this(default value),@form,@none,@all
eg -- 
<h:commandButton id="submit" value="Submit">
<f:ajax execute="userNo" render="result" />
</h:commandButton>
<h:outputText id="result" value="#{userNumberBean.response}" />


3. event --click, keyup, mouseover, focus, and blur.
The default event is action for ActionSource components such as a commandButton(submit btn)  and valueChange for EditableValueHolder comps(eg : textfield,password field,drop down list)
4. listener -- The listener attribute refers to a method expression that is executed on the server side in response to an Ajax action on the client
eg --
<f:ajax listener="#{mybean.someaction}" render="somecomponent" />
The following code represents the someaction method in mybean.
public void someaction(AjaxBehaviorEvent event) {
//......dosomething;
}


6. spring integration steps
6.1 Copy existing spring - hibernate project.
eg -- spring_hib
6.2 
Copy  jsf jars
6.3
Edit web.xml
1. Add FacesServlet entry
 <servlet>
    <servlet-name>Faces Servlet</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Faces Servlet</servlet-name>
    <url-pattern>/faces/*</url-pattern>
    <url-pattern>*.xhtml</url-pattern>
    <url-pattern>*.jsf</url-pattern>
  
  </servlet-mapping>
2. To create spring web application context -- earlier DispatcherServlet was doing the same job & was using servletName-servlet.xml.
Same has to be done using explicit -- Context listener
<listener>
        <listener-class>
            org.springframework.web.context.ContextLoaderListener
        </listener-class>
</listener>
<context-param>
    <param-name>contextConfigLocation</param-name>
 <param-value>
			/WEB-INF/spring-servlet.xml
		</param-value>
  </context-param>
For supporting request & session scope add following listener.
 <listener>
	<listener-class>
		org.springframework.web.context.request.RequestContextListener
	</listener-class>
  </listener>


6.4 Add project facet -- JSF 2.1-- so that it will create automatically(default) -- faces-config.xml --under <WEB-INF>.

6.5 Configure
JSF  EL Resolver Bean in faces-config.xml 

Configure this resolver in your faces-config.xml file as follows:

 <application>
<el-resolver>org.springframework.web.jsf.el.SpringBeanFacesELResolver</el-resolver>
 </application>

All your JSF expressions can then implicitly refer to the names of Spring-managed service layer beans.
6.6 Keep name of the master spring config file the same  -- spring-servlet.xml

6.7
Remove all mvc related stuff

6.8 Replace Controller Beans by JSF managed Bean.
NOTE : Do not even have to add annotation -- @ManagedBean
@Component  works.
Inject service layer bean in this & test entire flow.



JSF life cycle.
It involves --- the client makes a request for the web page, and the server responds with the page. 

Java EE 6 tutorial 
page no -- 211

Overview of the JavaServer Faces Lifecycle
The lifecycle of a JavaServer Faces application begins when the client makes an HTTP request for a page and ends when the server responds with the page, translated to HTML.

The lifecycle can be divided into two main phases, execute and render. The execute phase is further divided into subphases to support the sophisticated component tree. This structure requires that component data be converted and validated, component events be handled, and component data be propagated to beans in an orderly fashion.

A JavaServer Faces page is represented by a tree of components, called a view. During the lifecycle, the JavaServer Faces implementation must build the view while considering the state saved from a previous submission of the page. When the client requests a page, the JavaServer Faces implementation performs several tasks, such as validating the data input of components in the view and converting input data to types specified on the server side.

The JavaServer Faces implementation performs all these tasks as a series of steps in the JavaServer Faces request-response lifecycle.
-------------------
The lifecycle consists of two main phases: execute and render.

During the execute phase

1. The application view is built or restored.

2. The request parameter values are applied.

3. Conversions and validations are performed for component values.

4. Managed beans are updated with component values.

5. Application logic is invoked.

For a first (initial) request, only the view is built. For subsequent (postback) requests, some or all of the other actions can take place.

In the render phase, the requested view is rendered as a response to the client. Rendering is typically the process of generating output, such as HTML or XHTML, that can be read by the client, usually a browser.

Detailed Internals

Any JSF application goes through the following stages when it is deployed on the server.

1. When the application is built and deployed on the  server, the application is in an uninitiated state.

2. When a client makes an initial request for the hello.xhtml web page, the hello Facelets application is compiled.

3. The compiled Facelets application is executed, and a new component tree is constructed for the hello application and is placed in a javax.faces.context.FacesContext.

4. The component tree is populated with the component and the managed bean property associated with it, represented by the EL expression hello.message

5. A new view is built, based on the component tree.

6. The view is rendered to the requesting client as a response.

7. The component tree is destroyed automatically.

8. On subsequent (postback) requests, the component tree is rebuilt, and the saved state is applied.



Advantages
1. JSF is based on well established Model-View-Controller (MVC) design pattern. 
2. Applications developed using JSF frameworks are well designed and easy to maintain than any other
    applications developed in JSP and Servlets.
3. JSF provides standard, reusable components for creating user interfaces for web applications.
4. JSF provides many tag libraries for accessing and manipulating the components.
5. JSF is a specification and vendors can develop the implementations for JSF.



1. When a client, such as a browser, makes a new request to a page that is created using Facelets, a new component tree or UIViewRoot is created and placed in the FacesContext.
2. The UIViewRoot is applied to the Facelets, and the view is populated with components for rendering.
3. The newly built view is rendered back as a response to the client.
4. On rendering, the state of this view is stored for the next request. The state of input components and form data is stored.
5. The client may interact with the view and request another view or change from the JavaServer Faces application. At this time the saved view is restored from the stored state.
6. The restored view is once again passed through the JavaServer Faces lifecycle and eventually will either generate a new view or re-render the current view if there were no validation problems or no action was triggered.
7. If the same view is requested, the stored view is rendered once again.
8. If a new view is requested, then the process described in the second step is continued.
9. The new view is then rendered back as a response to the client.
