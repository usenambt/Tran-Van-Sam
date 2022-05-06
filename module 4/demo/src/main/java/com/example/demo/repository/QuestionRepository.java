package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    //    Search String
    @Query("select q from Question q where (q.questionTitle like %:title%) and (:typeId is null or q.questionType.questionTypeId = :typeId)")
    Page<Question> findAllByTitleAndType(String title, Integer typeId, Pageable pageable);

//    // Search co Int = null
//    @Query("select q from Question q where (:id is null or q.questionId = :id) and (q.questionTitle like %:title%)")
//    List<Question> findAllByIdAndTitle(Integer id, String title);
}

