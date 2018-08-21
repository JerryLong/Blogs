package xlong.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xlong.blogs.model.domain.Logs;

import java.util.List;

/**
 * <pre>
 *     日志持久层
 * </pre>
 *
 */
public interface LogsRepository extends JpaRepository<Logs, Long> {

    /**
     * 查询最新的五条数据
     *
     * @return List
     */
    @Query(value = "SELECT * FROM t_logs ORDER BY log_created DESC LIMIT 5", nativeQuery = true)
    List<Logs> findTopFive();
}
