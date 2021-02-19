package Laboratoriya.uchun.Laboratoriya.repository;

import Laboratoriya.uchun.Laboratoriya.model.SimpleTests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SimpleTestRepository extends JpaRepository<SimpleTests,Long> {

    SimpleTests findById(long id);

    @Query(value = "select count(*) from simple_tests", nativeQuery = true)
    Integer countAll();

    @Query(value = "select * from simple_tests order by simple_tests.id limit :limit offset :offset", nativeQuery = true)
    List<SimpleTests> limit(@Param("limit") Integer limit, @Param("offset") Integer offset);

//    @Query(value = "select * from simple_tests order by simple_tests.id limit :limit offset :offset", nativeQuery = true)
//    List<SimpleTests> search(@Param("search") Integer limit, @Param("offset") Integer offset);

    @Query(value = "SELECT * from simple_tests where position( lower(:keyword) in lower(simple_tests.savol))>0 or position( lower(:keyword) in lower(simple_tests.v1))>0 or position( lower(:keyword) in lower(simple_tests.v2))>0 or position( lower(:keyword) in lower(simple_tests.v3))>0 or position( lower(:keyword) in lower(simple_tests.v4t))>0 order by id", nativeQuery = true)
    Iterable<SimpleTests> search(@Param("keyword") String keyword);

    @Query(value = "SELECT * from simple_tests where position( lower(:keyword) in lower(simple_tests.savol))>0 or position( lower(:keyword) in lower(simple_tests.v1))>0 or position( lower(:keyword) in lower(simple_tests.v2))>0 or position( lower(:keyword) in lower(simple_tests.v3))>0 or position( lower(:keyword) in lower(simple_tests.v4t))>0 order by id limit 10 offset :offset", nativeQuery = true)
    Iterable<SimpleTests> search2(@Param("keyword") String keyword, @Param("offset") Integer offset);


}
