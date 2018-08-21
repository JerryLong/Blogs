package xlong.blogs.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xlong.blogs.service.CommentService;

/**
 * <pre>
 *     评论API
 * </pre>
 *
 */
@RestController
@RequestMapping(value = "/api/comments")
public class ApiCommentController {

    @Autowired
    private CommentService commentService;
}
