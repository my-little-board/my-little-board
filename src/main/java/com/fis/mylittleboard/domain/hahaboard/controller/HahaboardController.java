package com.fis.mylittleboard.domain.hahaboard.controller;

import com.fis.mylittleboard.domain.hahaboard.service.HahaboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class HahaboardController {

  private final HahaboardService hahaboardService;

}
