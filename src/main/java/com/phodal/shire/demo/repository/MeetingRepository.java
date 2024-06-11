package com.phodal.shire.demo.repository;

import com.phodal.shire.demo.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<BlogPost, Long> {

}
