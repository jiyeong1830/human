//package com.example.firstproject.service;
//
//import com.example.firstproject.dto.CommentDto;
//import com.example.firstproject.entity.Article;
//import com.example.firstproject.entity.Comment;
//import com.example.firstproject.repository.ArticleRepository;
//import com.example.firstproject.repository.CommentRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//public class CommentService {
//    @Autowired
//    private CommentRepository commentRepository;
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    // 1. 댓글 리스트 조회
//    public List<CommentDto> comments(Long articleId) {
//        /*// 1. articleId에 해당하는 모든 댓글 조회
//        List<Comment> commentList = commentRepository.findByArticleId(articleId);
//
//        // 2. Entity -> DTO로 변환(Comment -> CommentDto)
//        List<CommentDto> dtos = new ArrayList<>();
//        for(int i = 0; i < commentList.size(); i++) {
//            Comment comment = commentList.get(i);
////            CommentDto dto = new CommentDto(
////                    comment.getId(),
////                    comment.getArticle().getId(),
////                    comment.getNickname(),
////                    comment.getBody()
////            );
//            CommentDto dto = CommentDto.createCommentDto(comment);
//            dtos.add(dto);
//        }*/
//        // Ctrl + Shift + /
//
//        // 3. List<CommentDto> 결과로 반환
//        return commentRepository.findByArticleId(articleId) // 1. 댓글 엔티티 목록 조회
//                .stream()   // 2. 댓글 엔티티 목록을 스트림으로 변환
//                .map(comment -> CommentDto.createCommentDto(comment))   // 3. 엔티티를 DTO로 매핑
//                .collect(Collectors.toList())  // 4. 스트림을 리스트로 변환
//                ;
//    }
//
//    // 2. 댓글 생성
//    @Transactional
//    public CommentDto create(Long articleId, CommentDto commentDto) {
//        // 1. 게시글 조회 및 존재 여부 확인 -> 없으면 예외 발생
//        Article article = articleRepository.findById(articleId).orElseThrow(
//                () -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다.")
//        );
//
//        // 2. 댓글 엔티티 생성
//        Comment comment = Comment.createComment(commentDto, article);
//
//        // 3. 댓글 엔티티를 DB에 저장
//        Comment created = commentRepository.save(comment);
//
//        // 4. DB에 저장한 엔티티를 DTO로 변환해 반환
//        return CommentDto.createCommentDto(created);
//    }
//
//    // 3. 댓글 수정
//    @Transactional
//    public CommentDto update(Long id, CommentDto commentDto) {
//        // 1. 댓글 조회 및 존재 여부 확인 -> 없으면 예외 발생
//        Comment target = commentRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다.")
//        );
//
//        // 2. 실제 댓글 수정
//        target.patch(commentDto);
//
//        // 3. 수정한 댓글을 DB에 저장
//        Comment updated = commentRepository.save(target);
//
//        // 4. DB에 저장한 엔티티를 DTO로 변환해 반환
//        return CommentDto.createCommentDto(updated);
//    }
//
//    // 4. 댓글 삭제
//    @Transactional
//    public CommentDto delete(Long id) {
//        // 1. 댓글 조회 및 예외 발생
//        Comment target = commentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! " +
//                        "대상이 없습니다."));
//
//        // 2. 댓글 삭제
//        commentRepository.delete(target);
//
//        // 3. 삭제 댓글을 DTO로 변환 및 반환
//        return CommentDto.createCommentDto(target);
//    }
//}
