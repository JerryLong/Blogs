package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Gallery;

/**
 * <pre>
 *     图库持久层
 * </pre>
 *
 */
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
