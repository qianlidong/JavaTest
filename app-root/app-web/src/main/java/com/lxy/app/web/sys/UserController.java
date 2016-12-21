package com.lxy.app.web.sys;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lxy.app.domain.sys.User;
import com.lxy.app.service.sys.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private Logger log = Logger.getLogger(getClass());

	@Autowired
	private UserService userService;// 注入业务接口

	@ModelAttribute
	public User getUser() {
		return new User();
	}

	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/userList")
	public String userList(ModelMap modelMap) {
		log.info("访问用户列表");
		// 打印一句话测试，不查数据库了
		List<User> users = userService.findAll();
		modelMap.addAttribute("users", users);
		return "modules/user/userList";
	}

	/**
	 * 根据主键查找用户
	 */
	@RequestMapping(value = "/getUserById")
	public String getUserById(@RequestParam long id, ModelMap modelMap) {
		log.info("id is :" + id);
		User user = userService.findById(id);
		log.info("user's name is :" + user.getName());
		modelMap.addAttribute("user", user);
		return "modules/user/userDetail";
	}

	/**
	 * 保存用户
	 */
	@RequestMapping(value = "/saveUser")
	public String saveUser(User user, RedirectAttributes redirectAttributes) {
		log.info("保存用户");
		userService.save(user);
		// 重定向后的提示信息，使用RedirectAttributes传递，在JSP页面可以用${message}获取
		// 提示信息只出现一次，刷新也不会重复提示，
		redirectAttributes.addFlashAttribute("message", "操作成功");

		// 重定向，防止表单重复提交
		return "redirect:/user/userList";// 相对于当前路径
	}

	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/userEdit")
	public String userEdit(ModelMap modelMap) {
		log.info("增加用户");
		// 打印一句话测试，不查数据库了
		return "modules/user/userEdit";
	}

}