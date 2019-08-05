Upload / download Images 
Its a complete spring web mvc project.(eclipse project : spring_mvc_image_upload2 ) for uploading images from clnt & storing it NOT under web application folder structure BUT elsewhere on server folder structure.
(eg : e:\uploaded_contents)

You can import it directly & test.

Instructions to run

1. First upload few images , using the link.
2. Then list images , then choose one .


Note 
1. No index.jsp , under WebContent. Its kept under <views> itself.
Check  abc-servlet.xml , <mvc:view-controller> is  the tag added for that.
Meaning --Maps a simple (w/o actually writing a controller) view controller to a specific URL  pattern --   to render a response with a pre configured view.


2. Upload images & store it under (as per standard recommendation) on the server side folder .

Even if  you clean your project ,  images will NOT be deleted.

Flow : 
1. abc-servlet.xml
<mvc:view-controller path="/" view-name="index"/>
Meaning --
For incoming url pattern / -- use view name "index" --a logical view name --which gets translated to /web-inf/views/index.jsp 

1.1 In abc-servlet.xml 
<import resource="classpath:/file-upload.xml" /> --imports xml from <resources>
In file-upload.xml --
<bean id="multipartResolver"
class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
 <property name="maxUploadSize" value="8000000" />
</bean>
Above configures multipart resolver bean , with max upload size of 8MB.
You can change it as per your requirement

1.2 
<context:property-placeholder location="classpath:/app.properties"/>
Supplies the location of property file.
In property file

image_path=file:/e:/uploaded_contents/

1.3 Entry ---for handling static resources.

<mvc:resources location="${image_path}" mapping="/upload_images/**"/>
Above is to tell SC that if incoming url pattern is matching with /upload_images/ & anything below that , then its a static resource to be served from the location of the specidied ${image_path}  i.e  some server side folder.

1.4 
<mvc:resources location="/" mapping="/**"/>

Above is to tell SC that if incoming url pattern is matching with / & anything below that , then its a static resource to be served from the location "/" i.e the root of web appln.
If u are wondering --what if /list_images comes --not to worry --we alrdy have a controller assgined to it.

Order of above 2 (1.3 & 1.4) <mvc:resources> tag is important, otherwise it won't work since the mapping  /upload_images doesn't get mapped at all.


2. index.jsp -- File Upload link.
href -- file_upload 
URL generated - .../file_upload
3. 
FileUploadController
@RequestMapping(value = "/{path}") -- using path variable.
public String showForm(@PathVariable String path) {		
	return path;
}
Matches ANY pattern /path , currently path=file_upload --so FORWARDS user to /web-inf/views/file_upload.jsp  
NOTE : not added any model attribute to the model map.
3. file_upload.jsp
No spring form , just ordinary HTML form (spring <form:form> not needed since no model attribute is bound to the form)

<form method="post" enctype="multipart/form-data">
 Choose File to Upload : <input type="file" name="contents" /> 
 <input type="submit" value="Upload File" />
</form>

Important : Must choose enctype as multipart/form-data , to upload the content , method must be post & then use input type="file"

4. When form is submitted URL -- .../file_upload , method=post, so uploadFile of FileUploadController gets called.

FileUploadController 
Dependency Injection

@Value("${upload_image_path}")
private String imagePath;

@RequestMapping(value = "file_upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("contents") MultipartFile file, Model map, HttpServletRequest request) {
		String uploadLocation = imagePath;
		System.out.println(
				"in upload file " + file.getOriginalFilename() + " size " + file.getSize() + " " + uploadLocation);
		try {
			File dest=new File(uploadLocation, file.getOriginalFilename());
			//file transferred to server side folder 
			file.transferTo(dest);
			
		} catch (Exception e) {

			map.addAttribute("mesg", "File upload failed : " + e.getMessage());
			return "file_upload";
		}
		return "upload_succ";
	}
Meaning : 
4.1
API
org.springframework.web.multipart.MultipartFile --i/f

Implementing Class
CommonsMultipartFile --based on Apache Commons File upload (jar --commons file upload)

MultipartFile
Represents  an uploaded file received in a multipart request.
The file contents are either stored in memory or temporarily on disk. In either case, the user(controller method) is responsible for copying file contents in persisten manner(either within webapp under  webcontent or server side folder or db) . The temporary storages will be cleared at the end of request processing.

4.2 
 String uploadLocation = imagePath
 This sets the upload location to -- server side folder

 4.3 
 file.transferTo(new File(uploadLocation, file.getOriginalFilename()));

 API of MultiPartFile
 void transferTo(File dest) throws IOException,IllegalStateException
Transfers the received file to the given destination file.
If the destination file already exists, it will be deleted first.
If the multipart file doesn't exist (i.e its alrdy moved) --throws --IllegalStateException

In case of exceptions(failures) ,catch it --add exception mesg to model map & forward user to "file_upload.jsp" 
In case of success -- forward user to  "upload_succ.jsp" , to display success mesg.

5. Now for displaying images part (pre requisite : image has to be uploaded under the server side folder first)
index.jsp -- link -- "List Images" 
href -- list_images

	@RequestMapping(value = "/list_images")
	public String listImages(Model map, HttpServletRequest request) {
		System.out.println("in list images " + imagePath);
		File uploadLocationDir = new File(imagePath);
		System.out.println(uploadLocationDir.exists() + " " + uploadLocationDir.isDirectory() + " "
				+ uploadLocationDir.getAbsolutePath());
		
		String[] files = uploadLocationDir.list();
		System.out.println("files " + Arrays.toString(files));
		map.addAttribute("image_list", files);
		return "list_images";
	}
Meaning 
5.1 Create File instance(representing a folder) --pointing to server side folder
5.2 Store file names under that folder in model map & forward user to "list_images.jsp"

6. list_images.jsp
<form method="post">
  <c:forEach var="img" items="${requestScope.image_list}">
    <input type="radio" name="imgName" value="${img}" />${img}
 </c:forEach>
 <input type="submit" value="Choose" />
</form>
Meaning : ordinary HTML form (since no model attributes are bound). Attached for each to image list , user chooses a radio btn & submit the form.

7. FileUploadController
@RequestMapping(value = "/choose")
public String chooseImage(Model map, @RequestParam String imgName) {
		System.out.println("in choose img name " + imgName);
		map.addAttribute("img_name", imgName);
		return "show_image";
	}
Meaning : req param contains the image file name . so adding that in model map & forwarding user to "show_image.jsp"

8. In abc-servlet.xml
there are already <mvc:resources> entries.
<mvc:resources location="${image_path}" mapping="/upload_images/**"/>
<mvc:resources location="/" mapping="/**"/>

9. show_image.jsp
<img alt="No Image found" 	src="<spring:url value='/upload_images/${requestScope.img_name}'/>">
	

