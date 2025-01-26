package me.yong.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.yong.domain.Article;
import me.yong.dto.AddArticleRequest;
import me.yong.dto.UpdateArticleRequest;
import me.yong.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest req) {
        return blogRepository.save(req.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findArticleById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public void deleteArticle(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article updateArticle(long id, UpdateArticleRequest req) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found " + id));
        article.update(req.getTitle(), req.getContent());
        return article;
    }
}
