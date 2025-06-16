package com.arvind.companyms.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "REVIEWMS", url = "${review-service.url}")
public interface ReviewClient {
    @GetMapping("/reviews/averageRating")
    public Double getAverageRatingOfCompany(@RequestParam("companyId") Long companyId);
}
