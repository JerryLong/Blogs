package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Category;

/**
 * <pre>
 *     分类持久层
 * </pre>
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * 根据分类目录路径查询，用于验证是否已经存在该路径
     *
     * @param cateUrl cateUrl 文章url
     * @return Category
     */
    Category findCategoryByCateUrl(String cateUrl);
}
