package Laboratoriya.uchun.Laboratoriya.repository;

import Laboratoriya.uchun.Laboratoriya.model.Sozlar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface SozlarRepository extends CrudRepository<Sozlar,Long> {

    @Query(value = "select count(*) from sozlar", nativeQuery = true)
    Integer countAll();

    @Query(value = "select * from sozlar order by sozlar.id limit :limit offset :offset", nativeQuery = true)
    List<Sozlar> limit(@Param("limit") Integer limit, @Param("offset") Integer offset);

//    @Query(value = "select * from sozlar order by sozlar.id limit :limit offset :offset", nativeQuery = true)
//    List<Sozlar> search(@Param("limit") Integer limit, @Param("offset") Integer offset);

    @Query(value = "SELECT * from sozlar where position( lower(:keyword) in lower(sozlar.soz_togri))>0 or position( lower(:keyword) in lower(sozlar.soz_xato))>0 order by id;", nativeQuery = true)
    List<Sozlar> search(@Param("keyword") String keyword);

    @Query(value = "SELECT * from sozlar where position( lower(:keyword) in lower(sozlar.soz_togri))>0 or position( lower(:keyword) in lower(sozlar.soz_xato))>0 order by sozlar.id limit 20 offset :offset", nativeQuery = true)
    List<Sozlar> search2(@Param("keyword") String keyword, @Param("offset") Integer offset);

}
