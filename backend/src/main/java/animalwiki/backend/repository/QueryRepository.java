package animalwiki.backend.repository;

import java.util.List;

public interface QueryRepository {

    List<String> searchFor(String query);
}
