package xlong.blogs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Attachment;

/**
 * <pre>
 *     附件持久层
 * </pre>
 *
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    /**
     * 查询所有附件，分页
     *
     * @param pageable pageable
     * @return Page
     */
    @Override
    Page<Attachment> findAll(Pageable pageable);
}
