package xlong.blogs.web.controller.api;

import xlong.blogs.model.domain.User;
import xlong.blogs.model.dto.JsonResult;
import xlong.blogs.model.enums.ResponseStatusEnum;
import xlong.blogs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     用户API
 * </pre>
 *
 */
@RestController
@RequestMapping(value = "/api/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    /**
     * 获取博主信息
     *
     * @return JsonResult
     */
    @GetMapping
    public JsonResult user() {
        User user = userService.findUser();
        return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), user);
    }
}
