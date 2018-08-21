package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xlong.blogs.model.domain.Options;

/**
 * <pre>
 *     系统设置持久层
 * </pre>
 *
 */
public interface OptionsRepository extends JpaRepository<Options, Long> {

    /**
     * 根据key查询单个option
     *
     * @param key key
     * @return Options
     */
    Options findOptionsByOptionName(String key);
}
