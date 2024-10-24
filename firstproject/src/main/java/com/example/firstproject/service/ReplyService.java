package com.example.firstproject.service;

import com.example.firstproject.models.dto.ReplyDto;
import com.example.firstproject.models.entity.Article;
import com.example.firstproject.models.entity.Reply;
import com.example.firstproject.dao.repository.ArticleRepository;
import com.example.firstproject.dao.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private ArticleRepository articleRepository;

    // 1. 댓글 리스트 조회
    public List<ReplyDto> replys(Long articleId) {
        /*// 1. articleId에 해당하는 모든 댓글 조회
        List<Reply> replyList = replyRepository.findByArticleId(articleId);

        // 2. Entity -> DTO로 변환(Reply -> ReplyDto)
        List<ReplyDto> dtos = new ArrayList<>();
        for(int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
//            ReplyDto dto = new ReplyDto(
//                    Reply.getId(),
//                    Reply.getArticle().getId(),
//                    Reply.getNickname(),
//                    Reply.getBody()
//            );
            ReplyDto dto = ReplyDto.createReplyDto(Reply);
            dtos.add(dto);
        }*/
        // Ctrl + Shift + /

        // 3. List<ReplyDto> 결과로 반환
        return replyRepository.findByArticleId(articleId) // 1. 댓글 엔티티 목록 조회
                .stream()   // 2. 댓글 엔티티 목록을 스트림으로 변환
                .map(Reply -> ReplyDto.createReplyDto(Reply))   // 3. 엔티티를 DTO로 매핑
                .collect(Collectors.toList())  // 4. 스트림을 리스트로 변환
                ;
    }

    // 2. 댓글 생성
    @Transactional
    public ReplyDto create(Long articleId, ReplyDto replyDto) {
        // 1. 게시글 조회 및 존재 여부 확인 -> 없으면 예외 발생
        Article article = articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다.")
        );

        // 2. 댓글 엔티티 생성
        Reply reply = Reply.createReply(replyDto, article);

        // 3. 댓글 엔티티를 DB에 저장
        Reply created = replyRepository.save(reply);

        // 4. DB에 저장한 엔티티를 DTO로 변환해 반환
        return ReplyDto.createReplyDto(created);
    }

    // 3. 댓글 수정
    @Transactional
    public ReplyDto update(Long id, ReplyDto ReplyDto) {
        // 1. 댓글 조회 및 존재 여부 확인 -> 없으면 예외 발생
        Reply target = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다.")
        );

        // 2. 실제 댓글 수정
        target.patch(ReplyDto);

        // 3. 수정한 댓글을 DB에 저장
        Reply updated = replyRepository.save(target);

        // 4. DB에 저장한 엔티티를 DTO로 변환해 반환
        return ReplyDto.createReplyDto(updated);
    }

    // 4. 댓글 삭제
    @Transactional
    public ReplyDto delete(Long id) {
        // 1. 댓글 조회 및 예외 발생
        Reply target = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! " +
                        "대상이 없습니다."));

        // 2. 댓글 삭제
        replyRepository.delete(target);

        // 3. 삭제 댓글을 DTO로 변환 및 반환
        return ReplyDto.createReplyDto(target);
    }
}
