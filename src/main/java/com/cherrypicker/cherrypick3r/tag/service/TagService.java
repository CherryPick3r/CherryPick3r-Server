package com.cherrypicker.cherrypick3r.tag.service;

import com.cherrypicker.cherrypick3r.tag.domain.Tag;
import com.cherrypicker.cherrypick3r.tag.domain.TagRepository;
import com.cherrypicker.cherrypick3r.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {
    TagRepository tagRepository;

    @Transactional
    public Tag createTag() {
        Tag tag = new Tag();

        tag = tagRepository.save(tag);

        return tag;
    }

    @Transactional
    public TagDto findTagByTagId(Long id) {
        Tag tag = tagRepository.findById(id).get();

        return tag.toDto();
    }

    @Transactional
    public void deleteTagByTagId(Long id) {
        tagRepository.deleteById(id);
    }

    @Transactional
    public TagDto updateTagByTagId(Long id, List<Double> tagValues) {
        Tag tag = tagRepository.findById(id).get();

        if (tag == null) {
            return null; // TODO: TagNotFound 에러 핸들링 해야함
        }
        tag.setTagsByList(tagValues);
        tagRepository.save(tag);

        return findTagByTagId(id);
    }
}
