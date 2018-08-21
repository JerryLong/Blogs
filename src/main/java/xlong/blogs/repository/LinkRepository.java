package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Link;

/**
 * <pre>
 *     友情链接持久层
 * </pre>
 *
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
}
