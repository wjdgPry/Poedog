package com.shop.service;

import com.shop.dto.ReviewDto;
import com.shop.entity.Review;
import com.shop.entity.Item;
import com.shop.repository.ReviewRepository;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void saveReview(ReviewDto reviewDto, Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        Review review = new Review();
        review.setItem(item); // Item 객체를 설정
        review.setUsername(reviewDto.getUsername());
        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());
        reviewRepository.save(review);
    }

    public List<ReviewDto> getReviewsByItemId(Long itemId) {
        return reviewRepository.findByItemId(itemId).stream()
                .map(review -> {
                    ReviewDto dto = new ReviewDto();
                    dto.setId(review.getId());
                    dto.setUsername(review.getUsername());
                    dto.setContent(review.getContent());
                    dto.setRating(review.getRating());
                    return dto;
                })
                .toList();
    }
}