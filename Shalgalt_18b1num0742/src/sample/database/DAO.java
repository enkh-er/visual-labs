package application.database;

import java.util.List;

public interface DAO <T>{
    //Ugugdsun id-aar ugugliin sangaas hailt hiine
    T findById(String id);

    //ugugdliin sangaas bvh elementiin utgiig butsaana
    List<T> findAll();

    //ugugliin sanruu ugugdul hadgalna
    boolean save(T t);
}
