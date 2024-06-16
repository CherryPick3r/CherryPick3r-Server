package com.cherrypicker.cherrypick3r.tag.service;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagSearchService {

    private final TagRepository tagRepository;

    public Tag findTagById(Long id) {
        return tagRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 태그가 존재하지 않습니다."));
    }

}
