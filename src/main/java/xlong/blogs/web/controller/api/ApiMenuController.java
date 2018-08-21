package xlong.blogs.web.controller.api;

import xlong.blogs.model.domain.Menu;
import xlong.blogs.model.dto.JsonResult;
import xlong.blogs.model.enums.ResponseStatusEnum;
import xlong.blogs.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 *     菜单API
 * </pre>
 *
 */
@RestController
@RequestMapping(value = "/api/menus")
public class ApiMenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单
     *
     * @return JsonResult
     */
    @GetMapping
    public JsonResult menus() {
        List<Menu> menus = menuService.findAllMenus();
        if (null != menus && menus.size() > 0) {
            return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), menus);
        } else {
            return new JsonResult(ResponseStatusEnum.EMPTY.getCode(), ResponseStatusEnum.EMPTY.getMsg());
        }
    }
}
