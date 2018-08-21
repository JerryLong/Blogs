package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Menu;

/**
 * <pre>
 *     菜单持久层
 * </pre>
 *
 */
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
