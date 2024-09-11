package com.shop.controller;

import com.shop.dto.ReviewDto;
import com.shop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewDto reviewDto, @RequestParam Long itemId) {
        reviewService.saveReview(reviewDto, itemId);
    }

    @GetMapping("/{itemId}")
    public List<ReviewDto> getReviews(@PathVariable Long itemId) {
        return reviewService.getReviewsByItemId(itemId);
    }
}