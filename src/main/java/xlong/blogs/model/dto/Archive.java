package xlong.blogs.model.dto;

import lombok.Data;
import xlong.blogs.model.domain.Post;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     文章归档
 * </pre>
 *
 */
@Data
public class Archive implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 年份
     */
    private String year;

    /**
     * 月份
     */
    private String month;

    /**
     * 对应的文章数
     */
    private String count;

    /**
     * 对应的文章
     */
    private List<Post> posts;
}
