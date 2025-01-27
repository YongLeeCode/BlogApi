package me.yong.blogView.blogViewDto;

import lombok.Getter;
import me.yong.domain.Article;

@Getter
public class ArticleListViewResponse {
    private Long id;
    private String title;
    private String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
