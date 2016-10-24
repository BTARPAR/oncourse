package oncourse.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import oncourse.model.Course;
import oncourse.model.dao.CourseDao;

@Controller
@SessionAttributes("course")
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @RequestMapping("/course/list.html")
    public String list( ModelMap models )
    {
        models.put( "courses", courseDao.getCourses() );
        return "course/list";
    }
    
    
    @RequestMapping(value = "/course/add.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		//"user"=modelAttribute
		models.put("addcourse", new Course());
		return "course/add";

	}
	
	@RequestMapping(value = "/course/add.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Course addcourse) {
		
		
		//save user into the database -- to store the data into database you need to create a method into UserDao
		addcourse = courseDao.saveCourse(addcourse);
		//redirect to list.html to show all the users
		return "redirect:list.html";

	}
    
    @RequestMapping(value = "/course/edit.html", method = RequestMethod.GET)
	public String edit(@RequestParam Long id,ModelMap models) {
		//to get a particular user from user model class you need to use its userDao class
		models.put("course", courseDao.getCourse(id));
		return "course/edit";

	}
	
	@RequestMapping(value = "/course/edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Course course, SessionStatus status) {
		
		
		//save user into the database -- to store the data into database you need to create a method into UserDao
		course = courseDao.saveCourse(course);
		status.setComplete();
		//redirect to list.html to show all the users
		return "redirect:list.html";

	}
	// UPDATE //DELETE
	
	
	@RequestMapping(value = "/course/delete.html")
	public String delete(@RequestParam Long id) {
		Course deletecourse = courseDao.getCourse(id);
		deletecourse.setObsolete(true);
		//save user into the database -- to store the data into database you need to create a method into UserDao
		deletecourse = courseDao.saveCourse(deletecourse);
		
		//redirect to list.html to show all the users
		return "redirect:list.html";

	}
	
}
