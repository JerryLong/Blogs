package xlong.blogs.service;

import java.util.List;
import java.util.Optional;

import xlong.blogs.model.domain.Menu;

/**
 * <pre>
 *     菜单业务逻辑接口
 * </pre>
 *
 */
public interface MenuService {

    /**
     * 新增/修改菜单
     *
     * @param menu menu
     * @return Menu
     */
    Menu saveByMenu(Menu menu);

    /**
     * 查询所有菜单
     *
     * @return List
     */
    List<Menu> findAllMenus();

    /**
     * 删除菜单
     *
     * @param menuId menuId
     * @return Menu
     */
    Menu removeByMenuId(Long menuId);

    /**
     * 根据编号查询菜单
     *
     * @param menuId menuId
     * @return Optional
     */
    Optional<Menu> findByMenuId(Long menuId);
}
